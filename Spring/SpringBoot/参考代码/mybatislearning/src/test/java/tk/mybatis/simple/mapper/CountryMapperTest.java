package tk.mybatis.simple.mapper;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import tk.mybatis.simple.model.Country;

public class CountryMapperTest extends BaseMapperTest{
	
	@Test
	public void testSelectAll() {
		SqlSession sqlSession = getSqlSession();
		
		List<Country> countryList1 = sqlSession.selectList("tk.mybatis.simple.mapper.CountryMapper.selectAll");
		printCountryList(countryList1);

		//insert
		Country country = new Country();
		country.setCountryname("Japanx");
		country.setCountrycode("JP");
		sqlSession.getMapper(CountryMapper.class).insertCountry(country);
		country.setCountryname("Japan");
		sqlSession.getMapper(CountryMapper.class).updateCountry(country);

		//select by mapper
		List<Country> countryList2 = sqlSession.getMapper(CountryMapper.class).selectAll();
		printCountryList(countryList2);

		//delete
		sqlSession.getMapper(CountryMapper.class).deleteCountryByCountryCode("JP");

		//select by mapper
		List<Country> countryList3 = sqlSession.getMapper(CountryMapper.class).selectAll();
		printCountryList(countryList3);

		//select by NameAndCode
		Country us = sqlSession.getMapper(CountryMapper.class).selectCountryByNameAndCode("American","US");
		System.out.println(us);

		Map<String,String> map = new HashMap<String,String>();
		map.put("countryname","China");
		map.put("countrycode","CN");
		Country cn = sqlSession.getMapper(CountryMapper.class).selectCountryByMap(map);
		System.out.println(cn);

		sqlSession.close();
	}
	
	private void printCountryList(List<Country> countryList) {
		for(Country country:countryList) {
			System.out.printf("%-4d%4s%4s\n", country.getId(), country.getCountryname(), country.getCountrycode());
		}
	}
}
