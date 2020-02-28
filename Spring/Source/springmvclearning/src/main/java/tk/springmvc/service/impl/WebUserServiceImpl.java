package tk.springmvc.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import tk.springmvc.dao.WebUserDao;
import tk.springmvc.model.WebUser;
import tk.springmvc.service.WebUserService;

import java.util.ArrayList;
import java.util.List;

public class WebUserServiceImpl implements WebUserService {
    @Autowired
    private WebUserDao webUserDao;

    public void setWebUserDao(WebUserDao webUserDao) {
        this.webUserDao = webUserDao;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        WebUser webUser = webUserDao.getWebUser(username);

        if(webUser != null){
            List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
            authorities.add(new SimpleGrantedAuthority(webUser.getUsergroup()));

            return new User(webUser.getUsername(),webUser.getPassword(),authorities);
        }

        throw new UsernameNotFoundException("User '" + username + "' not found.");
    }
}
