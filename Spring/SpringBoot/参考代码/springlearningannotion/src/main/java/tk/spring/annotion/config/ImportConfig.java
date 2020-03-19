package tk.spring.annotion.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import tk.spring.annotion.model.Color;
import tk.spring.annotion.model.Person;

@Configuration
//如果导入的类的构造方法有参数，spring会自动在容器中匹配类型相同的Bean来注入，如果找到多个跟参数类型相同的Bean，会报错
//如果导入的类的构造方法没有参数，spring会自动实例化并注入到容器中
//对于实现了ImportSelector接口的类(MyImportSelector.class)，还会注册其selectImports方法返回的全类名对应的Bean
//对于实现了ImportBeanDefinitionRegistrar接口的类(MyImportBeanDefinitionRegistrar),调用其registerBeanDefinitions方法来将需要的类注册到容器
//对于标注了@Configuration的类NestedConfig.class， 会将其里面所需要注入的组件都一起注入
@Import({Person.class, Color.class, MyImportSelector.class,MyImportBeanDefinitionRegistrar.class, NestedConfig.class})
public class ImportConfig {
    @Bean
    public String string(){
        return new String("test-string");
    }

    @Bean
    public Integer integer(){
        return new Integer(37);
    }
}
