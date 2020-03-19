package tk.spring.ioc.annotation.dao;

public class MySqlUserDao implements UserDao {
    private String username;
    public MySqlUserDao(String username){
        this.username = username;
    }
    @Override
    public void getUser(){
        System.out.println("MySql get user "+username);
    }
}
