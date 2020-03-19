package tk.springboot.model;

public class Employee {
    private int id;
    private String name;
    private String sex;
    private String department;
    private String email;

    public Employee(){}

    public Employee(String name, String sex, String department, String email) {
        this.name = name;
        this.sex = sex;
        this.department = department;
        this.email = email;
    }

    public Employee(int id, String name, String sex, String department, String email) {
        this.id = id;
        this.name = name;
        this.sex = sex;
        this.department = department;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                ", department='" + department + '\'' +
                ", email=" + email +
                '}';
    }
}
