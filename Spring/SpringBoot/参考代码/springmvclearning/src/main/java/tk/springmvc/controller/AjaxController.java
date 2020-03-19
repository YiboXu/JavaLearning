package tk.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

//* http://localhost:8080/ajax

@Controller
@RequestMapping("/ajax")
public class AjaxController {
    @GetMapping
    public String getAjax(){
        return "ajax";
    }

    @PostMapping
    public void ajax(String name, HttpServletResponse response) throws IOException {
        if("billhu".equals(name)){
            response.getWriter().print("true");
        }else{
           response.getWriter().print("false");
        }
    }
}
