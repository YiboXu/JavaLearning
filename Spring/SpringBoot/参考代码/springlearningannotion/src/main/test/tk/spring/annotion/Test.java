package tk.spring.annotion;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.type.AnnotationMetadata;
import tk.spring.annotion.config.BeanPostProcessorConfig;

public class Test {
    @org.junit.Test
    public void test(){
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(BeanPostProcessorConfig.class);

    }
}
