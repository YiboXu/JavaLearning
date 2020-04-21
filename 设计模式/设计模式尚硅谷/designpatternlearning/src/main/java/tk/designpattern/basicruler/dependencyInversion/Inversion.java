package tk.designpattern.basicruler.dependencyInversion;

/**
 * 依赖反转， 其实就是面向接口编程
 * 一个类A如果依赖另一个类B，那么就通过依赖一个接口C， 同时让B来实现C
 */
public class Inversion {
    interface C{
        void foo();
    }

    class B implements C{

        public void foo() {
            System.out.println("foo of C");
        }
    }

    class A{
        private C c;
        public A(C c){
            this.c = c;
        }
        public void foo(){
            c.foo();
        }
    }
}
