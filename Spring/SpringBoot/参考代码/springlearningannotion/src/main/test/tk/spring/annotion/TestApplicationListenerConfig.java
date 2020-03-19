package tk.spring.annotion;

import org.junit.Test;
import org.springframework.context.ApplicationEvent;
import tk.spring.annotion.ext.ApplicationListenerConfig;

public class TestApplicationListenerConfig extends Base{
    public TestApplicationListenerConfig() {
        super(ApplicationListenerConfig.class);
    }

    @Test
    public void test(){
        this.publishEvent(new ApplicationEvent("TestingEvent") {});
        this.close();
    }
}
