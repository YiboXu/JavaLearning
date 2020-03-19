package tk.spring.annotion;

import org.junit.Test;
import tk.spring.annotion.config.BeanPostProcessorConfig;

public class TestBeanPostProcessorConfig extends Base {
    public TestBeanPostProcessorConfig() {
        super(BeanPostProcessorConfig.class);
    }

    @Test
    public void test(){
        this.getBeanById("car");
        this.getBeanById("cat");
        this.close();
    }
}
