package tk.springmvc.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.springmvc.dao.CountryDao;
import tk.springmvc.model.Country;
import tk.springmvc.service.CountryService;

import java.util.List;

@Service("countryService")
public class CountryServiceImpl implements CountryService {

    @Autowired
    private CountryDao countryDao;

    public void setCountryDao(CountryDao countryDao) {
        this.countryDao = countryDao;
    }

    @Override
    public List<Country> selectAll() {
        return countryDao.selectAll();
    }
}
