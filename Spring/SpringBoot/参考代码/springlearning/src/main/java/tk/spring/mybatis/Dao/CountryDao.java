package tk.spring.mybatis.Dao;

import tk.spring.mybatis.model.Country;

import java.util.List;

public interface CountryDao {
    List<Country> selectAll();

    int insertCountry(Country country);

    int deleteCountryByCountryCode(String countrycode);

    int updateCountry(Country country);
}
