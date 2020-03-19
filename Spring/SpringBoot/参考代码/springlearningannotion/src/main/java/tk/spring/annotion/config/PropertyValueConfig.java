package tk.spring.annotion.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import tk.spring.annotion.model.Member;

@Configuration
@PropertySource(value={"classpath:/application.properties"})
public class PropertyValueConfig {

    @Autowired
    private Environment env;

    @Value("${member.name}")
    private String name;
    @Value("${member.age}")
    private int age;

    @Bean
    public Member member(){
        Member member = new Member();
        member.setName(env.getProperty("member.name"));
        member.setAge(Integer.parseInt(env.getProperty("member.age")));

        return member;
    }

    @Bean
    public Member member1(){
        Member member = new Member();
        member.setName(name);
        member.setAge(age);
        return member;
    }
}
