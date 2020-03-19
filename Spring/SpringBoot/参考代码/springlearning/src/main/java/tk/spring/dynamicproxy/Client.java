package tk.spring.dynamicproxy;

import tk.spring.staticproxy.service.UserService;
import tk.spring.staticproxy.service.UserServiceImpl;

import java.util.ArrayList;
import java.util.List;

public class Client{
    public static void main(String[] args){
        //一个动态代理类一般代理同一类业务
        //只要有接口，我们就可以通过动态代理生成其的代理类
        //但是适用的情景是这些不同的被代理类的方法都需要调用相同的公共方法
        //比如这里的Host和UserServiceImpl的方法都会调用到commonMethod1和commonMethod2

        //我们先为Host设置一个代理类，在其调用rent()前后调用commonMethod1和commonMethod2
        Host host = new Host();
        ProxyInvocationHandle pih = new ProxyInvocationHandle();
        pih.setTarget(host);
        Rent proxy = (Rent)pih.getProxy();
        proxy.rent();

        //切换被代理对象为UserServiceImpl
        //我们看到这里需要为UserService代理的时候，只用切换一些target，而不用重新创建一个代理类
        UserServiceImpl userServiceImpl = new UserServiceImpl();
        pih.setTarget(userServiceImpl);
        UserService userService = (UserService) pih.getProxy();
        userService.add();

        //切换被代理对象为ArrayList
        //这里我们就通过动态代理类来在list.add()方法前后调用commonMethod1和commonMethod2
        pih.setTarget(new ArrayList());
        List listProxy = (List)pih.getProxy();
        listProxy.add("abc");
    }
}
