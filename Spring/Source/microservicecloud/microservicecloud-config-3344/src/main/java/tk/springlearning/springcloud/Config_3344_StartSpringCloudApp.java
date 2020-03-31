package tk.springlearning.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

/**
 * Config微服务需要最先启动，然后其他为服务会从Config微服务获取配置信息
 * 如果Eureka也需要读取Config的配置，那么在Config微服务的pom中不能加上 spring-cloud-starter-netflix-eureka-client
 * 另外注意一点，如果git上的配置更改了，那么读取配置的微服务都需要重启一次，才能读取到最新的配置
 * 如果避免重启来使新配置生效?
 * - 在各个需要读取配置的微服务pom里面添加
 *         <dependency>
 *             <groupId>org.springframework.boot</groupId>
 *             <artifactId>spring-boot-starter-actuator</artifactId>
 *         </dependency>
 * - 在读取配置的方法或对应的类上添加注解@RefreshScope  (一般添加到Controller类)
 * - bootstrap.xml中添加配置
 * #暴露监控端点
 * management:
 *   endpoints:
 *     web:
 *       exposure:
 *         include: "*"
 * - 然后再运维更在了git配置以后，还需要额外对每个需要更新的微服务做一个POST动作，来触发刷新
 *   curl -X POST "http://localhost:8001/actuator/refresh"
 * - 上面这种属于手动半自动更新，如果希望一次通知，自动刷新，需要用到BUS总线 (接着上面的步骤，继续做下面的步骤)
 * - 在config server (3344)的pom里面添加spring-cloud-bus-amqp的支持
 *         <dependency>
 *             <groupId>org.springframework.cloud</groupId>
 *             <artifactId>spring-cloud-starter-bus-amqp</artifactId>
 *         </dependency>
 * -修改config server (3344)的application.yml, 添加RabbitMQ配置以及暴露bus-refresh
 *
 * #RabbitMQ配置
 * rabbitmq:
 *   host: localhost
 *   port: 5672
 *   username: guest
 *   password: guest
 *
 * # 暴露bus刷新配置的端点
 * management:
 *   endpoints:
 *     web:
 *       exposure:
 *         include: "bus-refresh"
 *
 * - 对其它需要读取config server配置的微服务添加spring-cloud-bus-amqp的支持
 *           <dependency>
 *               <groupId>org.springframework.cloud</groupId>
 *               <artifactId>spring-cloud-starter-bus-amqp</artifactId>
 *           </dependency>
 *
 * - 对其它需要读取config server配置的微服务修改其bootstrap.yml,添加MQ配置
 * #RabbitMQ配置
 * rabbitmq:
 *   host: localhost
 *   port: 5672
 *   username: guest
 *   password: guest
 *
 * - 这样，只要在github里面提交的更新，只需要对config server做一个POST就可以了，其他的微服务会通过RabbitMQ接受到更新的消息，从而去从新读取并更新
 * curl -X POST "http://localhost:3344/actuator/bus-refresh"
 *
 * -如果指向让某些微服务进行更新，就在POST后面加上/${application-name}:${port}
 * curl -X POST "http://localhost:3344/actuator/bus-refresh/microservicecloud-config-dept-client:8001"
 * 上面就是只更新运行在端口8001的名字为microservicecloud-config-dept-client的微服务
 *
 * 最后需要注意一点，这种配置的更新并不能更改微服务的application name或port等等一些运行时配置，对于一些用来读取的参数时可以更新的
 *
 * 这个自动更新的流程如下
 * 1. 启动config server, 它里面配置的github的repository，同时它也会订阅MQ
 * 2. 启动其他微服务，他们里面配置了config server以及配置文件名字，这样他们启动的时候会通过config server找到github的repository，然后读取配置信息
 * 3. 同时，这些微服务还会监听MQ
 * 4. 当所有微服务启动后，如果需要更新配置文件，通过push更新到github
 * 5. 然后执行curl -X POST "http://localhost:3344/actuator/bus-refresh"后，config server将发送MQ消息给其他微服务
 * 6. 其他微服务由于订阅了MQ主题，所以config server发送消息后，他们就会收到，这样这些微服务就会从新连接config server里面的github来刷新配置
 */
@SpringBootApplication
@EnableConfigServer
public class Config_3344_StartSpringCloudApp {
    public static void main(String[] args) {
        SpringApplication.run(Config_3344_StartSpringCloudApp.class, args);
    }
}
