package tk.springboot.mybatis.mapper;

import org.apache.ibatis.annotations.Mapper;
import tk.springboot.model.Country;

import java.util.List;
import java.util.Map;

public interface CountryMapper {
    List<Country> selectAll();

    int insertCountry(Country country);

    int deleteCountryByCountryCode(String countrycode);

    int deleteCountryById(Long id);

    int updateCountry(Country country);

    Country selectCountryByNameAndCode(String countryname, String countrycode);
    Country selectCountryByMap(Map<String, String> map);

    Country selectCountryById(Long id);

    Country selectCountryByCountryCode(String countrycode);
    Country selectCountryByCountryName(String countryname);
}
