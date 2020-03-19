package tk.spring.ioc.model;

public class UserDynamicFactory {
    public User getUser(String username){
        return new User(username);
    }
}
