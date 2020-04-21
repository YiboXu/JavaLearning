package tk.designpattern.prototype;

import java.io.Serializable;

/**
 * 原型模式 (spring ioc里面用到了原型模式，通过指定bean是单例还是原型)
 * 浅拷贝:
 * - 对于数据类型时基本类型的成员变量，浅拷贝会直接进行值传递, 也就是将该属性值复制一份给新的对象.
 * - 对于数据类型时引用数据类型的成员变量, 比如说成员变量时数组,对象等, 那么浅拷贝会进行引用传递.
 * - 下面的克隆羊的例子就是浅拷贝
 * - 浅拷贝时使用默认的clone()方法来实现 Sheep sheep = (Sheep) super.clone();
 * 深拷贝:
 * - 复制对象的所有基本数据类型的成员变量值
 * - 为所有引用数据类型的成员变量申请存储空间，并复制每个引用数据类型成员变量所引用的对象，直到该对象可达的所有对象。
 *    也就是说，对象进行深拷贝要对整个对象进行拷贝
 * - 深拷贝实现方式1: 重写clone方法来实现深拷贝
 * - 深拷贝实现方式2: 通过对象序列化实现深拷贝
 */
public class Sheep2 implements Cloneable{
    private String name;
    private int age;
    private String color;
    private Sheep2 friend;

    public Sheep2(){}

    public Sheep2(String name, int age, String color, Sheep2 friend) {
        this.name = name;
        this.age = age;
        this.color = color;
        this.friend = friend;
    }

    public Sheep2 getFriend() {
        return friend;
    }

    public void setFriend(Sheep2 friend) {
        this.friend = friend;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        if(friend != null) {
            return "Sheep{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    ", color='" + color + '\'' +
                    ", hashcode=" + hashCode() +
                    ", friend=" + friend +
                    '}';
        }else{
            return "Sheep{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    ", color='" + color + '\'' +
                    ", hashcode=" + hashCode() +
                    ", friend=null" +
                    '}';
        }
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        Sheep2 sheep = (Sheep2) super.clone();
        Sheep2 friend = sheep.getFriend();
        if(friend != null){
            sheep.setFriend(new Sheep2(friend.getName(),friend.getAge(),friend.getColor(),null));
        }
        return sheep;
    }
}

