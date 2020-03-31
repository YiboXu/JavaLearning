package tk.springlearning.springcloud.service.impl;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import org.springframework.stereotype.Service;

import java.util.UUID;
import java.util.concurrent.TimeUnit;

@Service
public class FlowLimitService {
    @SentinelResource("getOrder")
    public String getOrder(){
        //System.out.println(Thread.currentThread().getName()+" is invoking getOrder()");
        return "Order-"+ UUID.randomUUID().toString();
    }
}
