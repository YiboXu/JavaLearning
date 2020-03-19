package tk.springboot.dao.impl;

import org.springframework.stereotype.Repository;
import tk.springboot.dao.DepartmentDao;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Repository("departmentDao")
public class DepartmentDaoImpl implements DepartmentDao {
    public static List<String> datastore = new ArrayList<String>();

    static{
        datastore.addAll(Arrays.asList("IBM-IGA","IBM-US","IBM-CN","IBM-HU","IBM-UK","IBM-IN"));
    }

    @Override
    public List<String> getAllDepartment() {
        return datastore;
    }

    @Override
    public String addDepartment(String department) {
        datastore.add(department);
        return department;
    }

    @Override
    public String deleteDepartment(String department) {
        int n = datastore.indexOf(department);
        if(n>=0){
            datastore.remove(n);
            return department;
        }

        return null;
    }

    @Override
    public String updateDepartment(String department) {

        deleteDepartment(department);
        addDepartment(department);

        return department;
    }
}
