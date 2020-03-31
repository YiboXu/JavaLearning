package tk.springlearning.springcloud.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import tk.springlearning.springcloud.entities.Dept;

import java.util.List;

@FeignClient(value = "microservicecloud-dept", fallbackFactory = NacosDeptClientServiceFallbackFactory.class)
public interface NacosDeptClientService {
    @RequestMapping(value="/dept/add",method = RequestMethod.POST)
    public boolean add(Dept dept);
    @RequestMapping(value="/dept/get/{id}",method = RequestMethod.GET)
    public Dept get(@PathVariable("id") Long id);
    @RequestMapping(value="/dept/list",method = RequestMethod.GET)
    public List<Dept> list();
    @RequestMapping(value="/dept/discovery",method = RequestMethod.GET)
    public Object discovery();
}
