package tk.springboot;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import tk.springboot.model.PersonPropertySource;

@SpringBootTest
public class TestPersonPropertySource {
    @Autowired
    PersonPropertySource personPropertySource;

    @Test
    void test(){
        System.out.println(personPropertySource);
    }
}
