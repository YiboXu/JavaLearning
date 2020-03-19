package tk.spring.annotion.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import tk.spring.annotion.model.Car;
import tk.spring.annotion.model.Cat;
import tk.spring.annotion.model.Person;

@Configuration
public class BeanPostProcessorConfig {
    @Bean
    public MyBeanPostProcessor beanPostProcessor(){
        return new MyBeanPostProcessor();
    }

    @Bean
    public MyBeanPostProcessor2 beanPostProcessor2(){
        return new MyBeanPostProcessor2();
    }

    @Bean(initMethod = "init", destroyMethod = "destroy")
    public Car car(){
        return new Car();
    }

    @Bean
    public Cat cat(){
        return new Cat();
    }
}
