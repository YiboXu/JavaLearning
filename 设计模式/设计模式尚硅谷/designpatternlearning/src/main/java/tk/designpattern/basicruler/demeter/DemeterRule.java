package tk.designpattern.basicruler.demeter;

import java.util.ArrayList;
import java.util.List;

/**
 * - 一个对象应该对其他对象保持最少的了解
 * - 类与类关系越密切，耦合度越大
 * - 迪米特法则又叫最少知道原则，即一个类对自己依赖的类直到的越少越好.也就是说，对于被依赖的类不管多么负责，都尽量将
 *   逻辑封装在类的内部。对外除了提供的public方法，不对外泄露任何信息.
 * - 迪米特法则有个更简单的定义: 只与直接的朋友通信
 *   直接朋友:
 *   每个对象都会与其他对象有耦合关系，只要两个对象之间有耦合关系，我们就说这2个对象之间时朋友关系.
 *   耦合的方式有很多，依赖，关联，组合，聚合等. 其中，我们称出现成员变量, 方法参数， 方法返回值中的类为直接的朋友,
 *   而出现在局部变量中的类不是直接的朋友. 也就是说，陌生的类最好不要以局部变量的形式出现在类的内部.
 */
class Employee{
    private int id;
    public Employee(int id){this.id = id;}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                '}';
    }
}

interface CompanyInterface1{
    public List<Employee> getEmployeeList();
}
class Company1 implements CompanyInterface1{
    private List<Employee> employeeList;

    public Company1(List<Employee> employeeList) {
        this.employeeList = employeeList;
    }

    public Company1() {
        employeeList = new ArrayList();
    }

    public List<Employee> getEmployeeList() {
        return employeeList;
    }
}

class CompanyManager1{

    public void printEmployee(CompanyInterface1 company){
        //这里使得CompanyManager1和Employee发生耦合
        //任何在方法体内部需要使用陌生类的时候，都应该将陌生类封装到类的直接朋友(成员变量, 方法参数)的方法中进行使用，从而降低不必要的耦合
        List<Employee> employeeList = company.getEmployeeList();
        employeeList.stream().forEach(System.out::println);
    }
}

interface CompanyInterface2{
    public List<Employee> getEmployeeList();
    public void printEmployee();
}
class Company2 implements CompanyInterface2{
    private List<Employee> employeeList;

    public Company2(List<Employee> employeeList) {
        this.employeeList = employeeList;
    }

    public Company2() {
        employeeList = new ArrayList();
    }

    public List<Employee> getEmployeeList() {
        return employeeList;
    }

    public void printEmployee(){
        employeeList.stream().forEach(System.out::println);
    }
}

class CompanyManager2{

    //通过Company2来打印员工列表，使得CompanyManager2和Employee没有耦合关系
    public void printEmployee(CompanyInterface2 company){
        company.printEmployee();
    }
}

public class DemeterRule {
}
