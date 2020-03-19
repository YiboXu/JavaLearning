package tk.spring.annotion;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import tk.spring.annotion.config.ScopeConfig;
import tk.spring.annotion.model.Person;

public class TestScope {
    private static Logger logger = LoggerFactory.getLogger(TestScope.class);

    @Test
    public void test01(){
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(ScopeConfig.class);
        Person p1 = (Person) applicationContext.getBean("person");
        Person p2 = (Person) applicationContext.getBean("person");

        if(p1.equals(p2)) {
            logger.info("p1 == p2");
        }else{
            logger.info("p1 != p2");
        }
    }
}
