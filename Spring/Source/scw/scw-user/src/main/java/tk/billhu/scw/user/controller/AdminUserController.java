package tk.billhu.scw.user.controller;

import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import tk.billhu.scw.user.service.TAdminService;
import tk.billhu.scw.user.vo.request.AdminRegisterVo;
import tk.billhu.scw.user.vo.request.AdminUpdateVo;
import tk.billhu.scw.user.vo.request.UserRegisterVo;
import tk.billhu.scw.user.vo.response.AdminResponseVo;
import tk.billhu.scw.user.vo.response.UserResponseVo;
import tk.billhu.scw.vo.resp.AppResponse;


@Slf4j
@Api(tags = "管理员模块")
@RequestMapping("/admin/user")
@RestController
public class AdminUserController {

    @Autowired
    TAdminService tAdminService;

    @ApiOperation(value="获取所有用户列表")
    @GetMapping("/allAdminUser")
    AppResponse<Object> getAllUser(@RequestParam(value="pageNum",required = false, defaultValue = "1") int pageNum,
                                   @RequestParam(value="pageSize",required = false, defaultValue = "10") int pageSize,
                                   @RequestParam(value = "condition",required = false, defaultValue = "") String condition){

        PageInfo<AdminResponseVo> pageInfo;

        try{
            pageInfo = tAdminService.getAllUser(pageNum,pageSize,condition);
        }catch (Exception e){
            e.printStackTrace();
            log.error("获取所有管理员列表异常");
            AppResponse response = AppResponse.fail(null);
            response.setMsg("获取所有管理员列表异常");
            return response;
        }

        return AppResponse.ok(pageInfo);
    }

    @ApiOperation(value="创建管理员")
    @PostMapping("/createAdminUser")
    public AppResponse<String> createAdmin(@RequestBody AdminRegisterVo adminRegisterVo){

        try{
            tAdminService.register(adminRegisterVo);
        }catch (Exception e){
            //如果注册失败,返回错误
            log.error("注册失败，请重新注册-{}", adminRegisterVo);
            return AppResponse.fail("注册失败，请重新注册");
        }

        return AppResponse.ok("管理员创建成功");
    }

    @ApiOperation(value="获取管理员信息")
    @GetMapping("/getAdminUser")
    AppResponse<AdminResponseVo> getAdminUser(@RequestParam("id") String id){
        AdminResponseVo adminResponseVo;
        try{
            adminResponseVo = tAdminService.getAdminUser(id);
        }catch (Exception e){
            //如果注册失败,返回错误
            log.error("获取管理员信息失败-{}", id);
            AppResponse response = AppResponse.fail(null);
            response.setMsg("获取管理员信息失败");
            return response;
        }

        return AppResponse.ok(adminResponseVo);
    }

    @ApiOperation(value="修改管理员信息")
    @PostMapping("/editAdminUser")
    AppResponse<AdminResponseVo> updateAdminUser(@RequestBody AdminUpdateVo adminUpdateVo){
        AdminResponseVo adminResponseVo;
        try{
            adminResponseVo = tAdminService.UpdateAdminUser(adminUpdateVo);
        }catch (Exception e){
            //如果注册失败,返回错误
            log.error("更新管理员信息失败-{}", adminUpdateVo);
            AppResponse response = AppResponse.fail(null);
            response.setMsg("更新管理员信息失败");
            return response;
        }

        return AppResponse.ok(adminResponseVo);
    }

    @ApiOperation(value="删除管理员信息")
    @PostMapping("/deleteAdminUser")
    AppResponse<Object> deleteAdminUser(@RequestParam("id") String id){
        int result;

        try{
            result = tAdminService.deleteAdminUser(id);
        }catch (Exception e){
            //如果注册失败,返回错误
            log.error("删除管理员信息失败-{}", id);
            AppResponse response = AppResponse.fail(null);
            response.setMsg("删除管理员信息失败");
            return response;
        }

        return AppResponse.ok(result);
    }

    @ApiOperation(value="批量删除管理员")
    @PostMapping("/deleteAdminUsers")
    AppResponse<Object> deleteAdminUsers(@RequestParam("ids") String ids){
        int result;

        try{
            result = tAdminService.deleteAdminUsers(ids);
        }catch (Exception e){
            //如果注册失败,返回错误
            log.error("批量删除管理员信息失败-{}", ids);
            AppResponse response = AppResponse.fail(null);
            response.setMsg("批量删除管理员信息失败");
            return response;
        }

        return AppResponse.ok(result);
    }
}
