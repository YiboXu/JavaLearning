package tk.springleanring.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

/**
 * 1. 在被监控的微服务的主启动类中添加下面的代码
 *     @Bean
 *     public ServletRegistrationBean getServlet() {
 *         HystrixMetricsStreamServlet streamServlet = new HystrixMetricsStreamServlet();
 *         ServletRegistrationBean<HystrixMetricsStreamServlet> registrationBean = new ServletRegistrationBean<>(streamServlet);
 *         registrationBean.setLoadOnStartup(1);
 *         registrationBean.addUrlMappings("/actuator/hystrix.stream");
 *         registrationBean.setName("HystrixMetricsStreamServlet");
 *         return registrationBean;
 *     }
 * 2. 启动eureka,微服务(8001),hystrix-dashboard(9001)
 * 3. 打开http://localhost:9001/hystrix, 输入http://localhost:8001/actuator/hystrix.stream以及下面的间隔时间2000，名字demo01
 * 4. 注意，dashboard只能监控微服务中标注了@HystrixCommand的方法访问
 * 5. 访问一个标注了@HystrixCommand的路径, 比如http://localhost:8001/dept/get/1
 * 6. 然后就可以在dashboard中查看监控结果了
 */
@SpringBootApplication
@EnableEurekaClient
@EnableHystrixDashboard
public class DeptConsumer_DashBoard_App {
    public static void main(String[] args) {
        SpringApplication.run(DeptConsumer_DashBoard_App.class,args);
    }
}
