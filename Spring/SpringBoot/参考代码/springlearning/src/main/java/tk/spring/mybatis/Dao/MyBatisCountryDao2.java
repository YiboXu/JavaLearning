package tk.spring.mybatis.Dao;

import org.mybatis.spring.SqlSessionTemplate;
import tk.spring.mybatis.mapper.CountryMapper;
import tk.spring.mybatis.model.Country;

import java.util.List;

public class MyBatisCountryDao2 implements CountryDao {
    private SqlSessionTemplate sqlSessionTemplate;
    public void setSqlSessionTemplate(SqlSessionTemplate sqlSessionTemplate){
        this.sqlSessionTemplate = sqlSessionTemplate;
    }

    @Override
    public List<Country> selectAll() {
        return sqlSessionTemplate.getMapper(CountryMapper.class).selectAll();
    }

    @Override
    public int insertCountry(Country country) {
         return sqlSessionTemplate.getMapper(CountryMapper.class).insertCountry(country);
    }

    @Override
    public int deleteCountryByCountryCode(String countrycode) {
         return sqlSessionTemplate.getMapper(CountryMapper.class).deleteCountryByCountryCode(countrycode);
    }

    @Override
    public int updateCountry(Country country) {
         return sqlSessionTemplate.getMapper(CountryMapper.class).updateCountry(country);
    }
}
