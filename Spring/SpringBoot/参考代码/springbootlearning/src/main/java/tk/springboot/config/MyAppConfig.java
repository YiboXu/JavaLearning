package tk.springboot.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import tk.springboot.model.MyPerson;

import java.util.Date;

/**
 * @Configuration指明当前类是一个配置类，相当于一个spring的xml配置文件
 */
@Configuration
public class MyAppConfig {
    @Bean("myPerson")
    public MyPerson myPerson(){
        MyPerson person = new MyPerson();
        person.setName("myname");
        person.setAge(10);
        person.setBirth(new Date("1983/01/20"));

        return person;
    }
}
