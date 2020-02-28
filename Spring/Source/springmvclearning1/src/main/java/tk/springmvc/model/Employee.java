package tk.springmvc.model;

public class Employee {
    private int id;
    private String name;
    private String psw;

    public Employee() {
    }

    public Employee(int id, String name, String psw) {
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
}
