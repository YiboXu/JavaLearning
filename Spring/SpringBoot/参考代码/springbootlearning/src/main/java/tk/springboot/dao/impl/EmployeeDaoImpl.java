package tk.springboot.dao.impl;

import org.springframework.stereotype.Repository;
import tk.springboot.dao.EmployeeDao;
import tk.springboot.model.Employee;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Repository("employeeDao")
public class EmployeeDaoImpl implements EmployeeDao {
    public static List<Employee> datastore = new ArrayList<Employee>();

    static{
        Employee emp1 = new Employee(1,"BillHu","Male","IBM-IGA","hutao@cn.ibm.com");
        Employee emp2 = new Employee(2,"Sofica","Female","IBM-IGA","sofica@cn.ibm.com");
        Employee emp3 = new Employee(3,"Kerry","Female","IBM-US","kerry@us.ibm.com");
        Employee emp4 = new Employee(4,"Milan","Male","IBM-HU","milan@hu.ibm.com");
        Employee emp5 = new Employee(5,"Weiping","Male","IBM-US","weiping@us.ibm.com");

        datastore.addAll(Arrays.asList(emp1,emp2,emp3,emp4,emp5));
    }

    @Override
    public List<Employee> selectAll() {
        return datastore;
    }

    @Override
    public Employee selectById(int id) {

        List<Employee> result = datastore.stream().filter(employee -> employee.getId()==id).collect(Collectors.toList());
        if(result.size() > 0)
            return result.get(0);

        return null;
    }

    @Override
    public Employee addEmployee(Employee employee) {
        datastore.add(employee);
        return employee;
    }

    @Override
    public Employee updateEmployee(Employee employee) {
        deleteEmployee(employee.getId());
        addEmployee(employee);

        return employee;
    }

    @Override
    public Employee deleteEmployee(int id) {
        Employee employee = selectById(id);
        datastore.remove(employee);
        return employee;
    }
}
