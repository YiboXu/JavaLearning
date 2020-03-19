package tk.mybatis.simple.mapper;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import tk.mybatis.simple.model.Company;

import java.util.List;

public class CompanyMapperTest extends BaseMapperTest {
    @Test
    public void testSelectAll() {
        SqlSession sqlSession = getSqlSession();
        List<Company> companies = sqlSession.getMapper(CompanyMapper.class).selectAll();
        companies.stream().forEach(System.out::println);

        List<Company> companies2 = sqlSession.getMapper(CompanyMapper.class).selectAll2();
        companies2.stream().forEach(System.out::println);

        sqlSession.close();
    }
}
