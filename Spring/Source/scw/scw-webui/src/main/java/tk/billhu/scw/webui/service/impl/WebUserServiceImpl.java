package tk.billhu.scw.webui.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import tk.billhu.scw.enums.UserTypeEnume;
import tk.billhu.scw.vo.resp.AppResponse;
import tk.billhu.scw.webui.entities.TRole;
import tk.billhu.scw.webui.entities.TUser;
import tk.billhu.scw.webui.service.TMemberServiceFeign;
import tk.billhu.scw.webui.service.WebUserService;
import tk.billhu.scw.webui.vo.response.UserLoginVo;

import java.util.ArrayList;
import java.util.List;

@Service
public class WebUserServiceImpl implements WebUserService {
    @Autowired
    private TMemberServiceFeign tMemberServiceFeign;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        //获取管理员账号信息
        AppResponse<UserLoginVo> response = tMemberServiceFeign.getAdminLogin(username);
        if(response != null && response.getData() != null && response.getCode() == 0){
            UserLoginVo userLoginVo = response.getData();
            userLoginVo.setUsertype("9");  //设置用户类型为管理员, 在DispatchController里面, 控制/loginSuccess的跳转页面
            //获取管理员角色
            List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
            AppResponse<List<TRole>> resp = tMemberServiceFeign.getAdminRoles(username);
            if(resp != null && resp.getCode() == 0){
                List<TRole> tRoleList = resp.getData();
                for(TRole role : tRoleList){
                    authorities.add(new SimpleGrantedAuthority(role.getName()));
                }
            }

            return new TUser(userLoginVo, authorities);
        } else { //获取用户账号信息
            response = tMemberServiceFeign.getUserLogin(username);

            if (response != null && response.getCode() == 0) {
                UserLoginVo userLoginVo = response.getData();
                if (userLoginVo != null) {
                    List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
                    UserTypeEnume usertype = UserTypeEnume.USER_VIP0;
                    switch (userLoginVo.getUsertype()) {
                        case "0":
                            usertype = UserTypeEnume.USER_VIP0;
                            break;
                        case "1":
                            usertype = UserTypeEnume.USER_VIP1;
                            break;
                        case "2":
                            usertype = UserTypeEnume.USER_VIP2;
                            break;
                        case "3":
                            usertype = UserTypeEnume.USER_VIP3;
                            break;
                        case "4":
                            usertype = UserTypeEnume.USER_VIP4;
                            break;
                        case "5":
                            usertype = UserTypeEnume.USER_VIP5;
                            break;
                        case "6":
                            usertype = UserTypeEnume.COMPANY;
                            break;
                    }
                    authorities.add(new SimpleGrantedAuthority(usertype.getType()));

                    return new TUser(userLoginVo, authorities);
                }
            }
        }

        throw new UsernameNotFoundException("User '" + username + "' not found.");
    }
}
