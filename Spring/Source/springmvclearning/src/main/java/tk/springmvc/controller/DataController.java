package tk.springmvc.controller;

import tk.springmvc.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class DataController {
    //* http://localhost:8080/data1?name=zhangshan
    //*传递参数名和方法参数名一致
    @RequestMapping("/data1")
    public ModelAndView data1(String name){
        ModelAndView mv = new ModelAndView();
        mv.addObject("data",name);
        mv.setViewName("data");
        return mv;
    }

    //* http://localhost:8080/data2?uname=zhangshan
    //*传递参数名和方法参数名不一致
    @RequestMapping("/data2")
    public ModelAndView data2(@RequestParam("uname") String name){
        ModelAndView mv = new ModelAndView();
        mv.addObject("data",name);
        mv.setViewName("data");
        return mv;
    }

    //* http://localhost:8080/data3?name=zhangshan&psw=123456
    //*传递对象.
    //*要求传递参数名和对象属性名一致
    @RequestMapping("/data3")
    public ModelAndView data3(User user){
        ModelAndView mv = new ModelAndView();
        mv.addObject("data",user.toString());
        mv.setViewName("data");
        return mv;
    }

    //* http://localhost:8080/data4?name=zhangshan&psw=123456
    //*传递对象.
    //*要求传递参数名和对象属性名一致
    //*通过ModelMap返回数据
    //*通过ModelAndView返回数据，我们可以指定返回的视图名，需要视图解析器
    //*通过ModelMap返回数据，我们不能指定返回的视图名，需要在return中指定，同时可以没有视图解析器，当然如果有视图解析器，就会给其返回的视图名加上前后缀.
    @RequestMapping("/data4")
    public String data4(User user, ModelMap model){
        model.addAttribute("data",user.toString());
        return "data";
    }
}
