package tk.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import tk.springmvc.model.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/myLogin")
public class MyLoginController {
    @GetMapping
    public String loadLoginPage(HttpServletRequest request){
        return "myLogin";
    }

    @PostMapping
    public String login(User user, HttpServletRequest request, HttpSession session, ModelMap model){
        if("billhu".equals(user.getName()) && "123456".equals(user.getPsw())){
            session.setAttribute("user",user);
            //获取原始访问URL，如果存在就转发到原来访问的URL
            Object requestUrl = request.getAttribute("requestUrl");
            if(requestUrl != null){
                //不经过视图解析器，直接转发到原来的URL
                return "forward:"+(String) requestUrl;
            }

            //不过没有原始访问的URL, 就转发到welcome
            return "welcome";
        }else{
            model.addAttribute("msg","Invalid Username or Password!");
            return "myLogin";
        }
    }
}
