package tk.springmvc.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import tk.springmvc.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

//* http://localhost:8080/json.jsp

@Controller
@RequestMapping("/json")
public class JsonController {
    @GetMapping
    public String loadPage(){
        return "json";
    }

    @PostMapping
    //*@ResponseBody就是将返回结果直接返回给请求端，从而不会经过视图解析器进行解析
    @ResponseBody
    public List<User> getJson(){
        List<User> users = new ArrayList<User>();
        users.add(new User(1,"BillHu","123"));
        users.add(new User(2,"Sofica","456"));
        users.add(new User(3,"Jackson","789"));
        return users;
    }
}
