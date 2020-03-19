package tk.springmvc.mybatis.mapper;

import tk.springmvc.model.WebUser;

public interface WebUserMapper {
    WebUser getWebUser(String username);
}
