package tk.spring.annotion.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import tk.spring.annotion.model.Person;

//通过@Import被注入，参考ImportConfig.class
@Configuration
public class NestedConfig {
    @Bean("NestedImportedPerson")
    public Person person(){
        return new Person("Nested-Person",100);
    }
}
