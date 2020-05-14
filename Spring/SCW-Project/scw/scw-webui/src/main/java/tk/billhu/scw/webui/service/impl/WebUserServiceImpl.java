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
import tk.billhu.scw.webui.entities.TRolePermission;
import tk.billhu.scw.webui.entities.TUser;
import tk.billhu.scw.webui.service.TMemberServiceFeign;
import tk.billhu.scw.webui.service.WebUserService;
import tk.billhu.scw.webui.vo.response.AdminPermissionVo;
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
            //添加基本的管理员ROLE
            authorities.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
            AppResponse<List<TRole>> resp = tMemberServiceFeign.getAdminRoles(username);
            if(resp != null && resp.getCode() == 0){
                List<TRole> tRoleList = resp.getData();
                for(TRole role : tRoleList){
                    authorities.add(new SimpleGrantedAuthority("ROLE_"+role.getName()));
                    //获取管理员角色所拥有的权限
                    AppResponse<List<AdminPermissionVo>> resp1 = tMemberServiceFeign.getAdminPermissionByRoleId(role.getId().toString());
                    if(resp1 != null && resp1.getCode() == 0) {
                        List<AdminPermissionVo> adminPermissionVoList = resp1.getData();
                        for (AdminPermissionVo adminPermissionVo : adminPermissionVoList){
                            if(adminPermissionVo.getName()==null){
                                continue;
                            }
                            authorities.add(new SimpleGrantedAuthority(adminPermissionVo.getName()));
                        }
                    }
                }
            }

            return new TUser(userLoginVo, authorities);
        } else { //获取用户账号信息
            response = tMemberServiceFeign.getUserLogin(username);

            if (response != null && response.getCode() == 0) {
                UserLoginVo userLoginVo = response.getData();
                if (userLoginVo != null) {
                    List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
                    //添加基本的用户ROLE
                    authorities.add(new SimpleGrantedAuthority("ROLE_USER"));
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
