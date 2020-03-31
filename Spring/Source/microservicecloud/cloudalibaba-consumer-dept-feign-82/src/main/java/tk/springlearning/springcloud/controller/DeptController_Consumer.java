package tk.springlearning.springcloud.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tk.springlearning.springcloud.entities.Dept;
import tk.springlearning.springcloud.service.DeptClientService;
import tk.springlearning.springcloud.service.NacosDeptClientService;

import java.util.List;

@RestController
public class DeptController_Consumer {

    //在microservicecloud-consumer-dept-80里面的controller，用的时Ribbon+RestTemplate来访问微服务 - 需要指定微服务名称
    //这里用的通过接口DeptClientService(Feign，定义在microservicecloud-api)来访问微服务 - 需要注入微服务接口
    @Autowired
    private NacosDeptClientService deptClientService;

    @RequestMapping(value="/consumer/dept/add")
    public boolean add(Dept dept){
        return deptClientService.add(dept);
    }

    @RequestMapping(value="/consumer/dept/get/{id}")
    //只有通过了限流的控制，才会进入业务逻辑方法, 所以一个请求过来，会先检测限流，如果不通过，调用blockHandler,否则调用业务方法，
    //然后一旦业务方法出现异常，就会调用fallback方法来兜底处理. 但是如果出现的异常在exceptionsToIgnore里面，那么fallback就不会
    //对其兜底处理，直接抛出错误页面.
    //如果所调用的微服务不可用，那么将会调用NacosDeptClientService里面所定义的FallbackFactory的fallback来兜底处理
    @SentinelResource(value = "fallback", //定义sentinel资源
            //业务逻辑出错，handleFallback方法来兜底处理
            fallback = "handleFallback",
            //sentinel限流处理，一旦超过定义在资源(fallback)上的限流阈值, 触发服务熔断，由方法blockHandler来进行服务降级
            blockHandler = "blockHandler",
            //列出一些不需要fallback对其兜底处理的异常
            exceptionsToIgnore = {IllegalArgumentException.class}
    )
    public Dept get(@PathVariable("id") Long id){

        if(id <= 0){
            throw new IllegalArgumentException("IllegalArgumentException, 非法参数异常!");
        }

        Dept dept = deptClientService.get(id);

        if(dept == null){
            throw new NullPointerException("NullPointerException, 没有对应id的记录!");
        }
        return dept;
    }

    //业务逻辑出错的兜底方法
    public Dept handleFallback(@PathVariable("id") Long id, Throwable e){
        return new Dept(id,e.getMessage(),"No DB Information");
    }

    //sentinel限流的兜底方法
    public Dept blockHandler(@PathVariable("id") Long id, BlockException exception){
        return new Dept(id,exception.toString(),"No DB Information");
    }

    @RequestMapping(value="/consumer/dept/list")
    public List<Dept> list(){
        return deptClientService.list();
    }

    @RequestMapping(value="/consumer/dept/discovery")
    public Object discovery(){
        return deptClientService.discovery();
    }
}
