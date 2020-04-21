package tk.designpattern.singleton;

/**
 * 单例模式四(静态变量懒汉式+双重检查) - 线程安全
 * 如果一个对象使用频率不高，占用内存还特别大，明显就不合适用饿汉式了，
 * 这时就需要一种懒加载的思想，当程序需要这个实例的时候才去创建对象，就如同一个人懒的饿到不行了才去吃东西。
 * 优点: Double-Check概念时多线程开发中常用到的，如代码中所示，我们进行了两次if(instance == null)检查，这样就可以保证线程安全了.
 *      直接return实例化对象，也避免了反复进行方法同步.
 *      线程安全;延迟加载; 效率较高
 * 结论: 实际开发中, 推荐使用这种方式.
 */
public class Singleton4 {
    private static volatile Singleton4 instance;

    private Singleton4(){}

    //调用getInstance()的时候才创建实例
    public static Singleton4 getInstance(){
        if(instance == null){
            synchronized (Singleton4.class) {
                if(instance == null) {
                    instance = new Singleton4();
                }
            }
        }

        return instance;
    }

    @Override
    public String toString() {
        return "Singleton4{"+this.hashCode()+"}";
    }

    public static void main(String[] args) {
        System.out.println(Singleton3.getInstance());
    }
}


