package tk.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class RestfulController {
    @RequestMapping("/rest1/{id1}/{id2}")
    public String rest1(@PathVariable int id1, @PathVariable int id2, ModelMap model){
        model.addAttribute("message","id1: "+id1+", id2: "+id2);
        return "restful";
    }
}
