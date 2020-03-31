package tk.springlearning.springcloud.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;
import tk.springlearning.springcloud.entities.Dept;
import tk.springlearning.springcloud.myHandler.CustomerBlockHandler;
import tk.springlearning.springcloud.service.DeptService;

import java.util.Arrays;
import java.util.List;

@RestController
public class RateLimitController {
    @Autowired
    private DeptService deptService;

    @Autowired
    private DiscoveryClient discoveryClient;

    @PostMapping(value= "/dept/add")
    public boolean add(@RequestBody Dept dept){
        return deptService.add(dept);
    }

    @GetMapping(value="/dept/get/{id}")
    public Dept get(@PathVariable("id") Long id){
        return deptService.get(id);
    }

    @RequestMapping(value = "/dept/list",method = RequestMethod.GET)
    //如果超过流控，将会调用方法handle_list方法来处理，否则通过sentinel默认处理方法,返回"Blocked by Sentinel (flow limiting)"
    @SentinelResource(value = "list", blockHandler = "handle_list")
    public List<Dept> list(){
        return deptService.list();
    }

    public List<Dept> handle_list(BlockException exception){
        return Arrays.asList(new Dept((long)0,exception.toString(),"资源不可用"));
    }

    @GetMapping(value = "/dept/discovery")
    //如果超过流控，通过sentinel默认处理方法,返回"Blocked by Sentinel (flow limiting)"
    @SentinelResource(value = "list")
    public Object discovery(){
        return this.discoveryClient;
    }

    //通过定义handler类来统一处理流控
    //好处: 1. 将流控处理和业务逻辑关联起来,默认的流控处理就只返回一个字符串"Blocked by Sentinel (flow limiting)"
    //      2. 将业务逻辑和流控处理解耦，分开处理
    //      3. 避免了代码膨胀
    @GetMapping(value = "/dept/customerBlockHandler/list")
    //如果超过流控，将会调用CustomerBlockHandler.class这个类里的方法customerBlockHandler1来处理
    //注意方法customerBlockHandler1的签名需要和下面的customerBlockHandler1一样并且加上BlockException exception
    @SentinelResource(value="customerBlockHandler",
            blockHandlerClass = CustomerBlockHandler.class,
            blockHandler = "customerBlockHandler1")
    public List<Dept> customerBlockHandler1(){
        return deptService.list();
    }

    @GetMapping(value = "/dept/customerBlockHandler/get/{id}")
    //如果超过流控，将会调用CustomerBlockHandler.class这个类里的方法customerBlockHandler2来处理
    //注意方法customerBlockHandler2的签名需要和下面的customerBlockHandler2一样并且加上BlockException exception
    @SentinelResource(value="customerBlockHandler",
            blockHandlerClass = CustomerBlockHandler.class,
            blockHandler = "customerBlockHandler2")
    public Dept customerBlockHandler2(@PathVariable("id") Long id){
        return deptService.get(id);
    }
}
