package tk.springmvc.dao;

import tk.springmvc.model.Country;

import java.util.List;

//添加数据库操作
public interface CountryDao {
    List<Country> selectAll();
}
