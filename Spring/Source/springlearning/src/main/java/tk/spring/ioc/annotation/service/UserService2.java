package tk.spring.ioc.annotation.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import tk.spring.ioc.annotation.dao.UserDao;
import tk.spring.ioc.annotation.dao.UserDao2;
import tk.spring.ioc.annotation.dao.UserDao3;

/**
 *     @Component 是一个泛化的概念，仅仅表示一个组件 (Bean) ，可以作用在任何层次。
 *     @Service 通常作用在业务层，但是目前该功能与 @Component 相同。
 *     @Constroller 通常作用在控制层，但是目前该功能与 @Component 相同。
 */
@Service("userService2")
public class UserService2 {

    private UserDao3 userDao3;

    //对于字段域，扫描标记了@Component的类，如果找到且唯一，就赋值给这个字段
    @Autowired
    private UserDao2 userDao2;

    //构造函数里面字段域会自动再标记了@Component的类中查找
    public UserService2(UserDao3 userDao3){
        setUserDao(userDao3);
    }

    public void setUserDao(UserDao3 userDao3){
        this.userDao3 = userDao3;
    }

    public void getUser(){
        userDao3.getUser();
        userDao2.getUser();
    }
}
