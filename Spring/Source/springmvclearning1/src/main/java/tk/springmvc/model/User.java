package tk.springmvc.model;

import java.io.Serializable;

public class User{
    private int id;
    private String name;
    private String psw;

    public User() {
    }

    public User(int id, String name, String psw) {
        this.id = id;
        this.name = name;
        this.psw = psw;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPsw() {
        return psw;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPsw(String psw) {
        this.psw = psw;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", psw='" + psw + '\'' +
                '}';
    }
}
