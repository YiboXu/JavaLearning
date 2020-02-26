package tk.mybatis.simple.mapper;

import tk.mybatis.simple.model.Company;

import java.util.List;

public interface CompanyMapper {
    List<Company> selectAll();
    List<Company> selectAll2();
}
