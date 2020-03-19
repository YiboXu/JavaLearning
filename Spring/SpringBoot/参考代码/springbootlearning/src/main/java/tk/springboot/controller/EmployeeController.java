package tk.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import tk.springboot.model.Employee;
import tk.springboot.service.DepartmentService;
import tk.springboot.service.EmployeeService;

@Controller
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private DepartmentService departmentService;

    public void setDepartmentService(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    public void setEmployeeService(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/emps")
    public String showAllEmployee(Model model){
        model.addAttribute("employees",employeeService.fetchAllEmployee());
        return "emp/employeeList";
    }

    @GetMapping("/emp")
    public String addEmployeePage(Model model){
        model.addAttribute("departments",departmentService.fetchAllDepartment());
        return "emp/addEmployee";
    }

    @PostMapping("/emp")
    public String addEmployee(Employee employee){
        employeeService.addEmployee(employee);
        return "redirect:/emps";
    }

    @GetMapping("/emp/{id}")
    public String getEmployeeById(@PathVariable int id,Model model){
        model.addAttribute("departments",departmentService.fetchAllDepartment());
        Employee employee = employeeService.fetchEmployeeById(id);
        if(employee != null){
            model.addAttribute("emp",employee);
        }

        return "emp/updateEmployee";
    }

    @PostMapping("/emp/{id}")
    public String updateEmployee(Employee employee,@PathVariable int id){
        employee.setId(id);
        employeeService.updateEmployee(employee);

        return "redirect:/emps";
    }
}
