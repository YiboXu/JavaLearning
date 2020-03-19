package tk.springboot.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tk.springboot.model.Country;
import tk.springboot.mybatis.mapper.CountryMapper;
import tk.springboot.service.impl.CountryService;

import java.util.List;

@RestController
public class CountryController {
    @Autowired
    private CountryService countryService;

    public void setCountryService(CountryService countryService) {
        this.countryService = countryService;
    }

    @RequestMapping("/country")
    public List<Country> countryList(){
        return countryService.selectAll();
    }

    @RequestMapping("/country/{id}")
    public Country getCountryById(@PathVariable Long id){
        return countryService.getById(id);
    }

    @RequestMapping("/country/update")
    public Country updateCountry(Country country){
        return countryService.updateCountry(country);
    }

    @RequestMapping("/country/delete/{id}")
    public String deleteCountryById(@PathVariable Long id){
        countryService.deleteCountryById(id);
        return "success";
    }

    @RequestMapping("/country/{countrycode}/{countryname}")
    public Country getCountryByCodeAndName(@PathVariable String countrycode, @PathVariable String countryname){
        return countryService.selectCountryByNameAndCode(countryname,countrycode);
    }
}
