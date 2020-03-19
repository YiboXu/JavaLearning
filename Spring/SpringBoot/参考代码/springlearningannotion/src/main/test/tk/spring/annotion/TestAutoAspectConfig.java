package tk.spring.annotion;

import org.junit.Test;
import tk.spring.annotion.aop.AutoAspectConfig;
import tk.spring.annotion.aop.AutoAspectLog;
import tk.spring.annotion.aop.UserService;

public class TestAutoAspectConfig extends Base {
    public TestAutoAspectConfig() {
        super(AutoAspectConfig.class);
    }

    @Test
    public void test(){
        UserService userService = (UserService) this.getBeanById("userService");
        userService.add("test");
    }
}
