package tk.spring.ioc.dao;

public class MySqlUserDao implements UserDao{
    private String username;
    public void setUsername(String username){
        this.username = username;
    }
    @Override
    public void getUser(){
        System.out.println("MySql get user "+username);
    }
}
