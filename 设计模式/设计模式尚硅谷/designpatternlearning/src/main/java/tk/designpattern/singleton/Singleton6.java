package tk.designpattern.singleton;

/**
 * 单例模式五(枚举模式) - 线程安全
 * 优点: 避免多线程同步问题，而且还能防止反序列化重新创建新的对象
 * 结论: 推荐使用
 */
public enum Singleton6 {
    INSTANCE("Only-One-Instance");
    private String description;
    private Singleton6(String description){this.description = description;}
    public void say(){
        System.out.println(description);
    }

    @Override
    public String toString() {
        return "Singleton6{" +
                "description='" + description + '\'' +
                '}';
    }

    public static void main(String[] args) {
        System.out.println(INSTANCE);
        INSTANCE.say();
    }
}
