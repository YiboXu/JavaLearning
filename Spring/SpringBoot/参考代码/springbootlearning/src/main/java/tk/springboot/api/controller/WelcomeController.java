package tk.springboot.api.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import tk.springboot.exception.EmployeeNotFoundException;

@RestController
public class WelcomeController {
    @RequestMapping("/api")
    public String root(@RequestParam String username){
        if("aaa".equals(username)){
            throw new EmployeeNotFoundException();
        }
        return "Welcome to Springboot Restful API";
    }
}
