package tk.spring.annotion.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import tk.spring.annotion.model.Person;
import tk.spring.annotion.service.PersonService;

@Configuration
//默认情况下，spring会将ComponentScan指定的包下的所有的类拿出来扫描，如果类被注解为@Component @Repository @Service @Controller,就会被注入到spring容器中
//我们指定了扫描包后，还可以指定一个过滤规则来过滤被扫描的类，下面就是各种示例

//扫描"tk.spring.annotion"中的组件，但是只包含标注了@Repository的组件
//@ComponentScan(value="tk.spring.annotion",useDefaultFilters = false, includeFilters = {@ComponentScan.Filter(type=FilterType.ANNOTATION, classes={Repository.class})})

//扫描"tk.spring.annotion"中的下列组件：
// - 标注了@Repository的组件
// - 类型为PersonService.class的组件
/*
@ComponentScan(value="tk.spring.annotion", useDefaultFilters = false,
        includeFilters = {@ComponentScan.Filter(type=FilterType.ANNOTATION,classes={Repository.class}),
                          @ComponentScan.Filter(type=FilterType.ASSIGNABLE_TYPE,classes={PersonService.class})
})
*/

//扫描"tk.spring.annotion"中的组件，但是排除标注了@Controller和@Service的组件
//@ComponentScan(value="tk.spring.annotion",excludeFilters={@ComponentScan.Filter(type=FilterType.ANNOTATION,classes={Controller.class,Service.class})})

//自定义包扫描过滤规则
//@ComponentScan(value="tk.spring.annotion",useDefaultFilters = false, includeFilters = @ComponentScan.Filter(type = FilterType.CUSTOM,classes={MyTypeFilter.class}))

//扫描"tk.spring.annotion"下的所有组件
@ComponentScan(value="tk.spring.annotion")
public class ComponentScanConfig {
    //给容器中注册一个Bean,类型为返回值的类型, id默认是用方法名，也可以通过 @Bean("bean_id")来指定id
    @Bean
    public Person person(){
        return new Person("Billhu",37);
    }
}
