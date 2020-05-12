package tk.billhu.scw.user.service;

import tk.billhu.scw.user.vo.request.AdminMenuRegisterVo;
import tk.billhu.scw.user.vo.request.AdminMenuUpdateVo;
import tk.billhu.scw.user.vo.response.AdminMenuVo;

import java.util.List;

public interface TAdminMenuService {
    String create(AdminMenuRegisterVo adminMenuRegisterVo);

    AdminMenuVo getAdminMenu(String id);

    String UpdateAdminMenu(AdminMenuUpdateVo adminMenuUpdateVo);

    String deleteAdminMenu(String id);

    public List<AdminMenuVo> getAdminMenuList();
}
