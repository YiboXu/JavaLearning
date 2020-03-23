package tk.springlearning.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * eureka服务注册中心Module
 * 1. 引入cloud的一个新技术组件
 *   1.1 新增一个相关的maven坐标
 *           <dependency>
 *             <groupId>org.springframework.cloud</groupId>
 *             <artifactId>spring-cloud-starter-eureka-server</artifactId>
 *         </dependency>
 *   1.2 在主启动类上面标注@EnableEurekaServer
 *   1.3 java业务逻辑编码
 */
@SpringBootApplication
@EnableEurekaServer
public class EurekaServer7003_App {
    public static void main(String[] args) {
        SpringApplication.run(EurekaServer7003_App.class,args);
    }
}
