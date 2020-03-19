package tk.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class AdminController {
    @RequestMapping("/list")
    public String admin(){
        System.out.println("Execute AdminController admin() Method");
        return "admin";
    }
}
