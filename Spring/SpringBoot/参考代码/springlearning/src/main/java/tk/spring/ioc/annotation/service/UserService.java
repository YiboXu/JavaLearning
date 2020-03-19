package tk.spring.ioc.annotation.service;

import tk.spring.ioc.annotation.dao.UserDao;

public class UserService {
    private UserDao userDao;
    public void setUserDao(UserDao userDao){
        this.userDao = userDao;
    }

    public UserService(UserDao userDao){
        setUserDao(userDao);
    }
    public void getUser(){
        userDao.getUser();
    }
}
