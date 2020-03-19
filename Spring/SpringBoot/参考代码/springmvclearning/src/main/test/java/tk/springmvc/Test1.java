package tk.springmvc;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class Test1 {
    public static void main(String[] args){
        System.out.println(new BCryptPasswordEncoder().encode("password"));
    }
}
