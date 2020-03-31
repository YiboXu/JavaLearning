package tk.springlearning.springcloud.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import tk.springlearning.springcloud.service.impl.FlowLimitService;

import java.util.concurrent.TimeUnit;

@RestController
public class FlowLimitController {
    private Logger log = LoggerFactory.getLogger(FlowLimitController.class);

    @Autowired
    private FlowLimitService flowLimitService;

    @GetMapping("/testA")
    public String testA(){
        log.info(Thread.currentThread().getName()+" is invoking testA()");
        return "-------testA-------"+flowLimitService.getOrder();
    }

    @GetMapping("/testB")
    public String testB(){
        log.info(Thread.currentThread().getName()+" is invoking testB()");
        return "-------testB-------"+flowLimitService.getOrder();
    }

    @GetMapping("/testC")
    public String testC(){
        try {
            TimeUnit.SECONDS.sleep(1);
            log.info(Thread.currentThread().getName()+" is invoking testC()");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "-------testC-------"+flowLimitService.getOrder();
    }

    @GetMapping("/testD")
    public String testD(){
        int n = 10/0;
        return "-------testD-------"+flowLimitService.getOrder();
    }

    @GetMapping("/testE")
    @SentinelResource(value="testE",blockHandler = "handle_testE")
    //当不满足热点资源限流的配置规则时，调用blockHandler来兜底处理
    public String testE(@RequestParam(value = "p1",required = false) String p1,@RequestParam(value = "p2",required = false) String p2){
        return "-------testE-------"+flowLimitService.getOrder();
    }

    //注意一定要加上参数BlockException exception
    public String handle_testE(String p1, String p2, BlockException exception){
        return "-------Handle_testE-------"+exception.toString();
    }
}
