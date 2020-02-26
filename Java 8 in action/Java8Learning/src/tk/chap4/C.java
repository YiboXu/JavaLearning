package tk.chap4;

public class C implements A, B {
    @Override
    public void fun() {
        System.out.println("C has to implement the method fun");
    }
}
