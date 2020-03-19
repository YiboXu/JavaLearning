package tk.springboot;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import tk.springboot.model.ValueInject;

@SpringBootTest
public class TestValueInject {
    @Autowired
    private ValueInject valueInject;

    @Test
    void test(){
        System.out.println(valueInject);
    }
}
