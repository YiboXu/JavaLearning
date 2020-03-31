package tk.springlearning.springcloud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import tk.springlearning.springcloud.entities.Dept;
import tk.springlearning.springcloud.service.DeptClientService;

import java.util.List;

@RestController
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
}
