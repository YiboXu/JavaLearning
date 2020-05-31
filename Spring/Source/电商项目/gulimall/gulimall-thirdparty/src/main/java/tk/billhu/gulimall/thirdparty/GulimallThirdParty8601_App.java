package tk.billhu.gulimall.thirdparty;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class GulimallThirdParty8601_App {
    public static void main(String[] args) {
        SpringApplication.run(GulimallThirdParty8601_App.class,args);
    }
}
