package tk.springlearning.springcloud.controller;

import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tk.springlearning.springcloud.entities.Dept;
import tk.springlearning.springcloud.service.DeptClientService;

import java.util.List;
import java.util.concurrent.TimeUnit;

@RestController
@DefaultProperties(defaultFallback = "deptGlobalFallbackMethod")
public class DeptController_Consumer {

    //在microservicecloud-consumer-dept-80里面的controller，用的时Ribbon+RestTemplate来访问微服务 - 需要指定微服务名称
    //这里用的通过接口DeptClientService(Feign，定义在microservicecloud-api)来访问微服务 - 需要注入微服务接口
    @Autowired
    private DeptClientService deptClientService;

    @RequestMapping(value="/consumer/dept/add")
    public boolean add(Dept dept){
        return deptClientService.add(dept);
    }

    @RequestMapping(value="/consumer/dept/get/{id}")
    public Dept get(@PathVariable("id") Long id){
        return deptClientService.get(id);
    }

    @RequestMapping(value="/consumer/dept/list")
    public List<Dept> list(){
        return deptClientService.list();
    }

    @RequestMapping(value="/consumer/dept/timeout/{time}")
    //如果timeout方法运行超时(3秒)或出错了，就调用timeoutHandle来处理
    @HystrixCommand(fallbackMethod = "timeoutHandle", commandProperties = {
            @HystrixProperty(name="execution.isolation.thread.timeoutInMilliseconds",value = "3000")})
    //@HystrixCommand
    public String timeout(@PathVariable("time") int time){
        int n = 1/time;
        return deptClientService.timeout(time);
    }

    public String timeoutHandle(@PathVariable("time") int time){
        if(time == 0)
            return "80程序运行出错，time="+time+", 请修正后重试!";
        else
            return "80系统繁忙，请稍后再试!";
    }

    //全部fallback方法，标注了注解@HystrixCommand的方法(但是里面没有指定fallback的),如果出现异常，转到下面的方法来执行.
    //对于没有标注@HystrixCommand的方法，一旦出现异常，没有兜底的方法来处理
    public String deptGlobalFallbackMethod(){
        return "Global异常，请稍后再试!";
    }
}
