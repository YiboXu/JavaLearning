package tk.designpattern.singleton;

/**
 * 单例模式三(静态变量懒汉式) - 线程安全
 * 如果一个对象使用频率不高，占用内存还特别大，明显就不合适用饿汉式了，
 * 这时就需要一种懒加载的思想，当程序需要这个实例的时候才去创建对象，就如同一个人懒的饿到不行了才去吃东西。
 * 优点: 起到了Lazy Loading的效果.
 *      添加了synchronized， 使得线程安全.
 * 缺点: 效率太低了, 每个线程在想获得类的实例时候， 执行getInstance()方法都要进行同步. 而其实这个方法只执行一次实例化代码就够了,
 *       后面想获得该类实例,直接return就行了.方法进行同步效率太低.
 * 结论: 实际开发中, 不要使用这种方式.
 */
public class Singleton3 {
    private static Singleton3 instance;

    private Singleton3(){}

    //调用getInstance()的时候才创建实例
    public static synchronized Singleton3 getInstance(){
        if(instance == null){
            instance = new Singleton3();
        }

        return instance;
    }

    @Override
    public String toString() {
        return "Singleton3{"+this.hashCode()+"}";
    }

    public static void main(String[] args) {
        System.out.println(Singleton3.getInstance());
    }
}

