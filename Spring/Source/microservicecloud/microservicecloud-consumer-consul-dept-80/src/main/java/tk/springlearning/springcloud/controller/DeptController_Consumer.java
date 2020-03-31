package tk.springlearning.springcloud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import tk.springlearning.springcloud.entities.Dept;

import java.util.List;

@RestController
public class DeptController_Consumer {
    //private static final String REST_URL_PREFIX = "http://localhost:8004";
    //通过application name到zookeeper里面找到可用的微服务地址来访问
    private static final String REST_URL_PREFIX = "http://microservicecloud-dept";
    /**
     * 使用restTemplate访问restful接口：
     * (url,requestMap,ResponseBean.class)这三个参数分别代表REST请求地址，请求参数,HTTP响应转换被转换成的对象类型.
     */
    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping(value="/consumer/dept/add")
    public boolean add(Dept dept){
        return restTemplate.postForObject(REST_URL_PREFIX+"/dept/add",dept,Boolean.class);
    }

    @RequestMapping(value="/consumer/dept/get/{id}")
    public Dept get(@PathVariable("id") Long id){
        return restTemplate.getForObject(REST_URL_PREFIX+"/dept/get/"+id,Dept.class);
    }

    @RequestMapping(value="/consumer/dept/list")
    public List<Dept> list(){
        return restTemplate.getForObject(REST_URL_PREFIX+"/dept/list",List.class);
    }

    //获取服务实例信息
    @RequestMapping(value="/consumer/dept/discovery")
    public Object discovery(){
        return restTemplate.getForObject(REST_URL_PREFIX+"/dept/discovery", Object.class);
    }
}
