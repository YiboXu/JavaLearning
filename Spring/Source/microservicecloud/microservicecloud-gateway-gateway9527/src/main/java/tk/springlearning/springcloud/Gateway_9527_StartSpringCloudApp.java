package tk.springlearning.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

//修改pom
//修改application.yml
//修改C:\Windows\System32\drivers\etc\hosts 添加映射 127.0.0.1       mygateway.com
//通过gateway访问微服务 http://mygateway.com:9527/dept/list
//路径的映射可以通过application.yml来配置，或者通过配置类(GatewayConfig.class)
@SpringBootApplication
@EnableEurekaClient
public class Gateway_9527_StartSpringCloudApp {
    public static void main(String[] args) {
        SpringApplication.run(Gateway_9527_StartSpringCloudApp.class,args);
    }
}
