package tk.spring.annotion.ext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import tk.spring.annotion.model.Blue;

@Configuration
@ComponentScan("tk.spring.annotion.ext")
public class ApplicationListenerConfig {
    @Autowired
    private MyAware myAware;

    @Bean
    public Blue blue(){
        return new Blue();
    }
}
