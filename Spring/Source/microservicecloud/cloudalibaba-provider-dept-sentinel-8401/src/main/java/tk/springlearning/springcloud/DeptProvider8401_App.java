package tk.springlearning.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * 通过sentinel监控
 * 1. 引入cloud的一个新技术组件
 *        <!-- Nacos -->
 *         <dependency>
 *             <groupId>com.alibaba.cloud</groupId>
 *             <artifactId>spring-cloud-starter-alibaba-nacos-discovery</artifactId>
 *         </dependency>
 *         <dependency>
 *             <groupId>com.alibaba.cloud</groupId>
 *             <artifactId>spring-cloud-starter-alibaba-nacos-config</artifactId>
 *         </dependency>
 *         <!--sentinel -->
 *         <dependency>
 *             <groupId>com.alibaba.csp</groupId>
 *             <artifactId>sentinel-datasource-nacos</artifactId>
 *         </dependency>
 *         <dependency>
 *             <groupId>com.alibaba.cloud</groupId>
 *             <artifactId>spring-cloud-starter-alibaba-sentinel</artifactId>
 *         </dependency>
 * 2. 修改application.yml
 * spring:
 *   application:
 *     name: microservicecloud-dept
 *   cloud:
 *     #Alibaba Nacos
 *     nacos:
 *       discovery:
 *         server-addr: localhost:8848 # 注册中心
 *     sentinel:
 *       transport:
 *         dashboard: localhost:8080
 *         port: 8719
 *
 * management:
 *   endpoints:
 *     web:
 *       exposure:
 *         include: '*'
 * 3. 在主启动类上面标注@EnableDiscoveryClient
 */

@SpringBootApplication
@EnableDiscoveryClient   //开启服务发现
public class DeptProvider8401_App {
    public static void main(String[] args){
        SpringApplication.run(DeptProvider8401_App.class,args);
    }
}
