package tk.springmvc.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import tk.springmvc.jpa.repository.CompanyRepository;
import tk.springmvc.model.Company;
import tk.springmvc.service.CompanyService;

import java.util.List;

@Service("companyService")
public class CompanyServiceImpl implements CompanyService {
    @Autowired
    private CompanyRepository companyRepository;

    public void setCompanyDao(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }

    @Override
    public List<Company> queryAll() {
        return companyRepository.findAll();
    }

    @Override
    public Company querySingle(int id) {
        return companyRepository.findById(id);
    }
}
