package tk.springboot.dao;

import java.util.List;

public interface DepartmentDao {
    List<String> getAllDepartment();
    String addDepartment(String department);
    String deleteDepartment(String department);
    String updateDepartment(String department);
}
