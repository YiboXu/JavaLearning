package tk.spring.annotion;

import org.junit.Test;
import tk.spring.annotion.config.AwareConfig;
import tk.spring.annotion.model.MyAware;

public class TestAwareConfig extends Base {
    public TestAwareConfig() {
        super(AwareConfig.class);
    }

    @Test
    public void test(){
        MyAware myAware = (MyAware) this.getBeanById("myAware");
        logger.info(myAware.getApplicationContext().getEnvironment().getProperty("os.name"));
        logger.info(myAware.getBeanFactory().getBean("myAware"));
        logger.info(myAware.getStringValueResolver().resolveStringValue("#{20*18}"));
    }
}
