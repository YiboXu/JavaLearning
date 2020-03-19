package tk.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/filter")
public class FilterController {
    @GetMapping
    @ResponseBody
    public String getFilter(){
        return "This is the return message from getFilter";
    }

    @PostMapping
    @ResponseBody
    public String postFilter(){
        return "This is the return message from postFilter";
    }

    @RequestMapping("/list")
    @ResponseBody
    public String filter2(){
        return "This is the return message from filter2";
    }
}
