package tk.spring.annotion.config;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import tk.spring.annotion.model.Car;
import tk.spring.annotion.model.Cat;

@Configuration
public class BeanLifeCycleConfig {
    //指定初始化方法和销毁方法， Bean的生命周期为: 构造函数-->初始化方法-->销毁方法
    @Bean(value = "car", initMethod = "init", destroyMethod = "destroy")
    public Car car(){
        return new Car();
    }

    @Bean("cat")
    public Cat cat(){
        return new Cat();
    }
}
