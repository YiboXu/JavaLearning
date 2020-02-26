package tk.chap4;

public interface B {
    default public void fun(){
        System.out.println("fun() in B");
    }
}
