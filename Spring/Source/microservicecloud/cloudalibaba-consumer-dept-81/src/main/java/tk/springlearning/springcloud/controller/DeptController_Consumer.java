package tk.springlearning.springcloud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
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
@RefreshScope//实现配置自动更新
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
    public Dept get(@PathVariable("id") Long id){

        return restTemplate.getForObject("http://"+serviceAppName+"/dept/get/"+id,Dept.class);
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
}
