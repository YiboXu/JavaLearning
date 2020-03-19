package tk.spring.annotion;

import org.junit.Test;
import tk.spring.annotion.config.ImportConfig;
import tk.spring.annotion.model.Color;
import tk.spring.annotion.model.Person;
import tk.spring.annotion.model.RainBow;

public class TestImport extends Base{
    public TestImport() {
        super(ImportConfig.class);
    }

    @Test
    public void test(){
        this.printAllDefinedBeanNames();
        this.printBeansOfType(Color.class);
        this.printBeansOfType(Person.class);
        this.printBeansOfType(RainBow.class);
        this.close();
    }
}
