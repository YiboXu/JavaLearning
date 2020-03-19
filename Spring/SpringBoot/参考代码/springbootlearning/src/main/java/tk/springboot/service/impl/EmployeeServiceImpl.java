package tk.springboot.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.springboot.dao.EmployeeDao;
import tk.springboot.model.Employee;
import tk.springboot.service.EmployeeService;

import java.util.List;

@Service("employeeService")
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    private EmployeeDao employeeDao;

    public void setEmployeeDao(EmployeeDao employeeDao) {
        this.employeeDao = employeeDao;
    }

    @Override
    public List<Employee> fetchAllEmployee() {
        return employeeDao.selectAll();
    }

    @Override
    public Employee addEmployee(Employee employee) {
        employeeDao.addEmployee(employee);
        return employee;
    }

    @Override
    public Employee fetchEmployeeById(int id) {
        return employeeDao.selectById(id);
    }

    @Override
    public Employee updateEmployee(Employee employee) {
        return employeeDao.updateEmployee(employee);
    }
}
