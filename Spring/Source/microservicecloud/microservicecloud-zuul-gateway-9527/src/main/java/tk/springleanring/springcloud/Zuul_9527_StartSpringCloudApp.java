package tk.springleanring.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

//修改pom
//修改application.yml
//修改C:\Windows\System32\drivers\etc\hosts 添加映射 127.0.0.1       myzuul.com
//通过zuul访问微服务 http://myzuul.com:9527/microservicecloud-dept/dept/list
//还可以通过http://myzuul.com:9527/mydept/dept/list来访问，因为application.yml里面配置了映射，将microservicecloud-dept微服务映射到/mydept/**
//如果application.yml里面配置了zuul.prefix的话，还需要加上前缀， 比如http://myzuul.com:9527/springlearning/mydept/dept/list
@SpringBootApplication
@EnableZuulProxy
public class Zuul_9527_StartSpringCloudApp {
    public static void main(String[] args) {
        SpringApplication.run(Zuul_9527_StartSpringCloudApp.class,args);
    }
}
