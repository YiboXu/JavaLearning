package tk.springmvc.dao.impl;

import org.springframework.stereotype.Repository;
import tk.springmvc.dao.WebUserDao;
import tk.springmvc.model.WebUser;
import tk.springmvc.mybatis.mapper.WebUserMapper;

@Repository("webUserDao")
public class WebUserDaoImpl extends BaseDao implements WebUserDao {

    @Override
    public WebUser getWebUser(String username) {
        return this.getSqlSession().getMapper(WebUserMapper.class).getWebUser(username);
    }
}
