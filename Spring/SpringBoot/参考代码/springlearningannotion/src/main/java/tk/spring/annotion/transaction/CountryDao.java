package tk.spring.annotion.transaction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public class CountryDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private CountryRowMapper countryRowMapper;

    @Transactional
    public void insert(Country country){
        String sql = "insert into country(countryname,countrycode) values(?,?)";
        int result = jdbcTemplate.update(sql,country.getCountryname(),country.getCountrycode());
        //trigger the transaction manager to rollback
        int x = 1/0;
    }

    public List<Country> selectAll(){
        return jdbcTemplate.query("select id, countrycode, countryname from country", countryRowMapper);
    }

    @Transactional
    public void deleteCountryById(long id){
        String sql = "delete country where id=?";
        int result = jdbcTemplate.update(sql,id);
    }
}
