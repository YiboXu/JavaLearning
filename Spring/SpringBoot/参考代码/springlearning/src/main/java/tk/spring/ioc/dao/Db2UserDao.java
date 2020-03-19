package tk.spring.ioc.dao;

public class Db2UserDao implements UserDao2 {
    @Override
    public void getUser() {
        System.out.println("Get Db2 User");
    }
}
