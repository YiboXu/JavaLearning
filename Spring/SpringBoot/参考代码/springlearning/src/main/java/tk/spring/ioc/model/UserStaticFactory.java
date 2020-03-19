package tk.spring.ioc.model;

public class UserStaticFactory {
    public static User getUser(String username){
        return new User(username);
    }
}

