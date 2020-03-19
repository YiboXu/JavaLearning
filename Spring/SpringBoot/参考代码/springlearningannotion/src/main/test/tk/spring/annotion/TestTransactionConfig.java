package tk.spring.annotion;

import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import tk.spring.annotion.transaction.Country;
import tk.spring.annotion.transaction.CountryService;
import tk.spring.annotion.transaction.TransactionConfig;

public class TestTransactionConfig extends Base {

    public TestTransactionConfig() {
        super(TransactionConfig.class);
    }

    @Test
    public void test(){
        CountryService countryService = (CountryService) this.getBeanById("countryService");
        Country country = new Country();
        country.setCountrycode("xx");
        country.setCountryname("xxxxx");
        countryService.addCountry(country);

        countryService.printAllCountry();
    }
}
