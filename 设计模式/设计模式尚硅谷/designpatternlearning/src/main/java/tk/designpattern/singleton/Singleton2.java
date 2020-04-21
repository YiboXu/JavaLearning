package tk.designpattern.singleton;

/**
 * 单例模式二(静态变量懒汉式) - 线程不安全
 * 如果一个对象使用频率不高，占用内存还特别大，明显就不合适用饿汉式了，
 * 这时就需要一种懒加载的思想，当程序需要这个实例的时候才去创建对象，就如同一个人懒的饿到不行了才去吃东西。
 * 优点: 起到了Lazy Loading的效果，但是只能在单线程下使用.
 * 缺点: 线程不安全. 如果在多线程下，一个线程进入了if(instance == null)判断语句块，还未来得及往下执行，另一个线程也通过了这个判断语句，
 *       这个时候便会产生多个实例. 所以多线程环境下不可使用这种方式
 * 结论: 实际开发中, 不要使用这种方式.
 */
public class Singleton2 {
    private static Singleton2 instance;

    private Singleton2(){}

    //调用getInstance()的时候才创建实例
    public static Singleton2 getInstance(){
        if(instance == null){
            instance = new Singleton2();
        }

        return instance;
    }
}
