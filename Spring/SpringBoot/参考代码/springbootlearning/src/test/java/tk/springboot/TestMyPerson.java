package tk.springboot;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import tk.springboot.model.MyPerson;

@SpringBootTest
public class TestMyPerson {
    @Autowired
    @Qualifier("myPerson")
    private MyPerson myPerson;
        @Test
        void test(){
        System.out.println(myPerson);
    }
}
