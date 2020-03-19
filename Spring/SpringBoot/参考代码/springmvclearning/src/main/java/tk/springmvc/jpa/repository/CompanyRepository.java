package tk.springmvc.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tk.springmvc.model.Company;

import java.io.Serializable;

public interface CompanyRepository extends JpaRepository<Company, Serializable> {
    Company findById(int id);
    Company findByIdAndName(int id,String name);
}
