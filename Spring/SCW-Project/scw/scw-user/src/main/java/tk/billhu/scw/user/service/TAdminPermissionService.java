package tk.billhu.scw.user.service;

import tk.billhu.scw.user.vo.request.AdminPermissionRegisterVo;
import tk.billhu.scw.user.vo.request.AdminPermissionUpdateVo;
import tk.billhu.scw.user.vo.response.AdminPermissionVo;

import java.util.List;

public interface TAdminPermissionService {
    String create(AdminPermissionRegisterVo adminPermissionRegisterVo);

    AdminPermissionVo getAdminPermission(String id);

    String UpdateAdminPermission(AdminPermissionUpdateVo adminPermissionUpdateVo);

    String deleteAdminPermission(String id);

    public List<AdminPermissionVo> getAdminPermissionList();

    String assignRolePermissions(String roleId, String permissionIds);

    List<AdminPermissionVo> getPermissionByRoleId(String roleId);
}
