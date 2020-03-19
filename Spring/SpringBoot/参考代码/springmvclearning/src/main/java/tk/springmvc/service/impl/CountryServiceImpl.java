package tk.springmvc.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import tk.springmvc.dao.CountryDao;
import tk.springmvc.model.Country;
import tk.springmvc.service.CountryService;

import java.util.List;

@Service("countryService")
public class CountryServiceImpl implements CountryService {

    @Autowired
    //因为有2个CountryDao的实现类，所以加上@Qualifier来通过名字注入
    @Qualifier("countryDao")
    private CountryDao countryDao;

    public void setCountryDao(CountryDao countryDao) {
        this.countryDao = countryDao;
    }

    @Override
    public List<Country> selectAll() {
        return countryDao.selectAll();
    }
}
