package tk.spring.annotion;

import org.junit.Test;
import tk.spring.annotion.config.FactoryBeanConfig;
import tk.spring.annotion.model.Color;
import tk.spring.annotion.model.ColorFactoryBean;

public class TestFactoryBeanConfig extends Base{
    public TestFactoryBeanConfig() {
        super(FactoryBeanConfig.class);
    }

    @Test
    public void test(){

        this.printAllDefinedBeanNames();
        this.printBeansOfType(ColorFactoryBean.class);
        this.printBeansOfType(Color.class);
        this.close();
    }
}
