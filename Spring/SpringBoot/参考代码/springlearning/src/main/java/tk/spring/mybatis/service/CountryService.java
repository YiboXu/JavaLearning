package tk.spring.mybatis.service;

import tk.spring.mybatis.Dao.CountryDao;
import tk.spring.mybatis.model.Country;

public class CountryService {
    private CountryDao countryDao;
    public void setCountryDao(CountryDao countryDao){
        this.countryDao = countryDao;
    }

    public void transaction(){
        Country countryAdd = new Country();
        countryAdd.setCountrycode("JP");
        countryAdd.setCountryname("Japan");

        countryDao.insertCountry(countryAdd);
        countryDao.deleteCountryByCountryCode("CN");
    }
}
