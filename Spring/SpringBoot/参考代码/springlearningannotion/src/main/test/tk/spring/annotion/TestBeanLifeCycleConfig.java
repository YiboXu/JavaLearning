package tk.spring.annotion;

import org.junit.Test;
import tk.spring.annotion.config.BeanLifeCycleConfig;

public class TestBeanLifeCycleConfig extends Base {
    public TestBeanLifeCycleConfig() {
        super(BeanLifeCycleConfig.class);
    }

    @Test
    public void test(){
        this.getBeanById("car");
        this.getBeanById("cat");
        this.close();
    }
}
