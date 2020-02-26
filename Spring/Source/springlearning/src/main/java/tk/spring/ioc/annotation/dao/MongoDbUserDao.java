package tk.spring.ioc.annotation.dao;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

/**
 * @Repository 该注解的作用不只是将类识别为Bean，同时它还能将所标注的类中抛出的数据访问异常封装为 Spring 的数据访问异常类型。
 * Spring本身提供了一个丰富的并且是与具体的数据访问技术无关的数据访问异常结构，用于封装不同的持久层框架抛出的异常，使得异常独立于底层的框架。
 */
//@Component
@Repository
public class MongoDbUserDao implements UserDao3 {
    @Override
    public void getUser() {
        System.out.println("Get MongoDB User");
    }
}
