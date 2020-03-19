package tk.spring.annotion.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import tk.spring.annotion.model.MyAware;

@Configuration
public class AwareConfig {
    @Bean
    public MyAware myAware(){
        return new MyAware();
    }
}
