package tk.designpattern.basicruler.interfaceSegregation;

/**
 * A依赖B里面对operation1-3方法的调用
 * C依赖D里面对operation1,4,5方法的调用
 *
 * 由于interface1并不是最小的依赖接口，所以我们看到B, D需要去实现一些他们不需要的方法
 */

public class Segregation1 {
    interface Interface1 {
        void operation1();
        void operation2();
        void operation3();
        void operation4();
        void operation5();
    }

    class B implements Interface1{

        public void operation1() {
            System.out.println("B 实现了方法operation1()");
        }

        public void operation2() {
            System.out.println("B 实现了方法operation2()");
        }

        public void operation3() {
            System.out.println("B 实现了方法operation3()");
        }

        public void operation4() {
            System.out.println("B 实现了方法operation4()");
        }

        public void operation5() {
            System.out.println("B 实现了方法operation5()");
        }
    }

    class D implements Interface1{

        public void operation1() {
            System.out.println("D 实现了方法operation1()");
        }

        public void operation2() {
            System.out.println("D 实现了方法operation2()");
        }

        public void operation3() {
            System.out.println("D 实现了方法operation3()");
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
        public void depend2(Interface1 i){
            i.operation2();
        }
        public void depend3(Interface1 i){
            i.operation3();
        }
    }

    class C{
        public void depend1(Interface1 i){
            i.operation1();
        }
        public void depend4(Interface1 i){
            i.operation4();
        }
        public void depend5(Interface1 i){
            i.operation5();
        }
    }
}
