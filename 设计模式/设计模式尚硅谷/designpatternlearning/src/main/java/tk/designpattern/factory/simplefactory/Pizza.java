package tk.designpattern.factory.simplefactory;

public abstract class Pizza {
    private String name;
    public Pizza(String name){
        this.name = name;
    }
    public String getName(){return name;}

    public abstract void prepare();
    public void bake(){
        System.out.println(name + " 披萨正在烘烤......");
    }
    public void cute(){
        System.out.println(name + " 披萨正在切割......");
    }
    public void box(){
        System.out.println(name + " 披萨正在打包......");
    }

    @Override
    public String toString() {
        return "Pizza{" +
                "name='" + name + '\'' +
                '}';
    }
}
