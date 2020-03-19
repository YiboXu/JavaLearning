package tk.springboot;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import tk.springboot.model.PersonGlobal;

@SpringBootTest
public class TestPersonProperties {
    @Autowired
    PersonGlobal personGlobal;

    @Test
    void testPersonPropertiesLoad(){
        System.out.println(personGlobal);
    }
}
