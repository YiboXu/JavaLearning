package tk.spring.annotion;

import org.junit.Test;
import tk.spring.annotion.config.PropertyValueConfig;
import tk.spring.annotion.model.Member;

public class TestPropertyValueConfig extends Base {
    public TestPropertyValueConfig() {
        super(PropertyValueConfig.class);
    }

    @Test
    public void test(){
        this.printBeansOfType(Member.class);
    }
}
