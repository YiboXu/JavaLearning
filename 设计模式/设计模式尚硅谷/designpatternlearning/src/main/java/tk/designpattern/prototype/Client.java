package tk.designpattern.prototype;

import java.io.*;

public class Client {
    public static void main(String[] args) throws CloneNotSupportedException, IOException, ClassNotFoundException {
        //浅拷贝
        Sheep sheep = new Sheep("Tom",20,"White",new Sheep("Jack",2,"Black",null));
        Sheep sheep1 = (Sheep) sheep.clone();
        System.out.println(sheep);
        System.out.println(sheep1);

        //深拷贝1 - 通过重写clone方法
        Sheep2 sheepDeep = new Sheep2("Tom",20,"White",new Sheep2("Jack",2,"Black",null));
        Sheep2 sheep2 = (Sheep2) sheepDeep.clone();
        System.out.println(sheepDeep);
        System.out.println(sheep2);

        //深拷贝2 - 通过序列化方法
        Sheep3 sheepSerial = new Sheep3("Tom",20,"White",new Sheep3("Jack",2,"Black",null));
        Sheep3 sheepSerialCloned = sheepSerial.deepClone();

        System.out.println(sheepSerial);
        System.out.println(sheepSerialCloned);
    }
}
