package tk.spring.annotion;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.env.Environment;
import tk.spring.annotion.config.ConditionConfig;
import tk.spring.annotion.model.Person;

import java.util.Arrays;
import java.util.Map;

public class TestCondition {
    private static Logger logger = LoggerFactory.getLogger(TestScope.class);

    @Test
    public void test(){
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(ConditionConfig.class);
        Environment environment = applicationContext.getEnvironment();
        //environment里面包含了系统环境变量，也就是System.getProperties()里面所包含的
        logger.info(environment.getProperty("os.name"));
        //System.getProperties().entrySet().stream().map(x->x.toString()).forEach(logger::info);

        //获取所有的实例话的Bean名字
        logger.info("所有实例化了的Bean的名字");
        String[] beanNames = applicationContext.getBeanNamesForType(Person.class);
        Arrays.stream(beanNames).forEach(logger::info);

        //获取所有实例化了的Bean实例
        logger.info("所有实例化了的Bean");
        Map<String,Person> beans = applicationContext.getBeansOfType(Person.class);
        beans.entrySet().stream().map(element -> element.toString()).forEach(logger::info);


    }
}
