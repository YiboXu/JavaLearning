package tk.designpattern.facade;

/**
 * 外观模式
 * 1) 外观模式（ FacadeFacade Facade ）， 也叫 “过程模式 ：外 观模 式为 子系统中的一组接口提供 一个致的界面，此模式定义了高层接口这使得子系统更加容易使用
 * 2) 外观模式通 过定义一个致的接口，用以屏蔽内部子系统细节使得调端 只需跟这个接口发生调用，而无关心子系统的内部细 节
 *
 * 外观模式的注意事项和细节 外观模式的注意事项和细节
 * 1) 外观模式对外屏蔽了子系统的细节，因此降低客户端使用复 杂性
 * 2) 外观模 式对客户端与子系统的耦合关，让内部模块更易维护和扩 展
 * 3) 通过合理的使用外观模式，可以帮我们更好划分访问层 次
 * 4) 当系统需要进行分层设计 时，可以考虑使用 Facade Facade 模式
 * 5) 在维护一个遗留的大型系统时 ，可能这已经变得非常难以和扩展此可以考虑为新系统开发一个 Facade FacadeFacade类， 来提供遗留系统的比较清晰简单接口让新系统与 Facade Facade 类交 互， 提高复用性
 * 6) 不能 过多的或者不合理使用外观模 式，使用 外观模式好 ，还是直接调用模块 好。 要以让系统有层次，利于维护为目的 。
 */
public class Client {
    public static void main(String[] args) {
        HomeTheater homeTheater = new HomeTheater();
        homeTheater.open();
        homeTheater.pause();
        homeTheater.stop();
    }
}
