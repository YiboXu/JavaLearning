package tk.spring.ioc;

public class Hello {
    public Hello(){
        System.out.println("Hello is created");
    }
    private String name;
    public void setName(String name){
        this.name = name;
    }

    public void show(){
        System.out.println("Hello,"+name);
    }
}
