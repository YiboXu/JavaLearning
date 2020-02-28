package tk.springmvc.dao;

import tk.springmvc.model.WebUser;

public interface WebUserDao {
    WebUser getWebUser(String username);
}
