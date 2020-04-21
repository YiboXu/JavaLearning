package tk.designpattern.flyweight;

/**
 * 享元模式基本介绍
 * 1) 享元模式（ Flyweight Pattern Flyweight PatternFlyweight PatternFlyweight Pattern Flyweight Pattern Flyweight PatternFlyweight PatternFlyweight PatternFlyweight Pattern ） 也叫 蝇量模式 : 运 用共享技术有效地支持大量细粒度的对 象
 * 2) 常用于系统底层开发 ，解 决系统的性能问题。像 数据库连接池 ，里面都是创建好的连接对象在 这些连接对象中有我们需要的则直拿来用，避免重新创 建，如果没有我们需要的，则创建一个
 * 3) 享元模式能够解决 重复对象的内存浪费问题 ， 当系 统中有大量相似对象，需要缓冲 池时。 不需 总是 创建新对 象，可 以从 缓冲池里拿。这样可以 降低系统内存，同时提高效率
 * 4) 享元模式 经典的应用场景 就是池技术了， String StringString 常 量池、数据库连接缓冲等都是享元模式的应用 ，享 元模式是池技术的重要实现方 式
 *
 * 享元 模式的注意事项和细节 模式的注意事项和细节
 * 1) 在享元模 式这样理解，“ 享”就表示共，“元对象
 * 2) 系统中有大量对 象， 这些对象消耗大量内 存， 并且 对象的状态大部分可以外化 时， 我们就可以考虑选用享元模式
 * 3) 用唯一标识码判断，如果在内存中有则返回这个所的对象用 HashMap/HashTableHashMap/HashTable HashMap/HashTable HashMap/HashTableHashMap/HashTable HashMap/HashTable HashMap/HashTable 存储
 * 4) 享元模式大 大减少了对象的创建，降低程序内存占用提高效 率
 * 5) 享元模式提 高了系统的复杂度。需要分离出内部状态和外，而具有 固化特性，不应该随着内部状态的改 变而变，这是我们 使用享元模式需要注意的 地方 .
 * 6) 使用享元模式时，注 意划分内部状态 和外，并且需要有 一个工厂类加以控 制。
 * 7) 享元模式经典的应用场景是 需要缓冲池的场 景，比如 String StringString 常量 池、 数据库连接 池
 */
public class Client {
    public static void main(String[] args) {
        WebSiteFactory factory = new WebSiteFactory();
        factory.getWebSite("weibo").use(new User("BillHu"));
        factory.getWebSite("weibo").use(new User("Sofica"));
    }
}
