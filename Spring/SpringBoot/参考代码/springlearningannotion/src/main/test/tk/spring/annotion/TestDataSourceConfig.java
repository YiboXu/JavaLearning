package tk.spring.annotion;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import tk.spring.annotion.config.DataSourceConfig;

import java.util.Arrays;

public class TestDataSourceConfig{
    @Test
    public void test(){
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        //设置spring.profiles.active
        applicationContext.getEnvironment().setActiveProfiles("dev");
        applicationContext.register(DataSourceConfig.class);
        applicationContext.refresh();

        Logger logger = LogManager.getLogger(this.getClass());
        Arrays.stream(applicationContext.getBeanDefinitionNames()).forEach(logger::info);
    }
}
