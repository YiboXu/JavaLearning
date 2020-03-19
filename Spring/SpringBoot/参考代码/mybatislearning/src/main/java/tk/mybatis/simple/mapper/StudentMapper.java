package tk.mybatis.simple.mapper;

import tk.mybatis.simple.model.Student;

import java.util.List;

public interface StudentMapper {
    List<Student> selectAll();
    List<Student> selectAll2();
}
