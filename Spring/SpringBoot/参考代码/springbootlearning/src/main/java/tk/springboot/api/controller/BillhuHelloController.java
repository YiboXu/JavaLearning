package tk.springboot.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tk.billhu.starter.HelloService;

@RestController
public class BillhuHelloController {
    @Autowired
    private HelloService helloService;

    public void setHelloService(HelloService helloService) {
        this.helloService = helloService;
    }

    @RequestMapping("/billhu/hello")
    public String hello(){
        return helloService.sayHello("HuTao");
    }
}
