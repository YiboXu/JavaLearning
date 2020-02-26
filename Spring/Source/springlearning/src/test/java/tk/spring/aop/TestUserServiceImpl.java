package tk.spring.aop;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import tk.spring.aop.service.AutoAspectUserServiceImpl;
import tk.spring.aop.service.UserService;

public class TestUserServiceImpl {
    public static void main(String[] args){
        ApplicationContext context = new ClassPathXmlApplicationContext("aop.xml");
        UserService userService = (UserService) context.getBean("userService");
        userService.add("test");

        UserService userService1 = (UserService) context.getBean("AutoAspectUserServiceImpl");
        userService1.search("hadoop");
    }
}
