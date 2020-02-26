package tk.spring.ioc.service;

import tk.spring.ioc.dao.UserDao;

public class UserService {
    private UserDao userDao;
    public void setUserDao(UserDao userDao){
        this.userDao = userDao;
    }

    public void getUser(){
        userDao.getUser();
    }
}
