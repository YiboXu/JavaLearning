package tk.billhu.scw.user.service;

import com.github.pagehelper.PageInfo;
import tk.billhu.scw.user.entities.TRole;
import tk.billhu.scw.user.vo.request.AdminRoleRegisterVo;
import tk.billhu.scw.user.vo.request.AdminRoleUpdateVo;
import tk.billhu.scw.user.vo.response.AdminRoleResponseVo;

import java.util.List;

public interface TAdminRoleService {

    PageInfo<AdminRoleResponseVo>  getAllAdminRole(int pageNum, int pageSize, String condition);

    AdminRoleResponseVo getAdminRole(String id);

    String UpdateAdminRole(AdminRoleUpdateVo adminRoleUpdateVo);

    String deleteAdminRole(String id);

    String deleteAdminRoles(String ids);

    String create(AdminRoleRegisterVo adminRoleRegisterVo);
}
