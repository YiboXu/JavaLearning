package tk.spring.dynamicproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ProxyInvocationHandle implements InvocationHandler {
    private Object target;
    public void setTarget(Object target){
        this.target = target;
    }

    public Object getProxy(){
        return Proxy.newProxyInstance(this.getClass().getClassLoader(),target.getClass().getInterfaces(),this);
    }

    /**
     * @param proxy  代理类
     * @param method 代理类调用被代理对象
     * @param args   代理类调用的方法的参数
     * @return
     * @throws Throwable
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        commondMethod1();
        Object result = method.invoke(target,args);
        commondMethod2();
        return result;
    }

    /**
     * 公共方法1
     */
    private void commondMethod1(){
        System.out.println("调用公共方法1");
    }

    /**
     * 公共方法2
     */
    private void commondMethod2(){
        System.out.println("调用公共方法2");
    }
}
