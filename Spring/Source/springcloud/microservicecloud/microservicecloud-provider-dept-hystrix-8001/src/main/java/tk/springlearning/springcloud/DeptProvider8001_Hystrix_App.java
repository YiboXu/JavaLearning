package tk.springlearning.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;

/**
 * 向eureka服务注册中心注册自己为微服务
 * 1. 引入cloud的一个新技术组件
 *   1.1 新增一个相关的maven坐标
 *           <!-- 将微服务provider侧注册进eureka -->
 *         <dependency>
 *             <groupId>org.springframework.cloud</groupId>
 *             <artifactId>spring-cloud-starter-eureka</artifactId>
 *         </dependency>
 *         <dependency>
 *             <groupId>org.springframework.cloud</groupId>
 *             <artifactId>spring-cloud-starter-config</artifactId>
 *         </dependency>
 *   1.2 在主启动类上面标注@EnableEurekaClient
 *   1.3 java业务逻辑编码
 */

@SpringBootApplication
@EnableEurekaClient
@EnableDiscoveryClient   //开启服务发现
@EnableHystrix //开启熔断器
public class DeptProvider8001_Hystrix_App {
    public static void main(String[] args){
        SpringApplication.run(DeptProvider8001_Hystrix_App.class,args);
    }
}
