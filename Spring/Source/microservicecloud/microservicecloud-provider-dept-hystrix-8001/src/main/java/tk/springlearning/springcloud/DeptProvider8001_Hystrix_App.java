package tk.springlearning.springcloud;

import com.netflix.hystrix.contrib.metrics.eventstream.HystrixMetricsStreamServlet;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.context.annotation.Bean;

/**
 * 服务提供端开启熔断器
 * 1. Controller中构造兜底的方法
 *     @RequestMapping(value="/dept/get/{id}",method = RequestMethod.GET)
 *     @HystrixCommand(fallbackMethod="processHystrix_Get")
 *     public Dept get(@PathVariable("id") Long id){
 *         Dept dept = deptService.get(id);
 *         if(dept == null){
 *             throw new RuntimeException("Department "+id+" does not exist!");
 *         }
 *         return dept;
 *     }
 *
 *     public Dept processHystrix_Get(@PathVariable("id") Long id){
 *         return new Dept(id,"No department information for id: "+id,"No database information for id: "+id);
 *     }
 *  2. 主程序类添加 @EnableHystrix
 */

@SpringBootApplication
@EnableEurekaClient
@EnableDiscoveryClient   //开启服务发现
@EnableHystrix //开启熔断器
public class DeptProvider8001_Hystrix_App {
    public static void main(String[] args){
        SpringApplication.run(DeptProvider8001_Hystrix_App.class,args);
    }

    /**
     * 此配置是为了服务监控而配置，与服务容错本身无观，springCloud 升级之后的坑
     * ServletRegistrationBean因为springboot的默认路径不是/hystrix.stream
     * 只要在自己的项目中配置上下面的servlet即可
     *
     * @return
     */
    @Bean
    public ServletRegistrationBean getServlet() {
        HystrixMetricsStreamServlet streamServlet = new HystrixMetricsStreamServlet();
        ServletRegistrationBean<HystrixMetricsStreamServlet> registrationBean = new ServletRegistrationBean<>(streamServlet);
        registrationBean.setLoadOnStartup(1);
        registrationBean.addUrlMappings("/actuator/hystrix.stream");
        registrationBean.setName("HystrixMetricsStreamServlet");
        return registrationBean;
    }
}
