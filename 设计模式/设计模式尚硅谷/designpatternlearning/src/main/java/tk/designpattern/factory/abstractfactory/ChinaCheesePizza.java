package tk.designpattern.factory.abstractfactory;

public class ChinaCheesePizza extends Pizza {
    public ChinaCheesePizza(String name){
        super(name);
    }

    @Override
    public void prepare() {
        System.out.println(super.getName() + " 披萨正在准备......");
    }
}

