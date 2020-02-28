package tk.springmvc.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import tk.springmvc.dao.CountryDao;
import tk.springmvc.model.Country;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository("countryJdbcDao")
public class CountryJdbcDaoImpl implements CountryDao {
    @Autowired
    private JdbcOperations jdbcOperations;

    public void setJdbcOperations(JdbcOperations jdbcOperations) {
        this.jdbcOperations = jdbcOperations;
    }

    @Override
    public List<Country> selectAll() {
        return jdbcOperations.query("select id,countryname,countrycode from country",new CountryRowMapper());
    }

    private static final class CountryRowMapper implements RowMapper<Country> {
        public Country mapRow(ResultSet rs, int rowNum) throws SQLException {
            long id = rs.getLong("id");
            String countryname = rs.getString("countryname");
            String countrycode = rs.getString("countrycode");

            Country country =  new Country();
            country.setId(id);
            country.setCountryname(countryname);
            country.setCountrycode(countrycode);

            return country;
        }
    }
}
