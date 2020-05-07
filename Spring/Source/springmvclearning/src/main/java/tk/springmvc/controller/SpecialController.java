package tk.springmvc.controller;

import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.access.prepost.PostFilter;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tk.springmvc.model.User;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
public class SpecialController {
    @RequestMapping("/special1/test1")
    public String test1(){
        return "special1-test1";
    }

    @RequestMapping("/special2/test2")
    public String test2(){
        return "special2-test2";
    }

    @RequestMapping("/special3/test3")
    public String test3(){
        return "special3-test3";
    }

    @PreAuthorize("hasRole('ADMIN')")
    @RequestMapping("/special4/test4")
    public String test4(){
        return "special4-test4";
    }

    //只有返回的user对象的name属性等于登录用户的用户名(username)时，方法才能正常返回
    //用来限制对特定数据的访问
    @PostAuthorize("returnObject.name==principal.username")
    @RequestMapping("/special5/test5")
    public User test5(){
        User user = new User();
        user.setName("billhu");
        return user;
    }

    //结果中psw不等于'xxx'会被剔除掉
    @PostFilter("filterObject.psw=='xxx'")
    @RequestMapping("/special6/test6")
    public List<User> test6(){

        List<User> userList = new ArrayList<>();
        userList.add(new User(1,"billhu1","xxx"));
        userList.add(new User(2,"billhu2","yyy"));
        userList.add(new User(3,"billhu3","xxx"));
        userList.add(new User(4,"billhu4","yyy"));
        userList.add(new User(5,"billhu5","xxx"));

        return userList;
    }

    /**
     * 通过filterTarget指定了当前@PreFilter是用来过滤参数ids的
     *    @PreFilter(filterTarget="ids", value="filterObject%2==0")
     *    @RequestMapping("/special7/test7")
     *    public void delete(List<Integer> ids, List<String> usernames) {
     *       ...
     *    }
     */
}
