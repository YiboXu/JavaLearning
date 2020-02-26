package tk.spring.mybatis;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;

public class Test {
    public static void main() throws Exception {
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBean.getObject();
        SqlSessionTemplate template = new SqlSessionTemplate(sqlSessionFactory);
        template.selectList("tk.spring.mybatis.mapper.CountryMapper.selectAll");
    }
}
