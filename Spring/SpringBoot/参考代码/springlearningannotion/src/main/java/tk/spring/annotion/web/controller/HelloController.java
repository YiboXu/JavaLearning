package tk.spring.annotion.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import tk.spring.annotion.web.service.HelloService;

@Controller
public class HelloController {
    @Autowired
    private HelloService helloService;

    @RequestMapping("/hello1")
    public String hello(ModelMap modelMap){
        modelMap.addAttribute("msg",helloService.hello("Tomcat..."));
        return "hello";
    }
}
