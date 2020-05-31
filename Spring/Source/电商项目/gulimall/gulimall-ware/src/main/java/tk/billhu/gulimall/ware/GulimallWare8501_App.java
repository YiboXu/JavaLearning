package tk.billhu.gulimall.ware;

import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableDiscoveryClient
@EnableTransactionManagement
//指定OpenFeign接口所在的包，如果不指定，就从当前包下查找
@EnableFeignClients(basePackages = "tk.billhu.gulimall.common.service")
public class GulimallWare8501_App {
    public static void main(String[] args) {
        SpringApplication.run(GulimallWare8501_App.class,args);
    }

    //Mybatis-Plus 分页插件
    @Bean
    public PaginationInterceptor paginationInterceptor(){
        return new PaginationInterceptor();
    }
}
