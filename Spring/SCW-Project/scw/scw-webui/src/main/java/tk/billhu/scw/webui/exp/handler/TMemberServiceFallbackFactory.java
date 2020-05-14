package tk.billhu.scw.webui.exp.handler;

import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestParam;
import tk.billhu.scw.vo.resp.AppResponse;
import tk.billhu.scw.webui.entities.TRole;
import tk.billhu.scw.webui.service.TMemberServiceFeign;
import tk.billhu.scw.webui.vo.request.*;
import tk.billhu.scw.webui.vo.response.*;

import java.util.List;

@Component
public class TMemberServiceFallbackFactory implements FallbackFactory<TMemberServiceFeign> {

    @Override
    public TMemberServiceFeign create(Throwable throwable) {
        return new TMemberServiceFeign(){

            @Override
            public AppResponse<UserResponseVo> login(String loginacct, String password) {
                throwable.printStackTrace();
                AppResponse response = new AppResponse();
                response.setMsg("远程服务[登录]调用失败");
                return response;
            }

            @Override
            public AppResponse<List<UserAddressVo>> getAddress(String accessToken) {
                throwable.printStackTrace();
                AppResponse response = new AppResponse();
                response.setMsg("远程服务[获取用户收货地址]调用失败");
                return response;
            }

            @Override
            public AppResponse<List<UserProjectVo>> support(String accessToken) {
                throwable.printStackTrace();
                AppResponse response = new AppResponse();
                response.setMsg("远程服务[获取支持项目]调用失败");
                return response;
            }

            @Override
            public AppResponse<List<UserProjectVo>> star(String accessToken) {
                throwable.printStackTrace();
                AppResponse response = new AppResponse();
                response.setMsg("远程服务[获取关注项目]调用失败");
                return response;
            }

            @Override
            public AppResponse<List<UserProjectVo>> create(String accessToken) {
                throwable.printStackTrace();
                AppResponse response = new AppResponse();
                response.setMsg("远程服务[获取创建项目]调用失败");
                return response;
            }

            @Override
            public AppResponse<UserLoginVo> getUserLogin(String username) {
                throwable.printStackTrace();
                AppResponse response = new AppResponse();
                response.setMsg("远程服务[获取账号信息]调用失败");
                return response;
            }

            @Override
            public AppResponse<UserResponseVo> getAccessToken(String loginacct) {
                throwable.printStackTrace();
                AppResponse response = new AppResponse();
                response.setMsg("远程服务[获取登录令牌]调用失败");
                return response;
            }

            @Override
            public AppResponse<String> register(UserRegisterVo userRegisterVo) {
                throwable.printStackTrace();
                AppResponse response = new AppResponse();
                response.setMsg("远程服务[用户注册]调用失败");
                return response;
            }

            @Override
            public AppResponse<String> sendsms(String loginacct) {
                throwable.printStackTrace();
                AppResponse response = new AppResponse();
                response.setMsg("远程服务[获取验证码]调用失败");
                return response;
            }

            @Override
            public AppResponse<UserLoginVo> getAdminLogin(String loginacct) {
                throwable.printStackTrace();
                AppResponse response = new AppResponse();
                response.setMsg("远程服务[获取管理员账号信息]调用失败");
                return response;
            }

            @Override
            public AppResponse<List<TRole>> getAdminRoles(String loginacct) {
                throwable.printStackTrace();
                AppResponse response = new AppResponse();
                response.setMsg("远程服务[获取管理员角色信息]调用失败");
                return response;
            }

            @Override
            public AppResponse<List<AdminMenuVo>> getAllMenu() {
                throwable.printStackTrace();
                AppResponse response = new AppResponse();
                response.setMsg("远程服务[获取管理员菜单信息]调用失败");
                return response;
            }

            @Override
            public AppResponse<Object> getAllUser(int pageNum, int pageSize, String condition) {
                throwable.printStackTrace();
                AppResponse response = new AppResponse();
                response.setMsg("远程服务[获取用户列表信息]调用失败");
                return response;
            }

            @Override
            public AppResponse<String> createAdmin(AdminRegisterVo adminRegisterVo) {
                throwable.printStackTrace();
                AppResponse response = new AppResponse();
                response.setMsg("远程服务[创建管理员]调用失败");
                return response;
            }

            @Override
            public AppResponse<AdminResponseVo> getAdminUser(String id) {
                throwable.printStackTrace();
                AppResponse response = new AppResponse();
                response.setMsg("远程服务[获取管理员信息]调用失败");
                return response;
            }

            @Override
            public AppResponse<AdminResponseVo> updateAdminUser(AdminUpdateVo adminUpdateVo) {
                throwable.printStackTrace();
                AppResponse response = new AppResponse();
                response.setMsg("远程服务[管理员更新]调用失败");
                return response;
            }

            @Override
            public AppResponse<Object> deleteAdminUser(String id) {
                throwable.printStackTrace();
                AppResponse response = new AppResponse();
                response.setMsg("远程服务[删除管理员]调用失败");
                return response;
            }

            @Override
            public AppResponse<Object> deleteAdminUsers(String ids) {
                throwable.printStackTrace();
                AppResponse response = new AppResponse();
                response.setMsg("远程服务[批量删除管理员]调用失败");
                return response;
            }

            @Override
            public AppResponse<Object> getAllRole(int pageNum, int pageSize, String condition) {
                throwable.printStackTrace();
                AppResponse response = new AppResponse();
                response.setMsg("远程服务[获取所有管理员角色]调用失败");
                return response;
            }

            @Override
            public AppResponse<AdminRoleResponseVo> getAdminRole(String id) {
                throwable.printStackTrace();
                AppResponse response = new AppResponse();
                response.setMsg("远程服务[获取管理员角色]调用失败");
                return response;
            }

            @Override
            public AppResponse<String> UpdateAdminRole(AdminRoleUpdateVo adminRoleUpdateVo) {
                throwable.printStackTrace();
                AppResponse response = new AppResponse();
                response.setMsg("远程服务[更新管理员角色]调用失败");
                return response;
            }

            @Override
            public AppResponse<String> deleteAdminRole(String id) {
                throwable.printStackTrace();
                AppResponse response = new AppResponse();
                response.setMsg("远程服务[删除管理员角色]调用失败");
                return response;
            }

            @Override
            public AppResponse<String> deleteAdminRoles(String ids) {
                throwable.printStackTrace();
                AppResponse response = new AppResponse();
                response.setMsg("远程服务[批量删除管理员角色]调用失败");
                return response;
            }

            @Override
            public AppResponse<String> createAdminRole(AdminRoleRegisterVo adminRoleRegisterVo) {
                throwable.printStackTrace();
                AppResponse response = new AppResponse();
                response.setMsg("远程服务[创建管理员角色]调用失败");
                return response;
            }

            @Override
            public AppResponse<String> addAdminMenu(AdminMenuRegisterVo adminMenuRegisterVo) {
                throwable.printStackTrace();
                AppResponse response = new AppResponse();
                response.setMsg("远程服务[创建管理员菜单]调用失败");
                return response;
            }

            @Override
            public AppResponse<AdminMenuVo> getAdminMenu(String id) {
                throwable.printStackTrace();
                AppResponse response = new AppResponse();
                response.setMsg("远程服务[获取管理员菜单]调用失败");
                return response;
            }

            @Override
            public AppResponse<String> updateAdminMenu(AdminMenuUpdateVo adminMenuUpdateVo) {
                throwable.printStackTrace();
                AppResponse response = new AppResponse();
                response.setMsg("远程服务[更新管理员菜单]调用失败");
                return response;
            }

            @Override
            public AppResponse<String> deleteAdminMenu(String id) {
                throwable.printStackTrace();
                AppResponse response = new AppResponse();
                response.setMsg("远程服务[删除管理员菜单]调用失败");
                return response;
            }

            @Override
            public AppResponse<List<AdminPermissionVo>> getAllPermission() {
                throwable.printStackTrace();
                AppResponse response = new AppResponse();
                response.setMsg("远程服务[获取所有管理员权限]调用失败");
                return response;
            }

            @Override
            public AppResponse<AdminPermissionVo> getAdminPermission(String id) {
                throwable.printStackTrace();
                AppResponse response = new AppResponse();
                response.setMsg("远程服务[获取管理员权限]调用失败");
                return response;
            }

            @Override
            public AppResponse<String> addAdminPermission(AdminPermissionRegisterVo adminPermissionRegisterVo) {
                throwable.printStackTrace();
                AppResponse response = new AppResponse();
                response.setMsg("远程服务[添加管理员权限]调用失败");
                return response;
            }

            @Override
            public AppResponse<String> updateAdminPermission(AdminPermissionUpdateVo adminPermissionUpdateVo) {
                throwable.printStackTrace();
                AppResponse response = new AppResponse();
                response.setMsg("远程服务[更新管理员权限]调用失败");
                return response;
            }

            @Override
            public AppResponse<String> deleteAdminPermission(String id) {
                throwable.printStackTrace();
                AppResponse response = new AppResponse();
                response.setMsg("远程服务[删除管理员权限]调用失败");
                return response;
            }

            @Override
            public AppResponse<List<AdminRoleResponseVo>> getAssignedRole(String adminid) {
                throwable.printStackTrace();
                AppResponse response = new AppResponse();
                response.setMsg("远程服务[获取特定管理员赋予的角色列表]调用失败");
                return response;
            }

            @Override
            public AppResponse<List<AdminRoleResponseVo>> getUnAssignedRole(String adminid) {
                throwable.printStackTrace();
                AppResponse response = new AppResponse();
                response.setMsg("远程服务[获取特定管理员可以被赋予的角色列表]调用失败");
                return response;
            }

            @Override
            public AppResponse<String> assignAdminRoles(String adminId, String roleIds) {
                throwable.printStackTrace();
                AppResponse response = new AppResponse();
                response.setMsg("远程服务[赋予管理员角色]调用失败");
                return response;
            }

            @Override
            public AppResponse<String> assignRolePermissions(String roleId, String menuIds) {
                throwable.printStackTrace();
                AppResponse response = new AppResponse();
                response.setMsg("远程服务[赋予角色权限]调用失败");
                return response;
            }

            @Override
            public AppResponse<List<AdminPermissionVo>> getAdminPermissionByRoleId(String roleId) {
                throwable.printStackTrace();
                AppResponse response = new AppResponse();
                response.setMsg("远程服务[获取特定角色权限]调用失败");
                return response;
            }
        };
    }
}
