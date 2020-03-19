package tk.spring.annotion;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import tk.spring.annotion.config.ComponentScanConfig;
import tk.spring.annotion.controller.PersonController;

import java.util.Arrays;

public class TestComponentScanConfig {
    private static Logger logger = LoggerFactory.getLogger(TestComponentScanConfig.class);

    @Test
    public void test01(){
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(ComponentScanConfig.class);
        //PersonController pc = (PersonController) applicationContext.getBean("personController");
        //pc.printPersonInfo();

        Arrays.stream(applicationContext.getBeanDefinitionNames()).forEach(logger::info);
    }
}
