package tk.spring.annotion.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import tk.spring.annotion.model.ColorFactoryBean;

@Configuration
public class FactoryBeanConfig {

    //这里注册的组件实际是上ColorFactoryBean.getObject()方法返回的Bean
    @Bean
    public ColorFactoryBean colorFactoryBean(){
        return new ColorFactoryBean();
    }
}
