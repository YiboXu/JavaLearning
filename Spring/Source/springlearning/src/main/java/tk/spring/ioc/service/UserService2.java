package tk.spring.ioc.service;

import tk.spring.ioc.dao.UserDao2;

public class UserService2 {
    private UserDao2 userDao2;
    public UserService2(){}
    public UserService2(UserDao2 userDao2){
        setUserDao(userDao2);
    }
    public void setUserDao(UserDao2 userDao2){
        this.userDao2 = userDao2;
    }

    public void getUser(){
        userDao2.getUser();
    }
}
