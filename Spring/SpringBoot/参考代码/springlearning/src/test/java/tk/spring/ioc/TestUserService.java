package tk.spring.ioc;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import tk.spring.ioc.model.User;
import tk.spring.ioc.service.UserService;
import tk.spring.ioc.service.UserService2;

public class TestUserService {
    public static void main(String[] args){
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        UserService us = (UserService) context.getBean("mysqlUserService");
        us.getUser();

        UserService us1 = (UserService)context.getBean("oracleUserService");
        us1.getUser();

        User staticUser = (User)context.getBean("staticUser");
        staticUser.show();

        User dynamicUser = (User)context.getBean("dynamicUser");
        dynamicUser.show();

        Hello hello = (Hello)context.getBean("hello1");
        hello.show();

        User user = (User)context.getBean("user");
        user.show();

        UserService mysqlAutoWiredUserService1 = (UserService) context.getBean("mysqlAutoWiredUserService");
        mysqlAutoWiredUserService1.getUser();

        UserService2 db2AutoWiredUserService = (UserService2) context.getBean("db2AutoWiredUserService");
        db2AutoWiredUserService.getUser();

        UserService2 db2AutoWiredUserService2 = (UserService2) context.getBean("db2AutoWiredUserService2");
        db2AutoWiredUserService2.getUser();
    }
}
