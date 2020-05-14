package tk.billhu.scw.webui.entities;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import tk.billhu.scw.webui.vo.response.UserLoginVo;

import java.util.List;

public class TUser extends User {
    private UserLoginVo userLoginVo;

    public TUser(UserLoginVo userLoginVo, List<GrantedAuthority> authorities) {
        super(userLoginVo.getUsername(), userLoginVo.getUserpswd(), true, true, true, true, authorities);
        this.userLoginVo = userLoginVo;
    }

    public UserLoginVo getUserLoginVo() {
        return userLoginVo;
    }
}
