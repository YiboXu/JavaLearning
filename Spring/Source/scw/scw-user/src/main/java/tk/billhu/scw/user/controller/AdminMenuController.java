package tk.billhu.scw.user.controller;

import com.netflix.discovery.converters.Auto;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tk.billhu.scw.user.service.TAdminMenuService;
import tk.billhu.scw.user.service.TMemberService;
import tk.billhu.scw.user.vo.request.*;
import tk.billhu.scw.user.vo.response.AdminMenuVo;
import tk.billhu.scw.user.vo.response.AdminResponseVo;
import tk.billhu.scw.user.vo.response.AdminRoleResponseVo;
import tk.billhu.scw.user.vo.response.UserDetailVo;
import tk.billhu.scw.vo.resp.AppResponse;

import java.util.ArrayList;
import java.util.List;

@RestController
@Slf4j
@RequestMapping("/admin/menu")
@ApiModel
public class AdminMenuController {

    @Autowired
    private TAdminMenuService tAdminMenuService;

    @ApiOperation(value="获取管理员菜单信息")
    @GetMapping("/all")
    public AppResponse<List<AdminMenuVo>> getAllMenu(){
        List<AdminMenuVo> adminMenuVoList = new ArrayList<>();
        try {
            adminMenuVoList = tAdminMenuService.getAdminMenuList();
            return AppResponse.ok(adminMenuVoList);
        }catch (Exception e){
            e.printStackTrace();
            log.error("获取管理员菜单信息异常");
            AppResponse response = AppResponse.fail(null);
            response.setMsg("获取管理员菜单信息异常");
            return response;
        }
    }

    @ApiOperation(value="创建管理员菜单")
    @PostMapping("/createAdminMenu")
    public AppResponse<String> createAdminMenu(@RequestBody AdminMenuRegisterVo adminMenuRegisterVo){

        String result;

        try{
            result = tAdminMenuService.create(adminMenuRegisterVo);
        }catch (Exception e){
            log.error("管理员菜单创建失败-{}", adminMenuRegisterVo);
            return AppResponse.fail("管理员菜单创建失败");
        }

        return AppResponse.ok(result);
    }

    @ApiOperation(value="获取管理员菜单")
    @GetMapping("/getAdminMenu")
    AppResponse<AdminMenuVo> getAdminRole(@RequestParam("id") String id){
        AdminMenuVo adminMenuVo;
        try{
            adminMenuVo = tAdminMenuService.getAdminMenu(id);
        }catch (Exception e){
            log.error("获取管理员菜单失败-{}", id);
            AppResponse response = AppResponse.fail(null);
            response.setMsg("获取管理员菜单失败");
            return response;
        }

        return AppResponse.ok(adminMenuVo);
    }

    @ApiOperation(value="修改管理员角色信息")
    @PostMapping("/updateAdminMenu")
    AppResponse<String> updateAdminRole(@RequestBody AdminMenuUpdateVo adminMenuUpdateVo){
        String result;
        try{
            result = tAdminMenuService.UpdateAdminMenu(adminMenuUpdateVo);
        }catch (Exception e){
            //如果注册失败,返回错误
            log.error("更新管理员菜单失败-{}", adminMenuUpdateVo);
            AppResponse response = AppResponse.fail(null);
            response.setMsg("更新管理员菜单失败");
            return response;
        }

        return AppResponse.ok(result);
    }

    @ApiOperation(value="删除管理员菜单")
    @PostMapping("/deleteAdminMenu")
    AppResponse<String> deleteAdminMenu(@RequestParam("id") String id){
        String result;

        try{
            result = tAdminMenuService.deleteAdminMenu(id);
        }catch (Exception e){
            //如果注册失败,返回错误
            log.error("删除管理员菜单失败-{}", id);
            AppResponse response = AppResponse.fail(null);
            response.setMsg("删除管理员菜单失败");
            return response;
        }

        return AppResponse.ok(result);
    }
}
