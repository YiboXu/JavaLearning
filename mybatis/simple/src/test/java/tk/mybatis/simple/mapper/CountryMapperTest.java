package tk.mybatis.simple.mapper;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import tk.mybatis.simple.model.Country;

public class CountryMapperTest extends BaseMapperTest{
	
	@Test
	public void testSelectAll() {
		SqlSession sqlSession = getSqlSession();
		
		List<Country> countryList = sqlSession.selectList("selectAll");
		
		printCountryList(countryList);
		
		sqlSession.close();
	}
	
	private void printCountryList(List<Country> countryList) {
		for(Country country:countryList) {
			System.out.printf("%-4d%4s%4s\n", country.getId(), country.getCountryname(), country.getCountrycode());
		}
	}
}
