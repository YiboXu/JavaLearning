package tk.designpattern.singleton;

/**
 * 单例模式一(静态常量饿汉式)
 * 不管程序是否需要这个对象的实例，总是在类加载的时候就先创建好实例，理解起来就像不管一个人想不想吃东西都把吃的先买好，如同饿怕了一样。
 * 优点:这种写法比较简单，就是在类装载的时候就完成实例化. 避免了线程同步问题
 * 缺点: 在类装载的时候就完成实例化, 没有达到Lazy Loading的效果. 如果从始至终都没勇哥这个实例，则会造成内存的浪费.
 */

public class Singleton1 {
    private static Singleton1 instance = new Singleton1();
    private Singleton1(){}

    public static Singleton1 getInstance(){
        return instance;
    }

    @Override
    public String toString() {
        return "Singleton1{"+this.hashCode()+"}";
    }

    public static void main(String[] args){
        Singleton1 singletona = Singleton1.getInstance();
        System.out.println(singletona);
        Singleton1 singletonb = Singleton1.getInstance();
        System.out.println(singletonb);
    }
}
