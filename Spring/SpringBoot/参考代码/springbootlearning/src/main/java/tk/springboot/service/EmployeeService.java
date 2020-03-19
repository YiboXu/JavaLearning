package tk.springboot.service;

import tk.springboot.model.Employee;

import java.util.List;

public interface EmployeeService {
    List<Employee> fetchAllEmployee();
    Employee addEmployee(Employee employee);
    Employee fetchEmployeeById(int id);
    Employee updateEmployee(Employee employee);
}
