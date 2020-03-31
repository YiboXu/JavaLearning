package tk.springlearning.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * 向zookeeper服务注册中心注册自己为微服务
 * 1. 引入cloud的一个新技术组件
 *   1.1 新增一个相关的maven坐标
 <!-- 将微服务provider侧注册进zookeeper -->
 <dependency>
    <groupId>org.springframework.cloud</groupId>
    <artifactId>spring-cloud-starter-zookeeper-discovery</artifactId>
    <exclusions>
        <!--先排除自带的zookeeper3.5.3-->
        <exclusion>
            <groupId>org.apache.zookeeper</groupId>
            <artifactId>zookeeper</artifactId>
        </exclusion>
    </exclusions>
 </dependency>
 <!--添加zookeeper3.4.6版本-->
 <dependency>
    <groupId>org.apache.zookeeper</groupId>
    <artifactId>zookeeper</artifactId>
 <  version>3.4.6</version>
 </dependency>
 *   1.2 在主启动类上面标注@EnableDiscoveryClient
 *   1.3 java业务逻辑编码
 *
 *   注意，一旦微服务终止，zookeeper里面注册的节点马上就消失了，这一点跟Eureka不一样.
 */

@SpringBootApplication
@EnableDiscoveryClient   //开启服务发现
public class DeptProvider8004_App {
    public static void main(String[] args){
        SpringApplication.run(DeptProvider8004_App.class,args);
    }
}
