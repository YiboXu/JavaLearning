package tk.springmvc.controller;

import tk.springmvc.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/rest2")
public class DataController2 {
    @GetMapping
    public String add(){
        return "add";
    }

    @PostMapping
    String add(User user, ModelMap model){
        model.addAttribute("data",user.toString());
        return "data";
    }

    @GetMapping("/insert")
    public String insert(){
        return "insert";
    }

    @PostMapping("/insert")
    String insert(User user, ModelMap model){
        model.addAttribute("data",user.toString());
        return "data";
    }
}
