package tk.billhu.scw.user.service;

import com.github.pagehelper.PageInfo;
import tk.billhu.scw.user.vo.request.AdminRegisterVo;
import tk.billhu.scw.user.vo.request.AdminUpdateVo;
import tk.billhu.scw.user.vo.response.AdminResponseVo;

public interface TAdminService {
    int register(AdminRegisterVo adminRegisterVo);

    PageInfo<AdminResponseVo> getAllUser(int pageNum, int pageSize, String condition);

    AdminResponseVo getAdminUser(String id);

    AdminResponseVo UpdateAdminUser(AdminUpdateVo adminUpdateVo);

    int deleteAdminUser(String id);

    int deleteAdminUsers(String ids);
}
