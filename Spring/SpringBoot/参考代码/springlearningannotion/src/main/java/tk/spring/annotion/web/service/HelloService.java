package tk.spring.annotion.web.service;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
public class HelloService {
    public String hello(String name){
        return "Hello "+name;
    }
}
