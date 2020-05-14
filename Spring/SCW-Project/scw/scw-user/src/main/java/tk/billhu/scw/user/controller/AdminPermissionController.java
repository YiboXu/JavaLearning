package tk.billhu.scw.user.controller;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tk.billhu.scw.user.service.TAdminPermissionService;
import tk.billhu.scw.user.vo.request.AdminPermissionRegisterVo;
import tk.billhu.scw.user.vo.request.AdminPermissionUpdateVo;
import tk.billhu.scw.user.vo.response.AdminPermissionVo;
import tk.billhu.scw.vo.resp.AppResponse;

import java.util.ArrayList;
import java.util.List;

@RestController
@Slf4j
@RequestMapping("/admin/permission")
@ApiModel
public class AdminPermissionController {

    @Autowired
    private TAdminPermissionService tAdminPermissionService;

    @ApiOperation(value="获取管理员权限信息")
    @GetMapping("/all")
    public AppResponse<List<AdminPermissionVo>> getAllPermission(){
        List<AdminPermissionVo> adminPermissionVoList = new ArrayList<>();
        try {
            adminPermissionVoList = tAdminPermissionService.getAdminPermissionList();
            return AppResponse.ok(adminPermissionVoList);
        }catch (Exception e){
            e.printStackTrace();
            log.error("获取管理员权限信息异常");
            AppResponse response = AppResponse.fail(null);
            response.setMsg("获取管理员权限信息异常");
            return response;
        }
    }

    @ApiOperation(value="创建管理员权限")
    @PostMapping("/createAdminPermission")
    public AppResponse<String> createAdminPermission(@RequestBody AdminPermissionRegisterVo adminPermissionRegisterVo){

        String result;

        try{
            result = tAdminPermissionService.create(adminPermissionRegisterVo);
        }catch (Exception e){
            log.error("管理员权限创建失败-{}", adminPermissionRegisterVo);
            return AppResponse.fail("管理员权限创建失败");
        }

        return AppResponse.ok(result);
    }

    @ApiOperation(value="获取管理员权限")
    @GetMapping("/getAdminPermission")
    AppResponse<AdminPermissionVo> getAdminRole(@RequestParam("id") String id){
        AdminPermissionVo adminPermissionVo;
        try{
            adminPermissionVo = tAdminPermissionService.getAdminPermission(id);
        }catch (Exception e){
            log.error("获取管理员权限失败-{}", id);
            AppResponse response = AppResponse.fail(null);
            response.setMsg("获取管理员权限失败");
            return response;
        }

        return AppResponse.ok(adminPermissionVo);
    }

    @ApiOperation(value="修改管理员权限信息")
    @PostMapping("/updateAdminPermission")
    AppResponse<String> updateAdminRole(@RequestBody AdminPermissionUpdateVo adminPermissionUpdateVo){
        String result;
        try{
            result = tAdminPermissionService.UpdateAdminPermission(adminPermissionUpdateVo);
        }catch (Exception e){
            //如果注册失败,返回错误
            log.error("更新管理员权限失败-{}", adminPermissionUpdateVo);
            AppResponse response = AppResponse.fail(null);
            response.setMsg("更新管理员权限失败");
            return response;
        }

        return AppResponse.ok(result);
    }

    @ApiOperation(value="删除管理员权限")
    @PostMapping("/deleteAdminPermission")
    AppResponse<String> deleteAdminPermission(@RequestParam("id") String id){
        String result;

        try{
            result = tAdminPermissionService.deleteAdminPermission(id);
        }catch (Exception e){
            //如果注册失败,返回错误
            log.error("删除管理员权限失败-{}", id);
            AppResponse response = AppResponse.fail(null);
            response.setMsg("删除管理员权限失败");
            return response;
        }

        return AppResponse.ok(result);
    }

    @ApiOperation(value="赋予角色权限菜单")
    @PostMapping("/assignRolePermissions")
    AppResponse<String> assignRolePermissions(@RequestParam(value="roleId") String roleId, @RequestParam(value="permissionIds") String permissionIds){
        String result;

        try{
            result = tAdminPermissionService.assignRolePermissions(roleId, permissionIds);
        }catch (Exception e){
            //如果注册失败,返回错误
            log.error("赋予角色权限菜单失败-{}-{}", roleId,permissionIds);
            AppResponse response = AppResponse.fail(null);
            response.setMsg("赋予角色权限菜单失败");
            return response;
        }

        return AppResponse.ok(result);
    }

    @ApiOperation(value="获取特定角色权限")
    @GetMapping("/getPermissionByRoleId")
    AppResponse<List<AdminPermissionVo>> getAdminPermissionByRoleId(@RequestParam(value="roleId") String roleId){
        List<AdminPermissionVo> result;

        try{
            result = tAdminPermissionService.getPermissionByRoleId(roleId);
        }catch (Exception e){
            //如果注册失败,返回错误
            log.error("获取特定角色权限失败-{}", roleId);
            AppResponse response = AppResponse.fail(null);
            response.setMsg("获取特定角色权限失败");
            return response;
        }

        return AppResponse.ok(result);
    }
}
