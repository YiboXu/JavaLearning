package tk.springlearning.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * 向consul服务注册中心注册自己为微服务
 */

@SpringBootApplication
@EnableDiscoveryClient   //开启服务发现
public class DeptProvider8005_App {
    public static void main(String[] args){
        SpringApplication.run(DeptProvider8005_App.class,args);
    }
}
