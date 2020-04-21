package tk.designpattern.basicruler.LiShiReplace;

public class Replace1 {
    class A {
        public void foo(){
            System.out.println("Foo of A");
        }
    }
    class B extends A{
        public void foo(){
            super.foo();
            System.out.println("Foo of B");
        }
    }

    public static void main(String[] args) {
        Replace1 replace1 = new Replace1();
        B b = replace1.new B();

        b.foo();
    }
}
