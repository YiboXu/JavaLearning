package tk.designpattern.proxy.cglib;


/**
 * 代理 模式的基本介绍
 * 1) 代理模 式：为 一个对象 提供一个替身 ，以控制对这个象的访 问。 即通过代理 对象 访问目标.这样做的 好处是 :可以在目标对象实现的基础上 ,增强额外的 功能操作 ,即扩展目标对象的功 能。
 * 2) 被代理的对象可以是 远程对象 、创建开销大的对 象或 需要安全控制 的对象
 * 3) 代理模式 有不同的形式 , 主要有三种 静态代理 、动态代理 (JDK (JDK代 理、接口理)和 Cglib Cglib 代理 (可以在内存动态的创建对象， 而不需要实现接口他是属于 动态代理的范畴 )。
 *
 * Cglib代理:
 * 代理对象和被代理对象都不需要实现接口
 * 代理类工厂类需要实现MethodInterceptor接口
 */
public class Client {
    public static void main(String[] args) {
        ProxyFactory factory = new ProxyFactory(new Teacher());
        Teacher teacher = (Teacher) factory.getProxyInstance();
        teacher.teach();
    }
}
