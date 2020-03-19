package tk.springmvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import tk.springmvc.model.Country;
import tk.springmvc.service.CountryService;

import java.util.List;

@Controller
@RequestMapping("/country")
public class CountryController {
    @Autowired
    //因为有2个CountryService的实现类，所以加上@Qualifier来通过名字注入
    @Qualifier("countryService")
    private CountryService countryService;

    public void setCountryService(CountryService countryService) {
        this.countryService = countryService;
    }

    @GetMapping
    public String loadPage(){
        return "country";
    }

    @PostMapping
    @ResponseBody
    public List<Country> getCountry(){
        return countryService.selectAll();
    }
}
