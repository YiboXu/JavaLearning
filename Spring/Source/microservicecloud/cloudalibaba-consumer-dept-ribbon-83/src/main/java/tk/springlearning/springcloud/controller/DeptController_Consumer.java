package tk.springlearning.springcloud.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import tk.springlearning.springcloud.entities.Dept;

import javax.annotation.Resource;
import java.util.List;

/**
 * 2种方式访问微服务
 * 1. restTemplate+@LoadBalance (也就是示例中的访问方式)
 *    注意ConfigBean里，RestTemplate上必须加上注解@LoadBalanced
 * 2. 通过loadBalancerClient获取访问的微服务地址，然后通过restTemplate(不加@LoadBalance)来访问
 *  controller类注入:
 *     //@Autowired
 *     //private LoadBalancerClient loadBalancerClient;
 * controller方法里面执行:
 * ServiceInstance serviceInstance = loadBalancerClient.choose(serviceAppName);
 * String path = String.format("http://%s:%s/dept/get/%s",serviceInstance.getHost(),serviceInstance.getPort(),id);
 * restTemplate.getForObject(path,Dept.class);
 */
@RestController
public class DeptController_Consumer {
    @Value("${service-url.nacos-dept-service}")
    private String serviceAppName;

    @Value("${consumer.version}")
    private String consumerVersion;

    /**
     * 使用restTemplate访问restful接口：
     * (url,requestMap,ResponseBean.class)这三个参数分别代表REST请求地址，请求参数,HTTP响应转换被转换成的对象类型.
     */
    @Resource
    private RestTemplate restTemplate;

    @RequestMapping(value="/consumer/dept/add")
    public boolean add(Dept dept){

        return restTemplate.postForObject("http://"+serviceAppName+"/dept/add",dept, Boolean.class);
    }

    @RequestMapping(value="/consumer/dept/get/{id}")
    //只有通过了限流的控制，才会进入业务逻辑方法, 所以一个请求过来，会先检测限流，如果不通过，调用blockHandler,否则调用业务方法，
    //然后一旦业务方法出现异常，就会调用fallback方法来兜底处理. 但是如果出现的异常在exceptionsToIgnore里面，那么fallback就不会
    //对其兜底处理，直接抛出错误页面.
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

        Dept dept = restTemplate.getForObject("http://"+serviceAppName+"/dept/get/"+id,Dept.class);

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
        return restTemplate.getForObject("http://"+serviceAppName+"/dept/list",List.class);
    }

    //获取服务实例信息
    @RequestMapping(value="/consumer/dept/discovery")
    public Object discovery(){
        return restTemplate.getForObject("http://"+serviceAppName+"/dept/discovery",Object.class);
    }

    @RequestMapping(value="/consumer/dept/version")
    public String version(){
        return "consumer version: "+ consumerVersion;
    }

    @GetMapping(value = "/consumer/dept/customerBlockHandler/list")
    public List<Dept> customerBlockHandler1(){
        return restTemplate.getForObject("http://"+serviceAppName+"/dept/customerBlockHandler/list",List.class);
    }

    @GetMapping(value = "/consumer/dept/customerBlockHandler/get/{id}")
    public Dept customerBlockHandler2(@PathVariable("id") Long id){
        return restTemplate.getForObject("http://"+serviceAppName+"/dept/customerBlockHandler/get/"+id,Dept.class);
    }
}
