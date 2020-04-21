package tk.designpattern.prototype;

import java.io.*;

public class Sheep3 implements Serializable {
    private String name;
    private int age;
    private String color;
    private Sheep3 friend;

    public Sheep3(){}

    public Sheep3(String name, int age, String color, Sheep3 friend) {
        this.name = name;
        this.age = age;
        this.color = color;
        this.friend = friend;
    }

    public Sheep3 getFriend() {
        return friend;
    }

    public void setFriend(Sheep3 friend) {
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

    //通过序列化进行深拷贝
    public Sheep3 deepClone(){
        try(ByteArrayOutputStream baos = new ByteArrayOutputStream();
            ObjectOutputStream oos = new ObjectOutputStream(baos);) {
                oos.writeObject(this);
                try(ByteArrayInputStream bais = new ByteArrayInputStream(baos.toByteArray());
                    ObjectInputStream ois = new ObjectInputStream(bais);){
                    Sheep3 sheepSerialCloned = (Sheep3) ois.readObject();
                    return sheepSerialCloned;
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }
}
