package tk.springmvc.service;

import tk.springmvc.model.Company;

import java.util.List;

public interface CompanyService {
    List<Company> queryAll();
    Company querySingle(int id);
}
