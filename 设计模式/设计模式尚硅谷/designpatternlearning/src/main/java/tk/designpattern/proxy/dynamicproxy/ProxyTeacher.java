package tk.designpattern.proxy.dynamicproxy;

import com.sun.deploy.net.proxy.ProxyHandler;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ProxyTeacher implements InvocationHandler {

    private Object target;

    public ProxyTeacher(Object target) {
        this.target = target;
    }

    public Object getProxy(){
        return Proxy.newProxyInstance(this.getClass().getClassLoader(), target.getClass().getInterfaces(),this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("代课老师代替正式老师");
        Object result = method.invoke(target,args);
        return result;
    }
}
