package tk.spring.mybatis.Dao;

import org.mybatis.spring.SqlSessionTemplate;
import tk.spring.mybatis.model.Country;

import java.util.List;

public class MyBatisCountryDao implements CountryDao {
    private SqlSessionTemplate sqlSessionTemplate;
    public void setSqlSessionTemplate(SqlSessionTemplate sqlSessionTemplate){
        this.sqlSessionTemplate = sqlSessionTemplate;
    }
    @Override
    public List<Country> selectAll() {
        return sqlSessionTemplate.selectList("tk.spring.mybatis.mapper.CountryMapper.selectAll");
    }

    @Override
    public int insertCountry(Country country) {
        return sqlSessionTemplate.insert("tk.spring.mybatis.mapper.CountryMapper.insertCountry",country);
    }

    @Override
    public int deleteCountryByCountryCode(String countrycode) {
        return sqlSessionTemplate.delete("tk.spring.mybatis.mapper.CountryMapper.deleteCountryByCountryCode",countrycode);
    }

    @Override
    public int updateCountry(Country country) {
        return sqlSessionTemplate.update("tk.spring.mybatis.mapper.CountryMapper.updateCountry",country);
    }
}
