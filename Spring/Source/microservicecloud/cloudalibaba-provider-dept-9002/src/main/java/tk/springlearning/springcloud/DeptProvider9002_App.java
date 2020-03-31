package tk.springlearning.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * 向Nacos服务注册中心注册自己为微服务
 * 1. 引入cloud的一个新技术组件
 * <dependency>
 *     <groupId>com.alibaba.cloud</groupId>
 *     <artifactId>spring-cloud-starter-alibaba-nacos-discovery</artifactId>
 * </dependency>
 * 2. 修改application.yml
 * spring:
 *   application:
 *     name: microservicecloud-dept
 *   cloud:
 *     nacos:
 *       discovery:
 *         server-addr: 127.0.0.1:8848
 *
 * management:
 *   endpoints:
 *     web:
 *       exposure:
 *         include: *
 * 3. 在主启动类上面标注@EnableDiscoveryClient
 * 4. java业务逻辑编码
 */

@SpringBootApplication
@EnableDiscoveryClient   //开启服务发现
public class DeptProvider9002_App {
    public static void main(String[] args){
        SpringApplication.run(DeptProvider9002_App.class,args);
    }
}
