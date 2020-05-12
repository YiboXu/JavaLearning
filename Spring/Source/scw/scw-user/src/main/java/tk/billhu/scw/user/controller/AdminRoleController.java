package tk.billhu.scw.user.controller;

import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tk.billhu.scw.user.service.TAdminRoleService;
import tk.billhu.scw.user.vo.request.AdminRoleRegisterVo;
import tk.billhu.scw.user.vo.request.AdminRoleUpdateVo;
import tk.billhu.scw.user.vo.response.AdminRoleResponseVo;
import tk.billhu.scw.vo.resp.AppResponse;

@Slf4j
@Api(tags = "管理员角色模块")
@RequestMapping("/admin/role")
@RestController
public class AdminRoleController {

    @Autowired
    private TAdminRoleService tAdminRoleService;

    @ApiOperation(value="获取所有管理员角色列表")
    @GetMapping("/getAllRole")
    public AppResponse<Object> getAllRole(@RequestParam(value="pageNum",required = false, defaultValue = "1") int pageNum,
                                          @RequestParam(value="pageSize",required = false, defaultValue = "10") int pageSize,
                                          @RequestParam(value = "condition",required = false, defaultValue = "") String condition){
        PageInfo<AdminRoleResponseVo> pageInfo;

        try{
            pageInfo = tAdminRoleService.getAllAdminRole(pageNum, pageSize, condition);
        }catch (Exception e){
            e.printStackTrace();
            log.error("获取所有管理员角色列表异常");
            AppResponse response = AppResponse.fail(null);
            response.setMsg("获取所有管理员角色列表异常");
            return response;
        }

        return AppResponse.ok(pageInfo);
    }

    @ApiOperation(value="创建管理员角色")
    @PostMapping("/createAdminRole")
    public AppResponse<String> createAdminRole(@RequestBody AdminRoleRegisterVo adminRoleRegisterVo){

        String result;

        try{
            result = tAdminRoleService.create(adminRoleRegisterVo);
        }catch (Exception e){
            log.error("管理员角色创建失败-{}", adminRoleRegisterVo);
            return AppResponse.fail("管理员角色创建失败");
        }

        return AppResponse.ok(result);
    }

    @ApiOperation(value="获取管理员角色信息")
    @GetMapping("/getAdminRole")
    AppResponse<AdminRoleResponseVo> getAdminRole(@RequestParam("id") String id){
        AdminRoleResponseVo adminRoleResponseVo;
        try{
            adminRoleResponseVo = tAdminRoleService.getAdminRole(id);
        }catch (Exception e){
            log.error("获取管理员角色信息失败-{}", id);
            AppResponse response = AppResponse.fail(null);
            response.setMsg("获取管理员角色信息失败");
            return response;
        }

        return AppResponse.ok(adminRoleResponseVo);
    }

    @ApiOperation(value="修改管理员角色信息")
    @PostMapping("/editAdminRole")
    AppResponse<String> updateAdminRole(@RequestBody AdminRoleUpdateVo adminRoleUpdateVo){
        String result;
        try{
            result = tAdminRoleService.UpdateAdminRole(adminRoleUpdateVo);
        }catch (Exception e){
            //如果注册失败,返回错误
            log.error("更新管理员角色信息失败-{}", adminRoleUpdateVo);
            AppResponse response = AppResponse.fail(null);
            response.setMsg("更新管理员信息失败");
            return response;
        }

        return AppResponse.ok(result);
    }

    @ApiOperation(value="删除管理员角色信息")
    @PostMapping("/deleteAdminRole")
    AppResponse<String> deleteAdminRole(@RequestParam("id") String id){
        String result;

        try{
            result = tAdminRoleService.deleteAdminRole(id);
        }catch (Exception e){
            //如果注册失败,返回错误
            log.error("删除管理员角色信息失败-{}", id);
            AppResponse response = AppResponse.fail(null);
            response.setMsg("删除管理员角色信息失败");
            return response;
        }

        return AppResponse.ok(result);
    }

    @ApiOperation(value="批量删除管理员角色")
    @PostMapping("/deleteAdminRoles")
    AppResponse<String> deleteAdminRoles(@RequestParam("ids") String ids){
        String result;

        try{
            result = tAdminRoleService.deleteAdminRoles(ids);
        }catch (Exception e){
            //如果注册失败,返回错误
            log.error("批量删除管理员角色信息失败-{}", ids);
            AppResponse response = AppResponse.fail(null);
            response.setMsg("批量删除管理员角色信息失败");
            return response;
        }

        return AppResponse.ok(result);
    }
}
