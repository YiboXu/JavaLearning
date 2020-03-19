package tk.springboot.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tk.springboot.jpa.repository.CompanyRepository;
import tk.springboot.model.Company;

import java.util.List;

@RestController
public class CompanyController {
    @Autowired
    private CompanyRepository companyRepository;

    public void setCompanyRepository(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }

    @RequestMapping("/company")
    public List<Company> listCompany(){
        return companyRepository.findAll();
    }
}
