package tk.spring.ioc;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestHello {
    public static void main(String[] args){
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        Hello hello = (Hello)context.getBean("hello");
        hello.show();

        Hello hello1 = (Hello)context.getBean("hello");
        Hello hello2 = (Hello)context.getBean("hello");
        Hello hello3 = (Hello)context.getBean("hello");
    }
}

