package tk.spring.annotion.aop;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@EnableAspectJAutoProxy
public class AutoAspectConfig {
    @Bean
    public AutoAspectLog autoAspectLog(){
        return new AutoAspectLog();
    }

    @Bean
    public UserService userService(){
        return new AutoAspectUserServiceImpl();
    }
}
