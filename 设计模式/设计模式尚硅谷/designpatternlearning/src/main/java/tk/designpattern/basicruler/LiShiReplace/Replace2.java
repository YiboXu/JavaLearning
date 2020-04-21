package tk.designpattern.basicruler.LiShiReplace;

/**
 * 里氏替换:
 *  如果对每个类型为T1的对象o1，都有类型为T2的对象o2，使得以T1定义的所有程序P在所有的对象o1都代换成o2时，程序P的行为没有发生变化
 *  那么类型T2时类型T1的子类型.换句话说，所有引用基类的地方必须能透明的使用其子类的对象.
 *
 * 不到万不得已，不要使用继承，因为子类可以重写父类方法，继承使得父类子类耦合性很高
 * 同时尽量不要重写父类的方法, 如果实在需要重写父类的方法，可以通过聚合，组合，依赖来解决
 * 如果满足里氏替换原则，可以使用继承，否则，可以使2个类共同继承一个更上层的抽象类或接口，来提供各自的实现方法，从而使得2个类解耦
 */
public class Replace2 {
    interface Interface{
        void foo();
    }
    class A implements Interface{

        public void foo() {
            System.out.println("Foo of A");
        }
    }
    class B implements Interface{
        private A a = new A();
        public void foo() {
            a.foo();
            System.out.println("Foo of B");
        }
    }

    public static void main(String[] args) {
        Replace2 replace2 = new Replace2();
        B b = replace2.new B();
        b.foo();
    }
}
