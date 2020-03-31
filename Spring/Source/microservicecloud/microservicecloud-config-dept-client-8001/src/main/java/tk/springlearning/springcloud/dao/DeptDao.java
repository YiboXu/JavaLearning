package tk.springlearning.springcloud.dao;

import org.apache.ibatis.annotations.Mapper;
import tk.springlearning.springcloud.entities.Dept;

import java.util.List;

@Mapper
public interface DeptDao {
    public boolean addDept(Dept dept);
    public Dept findById(Long id);
    public List<Dept> findAll();
}
