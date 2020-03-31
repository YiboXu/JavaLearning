package tk.springlearning.springcloud.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import tk.springlearning.springcloud.entities.Dept;

import java.util.List;

//一旦需要调用的微服务不可用，就调用类DeptClientServiceFallbackFactory所返回的服务(服务降级)
@FeignClient(value = "MICROSERVICECLOUD-DEPT", fallbackFactory = DeptClientServiceFallbackFactory.class)
public interface DeptClientService {
    @RequestMapping(value="/dept/add",method = RequestMethod.POST)
    public boolean add(Dept dept);
    @RequestMapping(value="/dept/get/{id}",method = RequestMethod.GET)
    public Dept get(@PathVariable("id") Long id);
    @RequestMapping(value="/dept/list",method = RequestMethod.GET)
    public List<Dept> list();
    @RequestMapping(value="/dept/timeout/{time}",method = RequestMethod.GET)
    public String timeout(@PathVariable("time") int time);
}
