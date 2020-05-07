package tk.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AccessDenyController {
    @RequestMapping("/accessDeny")
    public String accessDeny(){
        return "accessDeny";
    }
}
