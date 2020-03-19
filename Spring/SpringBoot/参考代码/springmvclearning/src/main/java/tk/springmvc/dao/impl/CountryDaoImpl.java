package tk.springmvc.dao.impl;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;
import tk.springmvc.dao.CountryDao;
import tk.springmvc.model.Country;
import tk.springmvc.mybatis.mapper.CountryMapper;

import java.util.List;

@Repository("countryDao")
public class CountryDaoImpl extends BaseDao implements CountryDao {

    @Override
    public List<Country> selectAll() {
        return this.getSqlSession().getMapper(CountryMapper.class).selectAll();
    }
}
