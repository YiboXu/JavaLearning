package tk.springmvc.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import tk.springmvc.dao.CountryDao;
import tk.springmvc.model.Country;
import tk.springmvc.service.CountryService;

import java.util.List;

@Service("countryJdbcService")
public class CountryJdbcServiceImple implements CountryService {

    @Autowired
    //因为有2个CountryDao的实现类，所以加上@Qualifier来通过名字注入
    @Qualifier("countryJdbcDao")
    private CountryDao countryDao;

    @Override
    public List<Country> selectAll() {
        return countryDao.selectAll();
    }
}
