package tk.spring.ioc.model;

import java.lang.reflect.Array;
import java.util.*;

public class User {
    private String username;
    private String[] roles;
    private List<String> hobbies;
    private HashMap<String,String> cards;
    private Set<String> games;
    private String wife;
    private Properties properties;

    public User(String username){
        this.username = username;
        this.roles = new String[]{"user"};
        this.hobbies = Arrays.asList("eat");
        this.cards = new HashMap<String,String>();
        this.games = new HashSet<String>();
        this.wife = null;
        this.properties = null;
    }

    public User(String username, String[] roles, List<String> hobbies, HashMap<String,String> cards, Set<String> games, String wife, Properties properties){
            this.username = username;
            this.roles = roles;
            this.hobbies = hobbies;
            this.cards = cards;
            this.games = games;
            this.wife = wife;
            this.properties = properties;
    }

    public void show(){
        System.out.println("I am "+username+
                           ",roles:"+Arrays.asList(roles).toString()+
                           ",hobbies:"+hobbies.toString()+
                           ",cards:"+cards.toString()+
                           ",games:"+games.toString()+
                           ",wife:"+wife+
                            ",properties:"+properties);
    }
}
