package tk.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import tk.springboot.model.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/userLogin")
public class LoginController {
    @PostMapping
    public String login(@RequestParam String inputUsername, @RequestParam String inputPassword, ModelMap model, HttpSession session){
        if("billhu".equals(inputUsername) && "123456".equals(inputPassword)){
            //通过redirect防止重复提交
            session.setAttribute("user",new User(inputUsername,inputPassword));
            return "redirect:main";
        }

        model.addAttribute("msg","Invalid username & password");
        return "login";
    }
}
