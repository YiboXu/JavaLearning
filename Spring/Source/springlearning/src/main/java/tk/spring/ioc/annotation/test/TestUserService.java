package tk.spring.ioc.annotation.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import tk.spring.ioc.annotation.config.UserServiceConfiguration;
import tk.spring.ioc.annotation.dao.MySqlUserDao;
import tk.spring.ioc.annotation.service.UserService;
import tk.spring.ioc.annotation.service.UserService2;

public class TestUserService {
    public static void main(String[] args){
        ApplicationContext context = new AnnotationConfigApplicationContext(UserServiceConfiguration.class);

        //fetch the bean by type
        MySqlUserDao mySqlUserDao = context.getBean(MySqlUserDao.class);
        mySqlUserDao.getUser();

        //fetch the bean by name
        UserService oracleUserService = (UserService)context.getBean("oracleUserService");
        oracleUserService.getUser();

        //fetch the bean by type
        UserService2 userService2 = context.getBean(UserService2.class);
        userService2.getUser();

        //fetch the bean by name
        UserService2 userService3 = (UserService2) context.getBean("userService2");
        userService3.getUser();
    }
}
