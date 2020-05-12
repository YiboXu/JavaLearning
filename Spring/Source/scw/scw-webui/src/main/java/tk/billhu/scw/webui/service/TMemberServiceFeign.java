package tk.billhu.scw.webui.service;

import feign.hystrix.FallbackFactory;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;
import tk.billhu.scw.vo.resp.AppResponse;
import tk.billhu.scw.webui.entities.TRole;
import tk.billhu.scw.webui.exp.handler.TMemberServiceFallbackFactory;
import tk.billhu.scw.webui.vo.request.*;
import tk.billhu.scw.webui.vo.response.*;

import java.util.List;

//一旦需要调用的微服务不可用，就调用类DeptClientServiceFallbackFactory所返回的服务(服务降级)
@FeignClient(value = "SCW-USER", fallbackFactory = TMemberServiceFallbackFactory.class)
public interface TMemberServiceFeign {
    @PostMapping("/user/login")
    AppResponse<UserResponseVo> login(@RequestParam("loginacct") String loginacct, @RequestParam("userpswd") String userpswd);

    @GetMapping("/user/info/getAddress")
    AppResponse<List<UserAddressVo>> getAddress(@RequestParam("accessToken") String accessToken);

    @GetMapping("/user/info/support/project")
    AppResponse<List<UserProjectVo>> support(@RequestParam("accessToken") String accessToken);

    @GetMapping("/user/info/star/project")
    AppResponse<List<UserProjectVo>> star(@RequestParam("accessToken") String accessToken);

    @GetMapping("/user/info/create/project")
    AppResponse<List<UserProjectVo>> create(@RequestParam("accessToken") String accessToken);

    @PostMapping("/user/getUserLogin")
    AppResponse<UserLoginVo> getUserLogin(@RequestParam("loginacct") String username);

    @PostMapping("/user/getAccessToken")
    AppResponse<UserResponseVo> getAccessToken(@RequestParam("loginacct") String loginacct);

    @PostMapping("/user/register")
    AppResponse<String> register(@RequestBody UserRegisterVo userRegisterVo);

    @PostMapping("/user/sendsms")
    AppResponse<String> sendsms(@RequestParam("loginacct") String loginacct);

    @PostMapping("/user/getAdminLogin")
    AppResponse<UserLoginVo> getAdminLogin(@RequestParam("loginacct") String loginacct);

    @PostMapping("/user/getAdminRoles")
    AppResponse<List<TRole>> getAdminRoles(@RequestParam("loginacct") String loginacct);

    @GetMapping("/admin/user/allAdminUser")
    AppResponse<Object> getAllUser(@RequestParam(value="pageNum",required = false, defaultValue = "1") int pageNum,
                                   @RequestParam(value="pageSize",required = false, defaultValue = "10") int pageSize,
                                   @RequestParam(value = "condition",required = false, defaultValue = "") String condition);

    @PostMapping("/admin/user/createAdminUser")
    AppResponse<String> createAdmin(@RequestBody AdminRegisterVo adminRegisterVo);

    @GetMapping("/admin/user/getAdminUser")
    AppResponse<AdminResponseVo> getAdminUser(@RequestParam("id") String id);

    @PostMapping("/admin/user/editAdminUser")
    AppResponse<AdminResponseVo> updateAdminUser(@RequestBody AdminUpdateVo adminUpdateVo);

    @PostMapping("/admin/user/deleteAdminUser")
    AppResponse<Object> deleteAdminUser(@RequestParam("id") String id);

    @PostMapping("/admin/user/deleteAdminUsers")
    AppResponse<Object> deleteAdminUsers(@RequestParam("ids") String ids);

    @GetMapping("/admin/role/getAllRole")
    AppResponse<Object> getAllRole(@RequestParam(value="pageNum",required = false, defaultValue = "1") int pageNum,
                                   @RequestParam(value="pageSize",required = false, defaultValue = "10") int pageSize,
                                   @RequestParam(value="condition",required = false, defaultValue = "") String condition);

    @GetMapping("/admin/role/getAdminRole")
    AppResponse<AdminRoleResponseVo> getAdminRole(@RequestParam("id") String id);

    @PostMapping("/admin/role/editAdminRole")
    AppResponse<String> UpdateAdminRole(@RequestBody AdminRoleUpdateVo adminRoleUpdateVo);

    @PostMapping("/admin/role/deleteAdminRole")
    AppResponse<String> deleteAdminRole(@RequestParam("id") String id);

    @PostMapping("/admin/role/deleteAdminRoles")
    AppResponse<String> deleteAdminRoles(@RequestParam("ids") String ids);

    @PostMapping("/admin/role/createAdminRole")
    AppResponse<String> createAdminRole(@RequestBody AdminRoleRegisterVo adminRoleRegisterVo);

    @GetMapping("/admin/menu/all")
    AppResponse<List<AdminMenuVo>> getAllMenu();

    @GetMapping("/admin/menu/getAdminMenu")
    AppResponse<AdminMenuVo> getAdminMenu(@RequestParam("id") String id);

    @PostMapping("/admin/menu/createAdminMenu")
    AppResponse<String> addAdminMenu(@RequestBody AdminMenuRegisterVo adminMenuRegisterVo);

    @PostMapping("/admin/menu/updateAdminMenu")
    AppResponse<String> updateAdminMenu(@RequestBody AdminMenuUpdateVo adminMenuUpdateVo);

    @PostMapping("/admin/menu/deleteAdminMenu")
    AppResponse<String> deleteAdminMenu(@RequestParam("id") String id);
}
