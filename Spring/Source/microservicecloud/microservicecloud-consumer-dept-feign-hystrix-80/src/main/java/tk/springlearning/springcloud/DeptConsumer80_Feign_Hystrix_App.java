package tk.springlearning.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import tk.springleanring.myrule.MySelfRule;

@SpringBootApplication
@EnableFeignClients
@EnableHystrix //开启熔断器
//指定负载均衡策略，可以去掉，然后就用默认的轮询
//@RibbonClient(name="MICROSERVICECLOUD-DEPT",configuration = MySelfRule.class)
public class DeptConsumer80_Feign_Hystrix_App {
    public static void main(String[] args){
        SpringApplication.run(DeptConsumer80_Feign_Hystrix_App.class,args);
    }
}
