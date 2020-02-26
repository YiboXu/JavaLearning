package tk.spring.staticproxy.service;

public class UserServiceProxy implements UserService {
    private UserServiceImpl userServiceImpl;

    public void setUserServiceImpl(UserServiceImpl userServiceImpl){
        this.userServiceImpl = userServiceImpl;
    }

    public UserServiceProxy(){}

    public UserServiceProxy(UserServiceImpl userServiceImpl){
        setUserServiceImpl(userServiceImpl);
    }

    @Override
    public void add() {
        log("add");
        userServiceImpl.add();
    }

    @Override
    public void delete() {
        log("delete");
        userServiceImpl.delete();
    }

    @Override
    public void update() {
        log("update");
        userServiceImpl.update();
    }

    @Override
    public void search() {
        log("search");
        userServiceImpl.search();
    }

    private void log(String methodName){
        System.out.println("执行"+methodName+"方法");
    }
}
