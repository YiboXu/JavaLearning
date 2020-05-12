package tk.billhu.scw.user;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableEurekaClient
@MapperScan("tk.billhu.scw.user.mapper")
@EnableDiscoveryClient   //开启服务发现
@EnableTransactionManagement
public class ScwUser8001_App {
    public static void main(String[] args){
        SpringApplication.run(ScwUser8001_App.class,args);
    }
}
