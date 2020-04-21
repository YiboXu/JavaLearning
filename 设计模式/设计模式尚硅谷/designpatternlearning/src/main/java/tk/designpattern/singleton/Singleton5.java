package tk.designpattern.singleton;

/**
 * 单例模式五(静态内部类懒汉式) - 线程安全
 * 优点: 这种方式采用了类装载的机制来保证初始化实例时只有一个线程.
 *       静态内部类方式在Singleton5被装载时并不会立即实例化, 而是在需要实例化时(调用getInstance方法)，才会装载SingletonInstance类来完成instance的初始化
 *       类的静态属性指挥在第一次加载类的时候初始化，所以在这里，JVM帮助我们保证了线程的安全性，在类进行初始化时，别的线程时无法进入的
 * 结论: 推荐使用
 */
public class Singleton5 {

    private Singleton5(){}

    private static class SingletonInstance{
        private static Singleton5 instance = new Singleton5();
    }

    public static Singleton5 getInstance(){
        return SingletonInstance.instance;
    }

    @Override
    public String toString() {
        return "Singleton5{"+hashCode()+"}";
    }

    public static void main(String[] args) {
        System.out.println(Singleton5.getInstance());
    }
}
