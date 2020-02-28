package tk.springmvc.service;

import tk.springmvc.model.Country;

import java.util.List;

//添加业务处理代码
public interface CountryService {
    List<Country> selectAll();
}
