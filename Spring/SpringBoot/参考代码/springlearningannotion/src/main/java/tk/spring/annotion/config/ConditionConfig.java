package tk.spring.annotion.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;
import tk.spring.annotion.model.Person;

@Configuration
public class ConditionConfig {
    //满足条件才会实例化
    @Conditional(WindowsCondition.class)
    @Bean("Bill")
    public Person person01(){
        return new Person("Bill Gates",62);
    }

    //满足条件才会实例化
    @Conditional(LinuxCondition.class)
    @Bean("Linus")
    public Person person02(){
        return new Person("Linus",48);
    }
}
