package tk.spring.annotion.transaction;


import org.springframework.jdbc.core.RowMapper;

import javax.swing.tree.TreePath;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CountryRowMapper implements RowMapper<Country> {

    @Override
    public Country mapRow(ResultSet resultSet, int i) throws SQLException {
        Country country = new Country();
        country.setId(resultSet.getLong("id"));
        country.setCountryname(resultSet.getString("countryname"));
        country.setCountrycode(resultSet.getString("countrycode"));
        return country;
    }
}
