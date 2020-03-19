package tk.spring.annotion.config;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import tk.spring.annotion.model.Person;

@Configuration
public class ScopeConfig {
    /**
     * @see ConfigurableBeanFactory#SCOPE_PROTOTYPE    "prototype"  单例  getBean的时候进行实例化并返回实例化的类
     * @see ConfigurableBeanFactory#SCOPE_SINGLETON    "singleton"  多例  容器初始化的时候就将实例类创建了，getBean的时候直接获取
     * @see org.springframework.web.context.WebApplicationContext#SCOPE_REQUEST   "request"  每个web request中创建一个实例
     * @see org.springframework.web.context.WebApplicationContext#SCOPE_SESSION   "session"  每个web session中创建一个实例
     *
     * 对于单例Bean，默认是再容器初始化的时候创建实例，也可以通过设置@Lazy来让单例Bean在获取的时候再进行实例化
     * @Lazy
     * @Scope(ConfigurableBeanFactory.SCOPE_SINGLETON)
     */
    @Lazy
    @Scope(ConfigurableBeanFactory.SCOPE_SINGLETON)
    @Bean
    public Person person(){
        return new Person("Sofica",37);
    }
}
