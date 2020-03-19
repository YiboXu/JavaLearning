package tk.spring.annotion.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;
import org.springframework.context.annotation.Configuration;
import tk.spring.annotion.controller.BookController;
import tk.spring.annotion.model.Color;
import tk.spring.annotion.model.Person;

@Configuration
@ComponentScan(value = {"tk.spring.annotion.dao","tk.spring.annotion.service","tk.spring.annotion.controller"})
public class AutowiredConfig {
    @Bean
    public BookController bookController(){
        return new BookController();
    }

    @Bean
    public Person person(){
        return new Person("bill",37);
    }

    @Bean("sofica")
    public Person person1(){
        return new Person("sofica",37);
    }

    @Bean
    public Color color(){
        Color color = new Color();
        System.out.println("Color "+ color+" is created");
        return color;
    }
}
