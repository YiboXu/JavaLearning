package tk.designpattern.basicruler.interfaceSegregation;

/**
 * A依赖B里面对operation1-3方法的调用
 * C依赖D里面对operation1,4,5方法的调用
 *
 * 将接口拆分成最小接口Interface1,Interface2,Interface3,所以我们看到B, D只需要去实现一些他们需要的方法
 *
 * 接口隔离原则:
 * 一个类不应该依赖它不需要的接口，如果需要依赖另一个类，那么依赖需要建立在最小的接口上
 */

public class Segregation2 {
    interface Interface1 {
        void operation1();
    }
    interface Interface2{
        void operation2();
        void operation3();
    }
    interface Interface3{
        void operation4();
        void operation5();
    }
    class B implements Interface1,Interface2{

        public void operation1() {
            System.out.println("B 实现了方法operation1()");
        }

        public void operation2() {
            System.out.println("B 实现了方法operation2()");
        }

        public void operation3() {
            System.out.println("B 实现了方法operation3()");
        }
    }

    class D implements Interface1,Interface3{

        public void operation1() {
            System.out.println("D 实现了方法operation1()");
        }

        public void operation4() {
            System.out.println("D 实现了方法operation4()");
        }

        public void operation5() {
            System.out.println("D 实现了方法operation5()");
        }
    }

    class A{
        public void depend1(Interface1 i){
            i.operation1();
        }
        public void depend2(Interface2 i){
            i.operation2();
        }
        public void depend3(Interface2 i){
            i.operation3();
        }
    }

    class C{
        public void depend1(Interface1 i){
            i.operation1();
        }
        public void depend4(Interface3 i){
            i.operation4();
        }
        public void depend5(Interface3 i){
            i.operation5();
        }
    }
}