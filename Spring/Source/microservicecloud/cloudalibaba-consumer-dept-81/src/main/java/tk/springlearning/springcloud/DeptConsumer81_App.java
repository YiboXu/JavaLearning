package tk.springlearning.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import tk.springlearning.myrule.MySelfRule;
import tk.springlearning.myrule.MySelfRule_HT;

@SpringBootApplication
@EnableDiscoveryClient
//使用自定义负载均衡的轮询规则,一定注意MySelfRule.class这个类不能放在启动类的包及子包下，否则不论访问哪个微服务，都会使用MySelfRule.class的轮询规则
@RibbonClient(name="microservicecloud-dept",configuration = MySelfRule.class)
//@RibbonClient(name="microservicecloud-dept",configuration = MySelfRule_HT.class)
public class DeptConsumer81_App {
    public static void main(String[] args){
        SpringApplication.run(DeptConsumer81_App.class,args);
    }
}
