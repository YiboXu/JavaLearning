package tk.springmvc.controller;

import tk.springmvc.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class EncodingController {
    @RequestMapping("/add")
    public String add(HttpServletRequest request, HttpServletResponse response){
        System.out.println(request.getAttribute("msg"));
        return "encoding";
    }

    //*这里如果user里面的属性有中文，在返回页面上会出现乱码
    /*如何解决: 通过在web.xml里面添加filter (filter解决的是POST方法里面传递参数的乱码问题)
    <filter>
        <filter-name>encoding</filter-name>
        <filter-class>org.springframework.web.filter.CharacterEncodingFilter</filter-class>
        <init-param>
            <param-name>encoding</param-name>
            <param-value>utf-8</param-value>
        </init-param>
    </filter>

    <filter-mapping>
        <filter-name>encoding</filter-name>
        <url-pattern>/*</url-pattern>
    </filter-mapping>
    */
    //* GET方法里面参数乱码问题由下面解决
    //* <%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
    @RequestMapping("/encoding")
    public String encoding(User user, ModelMap model){
        model.addAttribute("data",user.toString());
        return "data";
    }
}
