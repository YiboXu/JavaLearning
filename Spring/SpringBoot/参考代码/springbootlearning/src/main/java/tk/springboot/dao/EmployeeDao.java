package tk.springboot.dao;

import tk.springboot.model.Employee;

import java.util.List;

public interface EmployeeDao {
    List<Employee> selectAll();
    Employee selectById(int id);
    Employee addEmployee(Employee employee);
    Employee updateEmployee(Employee employee);
    Employee deleteEmployee(int id);
}
