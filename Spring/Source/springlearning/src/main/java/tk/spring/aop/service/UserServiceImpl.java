package tk.spring.aop.service;

public class UserServiceImpl implements UserService {
    @Override
    public void add(String obj) {
        System.out.println("增加用户");
    }

    @Override
    public void delete(String obj) {
        System.out.println("删除用户");
    }

    @Override
    public void update(String obj) {
        System.out.println("更新用户");
    }

    @Override
    public void search(String obj) {
        System.out.println("查询用户");
    }
}
