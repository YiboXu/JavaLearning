package tk.designpattern.factory.factorymethod;

public class ChinaMilkPizza extends Pizza {
    public ChinaMilkPizza(String name){
        super(name);
    }

    @Override
    public void prepare() {
        System.out.println(super.getName() + " 披萨正在准备......");
    }
}
