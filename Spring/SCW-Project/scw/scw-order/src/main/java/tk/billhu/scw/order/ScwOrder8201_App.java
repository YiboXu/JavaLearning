package tk.billhu.scw.order;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableEurekaClient
@EnableDiscoveryClient   //开启服务发现
@MapperScan("tk.billhu.scw.order.mapper")
@EnableTransactionManagement
@EnableFeignClients
public class ScwOrder8201_App {
    public static void main(String[] args){
        SpringApplication.run(ScwOrder8201_App.class,args);
    }
}
