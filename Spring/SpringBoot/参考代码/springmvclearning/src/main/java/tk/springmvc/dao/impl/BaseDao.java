package tk.springmvc.dao.impl;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;

public class BaseDao extends SqlSessionDaoSupport {
    //给SqlSessionDaoSupport注入SqlSessionFactory(定义在applicationContext.xml)
    //然后SqlSessionDaoSupport会创建一个SqlSessionTemplate来访问DB
    @Autowired
    public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory)
    {
        super.setSqlSessionFactory(sqlSessionFactory);
    }
}
