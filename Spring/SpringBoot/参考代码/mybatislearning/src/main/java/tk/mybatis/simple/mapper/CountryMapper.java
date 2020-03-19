package tk.mybatis.simple.mapper;

import tk.mybatis.simple.model.Country;

import java.util.List;
import java.util.Map;

public interface CountryMapper {
    List<Country> selectAll();

    int insertCountry(Country country);

    int deleteCountryByCountryCode(String countrycode);

    int updateCountry(Country country);

    Country selectCountryByNameAndCode(String countryname, String countrycode);
    Country selectCountryByMap(Map<String,String> map);
}
