package tk.spring.annotion;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import tk.spring.annotion.config.ComponentScanConfig;
import tk.spring.annotion.config.ComponentScanConfig;
import tk.spring.annotion.model.Person;

public class TestPerson {
    private static Logger logger = LoggerFactory.getLogger(TestPerson.class);

    public static void main(String[] args){
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(ComponentScanConfig.class);

        Person person = (Person) applicationContext.getBean("person");

        logger.info(person.toString());
    }
}
