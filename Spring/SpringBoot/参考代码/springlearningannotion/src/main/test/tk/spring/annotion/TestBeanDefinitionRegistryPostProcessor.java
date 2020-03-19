package tk.spring.annotion;

import org.junit.Test;
import org.springframework.beans.factory.support.BeanDefinitionRegistryPostProcessor;
import tk.spring.annotion.ext.BeanDefinitionRegistryPostProcessorConfig;
import tk.spring.annotion.ext.MyBeanDefinitionRegistryPostProcessor;

public class TestBeanDefinitionRegistryPostProcessor extends Base {
    public TestBeanDefinitionRegistryPostProcessor() {
        super(BeanDefinitionRegistryPostProcessorConfig.class);
    }

    @Test
    public void test(){

    }
}
