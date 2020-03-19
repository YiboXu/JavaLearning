package tk.spring.annotion.transaction;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("countryService")
public class CountryService {
    private static Logger logger = LogManager.getLogger(CountryService.class);

    @Autowired
    private CountryDao countryDao;

    public void addCountry(Country country){
        countryDao.insert(country);
        logger.info(country+" is added to database.");
    }

    public void printAllCountry(){
        countryDao.selectAll().stream().forEach(logger::info);
    }

    public void deleteCountry(long id){
        countryDao.deleteCountryById(id);
    }
}
