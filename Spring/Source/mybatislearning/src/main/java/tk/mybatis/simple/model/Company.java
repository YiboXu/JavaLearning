package tk.mybatis.simple.model;

import java.util.List;

public class Company {
    private int id;
    private String name;
    private List<Employee> employees;

    public int getId(){return id;}
    public String getName(){return name;}
    public List<Employee> getEmployees(){return employees;}

    public void setId(int id){this.id = id;}
    public void setName(String name){this.name = name;}
    public void setEmployees(List<Employee> employees){this.employees = employees;}

    public String toString(){
        return "Company: "+id+"-"+name+", employees: "+employees;
    }
}
