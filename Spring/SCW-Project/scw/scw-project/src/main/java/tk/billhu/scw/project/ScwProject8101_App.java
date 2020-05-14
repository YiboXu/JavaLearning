package tk.billhu.scw.project;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableEurekaClient
@EnableDiscoveryClient   //开启服务发现
@MapperScan("tk.billhu.scw.project.mapper")
@EnableTransactionManagement
public class ScwProject8101_App {
    public static void main(String[] args){
        SpringApplication.run(ScwProject8101_App.class,args);
    }
}
