package tk.springlearning.springcloud.controller;

import cn.hutool.core.util.IdUtil;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;
import tk.springlearning.springcloud.entities.Dept;
import tk.springlearning.springcloud.service.DeptService;

import java.util.List;
import java.util.concurrent.TimeUnit;

@RestController
public class DeptController {
    @Autowired
    private DeptService deptService;

    @Autowired
    private DiscoveryClient discoveryClient;

    @RequestMapping(value= "/dept/add",method = RequestMethod.POST)
    public boolean add(@RequestBody Dept dept){
        return deptService.add(dept);
    }

    //================服务熔断========================
    @RequestMapping(value="/dept/get/{id}",method = RequestMethod.GET)
    //@HystrixProperty里面的配置参数参考HystrixCommandProperties.class
    //这个配置的效果就是，一旦10秒内，10次调用中如果多余60%的调用失败(没有对应的id的dept)，那么启动服务熔断，
    // 这样，后面就算出现一个合法的id来调用这个服务，那么也不会正常调用，因为服务熔断后自动降级了，需要等sleepWindowInMilliseconds
    //所设定的时间间隔后，会再次尝试，如果成功，服务恢复
    @HystrixCommand(fallbackMethod="processHystrix_Get", commandProperties = {
            @HystrixProperty(name = "circuitBreaker.enabled", value = "true"),// 是否开启断路器
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "10"),// 请求次数
            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds", value = "10000"),// 时间窗口期/时间范文
            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage", value = "60")// 失败率达到多少后跳闸
    })
    public Dept get(@PathVariable("id") Long id){
        Dept dept = deptService.get(id);
        if(dept == null){
            throw new RuntimeException("Department "+id+" does not exist!");
        }

        String serialNumber = IdUtil.simpleUUID();
        System.out.println(Thread.currentThread().getName()+"\t"+"调用成功， 流水号: "+serialNumber);

        return dept;
    }

    public Dept processHystrix_Get(@PathVariable("id") Long id){
        return new Dept(id,"No department information for id: "+id,"No database information for id: "+id);
    }

    @HystrixCommand
    @RequestMapping(value = "/dept/list",method = RequestMethod.GET)
    public List<Dept> list(){

        return deptService.list();
    }

    @RequestMapping(value = "/dept/discovery", method = RequestMethod.GET)
    public Object discovery(){
        return this.discoveryClient;
    }

    @RequestMapping(value = "/dept/timeout/{time}", method = RequestMethod.GET)
    //================服务降级===================================
    //如果timeout方法运行超时(3秒)或出错了，就调用timeoutHandle来处理
    @HystrixCommand(fallbackMethod = "timeoutHandle", commandProperties = {
            @HystrixProperty(name="execution.isolation.thread.timeoutInMilliseconds",value = "5000")})
    public String timeout(@PathVariable("time") int time){

        //模拟程序运行出错，访问的时候指定time=0；
        int n = 1/time;

        //模拟一个复杂的逻辑处理
        try {
            TimeUnit.SECONDS.sleep(time);
        } catch (InterruptedException e) {
        }
        return "Timeout process is completed successfully!";
    }

    public String timeoutHandle(@PathVariable("time") int time){
        if(time == 0)
            return "8001程序运行出错，time="+time+", 请修正后重试!";
        else
            return "8001系统繁忙，请稍后再试!";
    }
}
