package tk.billhu.scw.webui.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import tk.billhu.scw.vo.resp.AppResponse;
import tk.billhu.scw.webui.service.TMemberServiceFeign;
import tk.billhu.scw.webui.vo.request.AdminPermissionRegisterVo;
import tk.billhu.scw.webui.vo.request.AdminPermissionUpdateVo;
import tk.billhu.scw.webui.vo.response.AdminPermissionVo;

import java.util.List;

@Controller
@Slf4j
@RequestMapping("/admin/permission")
public class TAdminPermissionController {

    @Autowired
    private TMemberServiceFeign tMemberServiceFeign;

    @GetMapping("/getAllPermission")
    public String getAllPermission(Model model){

        return "admin/permission/permissionList";
    }

    @GetMapping("/loadAllPermission")
    @ResponseBody
    public Object loadAllPermission(){
        AppResponse<List<AdminPermissionVo>> appResponse = tMemberServiceFeign.getAllPermission();

        if (appResponse != null && appResponse.getCode() == 0) {
            List<AdminPermissionVo> permissions = appResponse.getData();
            //增加一个根节点
            AdminPermissionVo root = new AdminPermissionVo();
            root.setChildren(permissions);
            root.setId(0);
            root.setPid(0);
            root.setTitle("系统权限菜单");
            root.setIcon("fa fa-sitemap");
            root.setName("root");
            return root;
        } else {
            log.error(appResponse.getMsg());
            return null;
        }
    }

    @PostMapping("/addPermission")
    @ResponseBody
    public String addPermission(@RequestParam("pid") String pid,
                          @RequestParam("name") String name,
                          @RequestParam("icon") String icon,
                          @RequestParam("title") String title){

        AdminPermissionRegisterVo adminPermissionRegisterVo = new AdminPermissionRegisterVo(null,name,title,icon,Integer.parseInt(pid));

        AppResponse<String> appResponse = tMemberServiceFeign.addAdminPermission(adminPermissionRegisterVo);

        if (appResponse != null && appResponse.getCode() == 0) {
            return appResponse.getData();
        }else{
            log.error(appResponse.getMsg());
            return null;
        }
    }

    @GetMapping("/getPermission")
    @ResponseBody
    public AdminPermissionVo getPermission(@RequestParam("id") String id){
       AppResponse<AdminPermissionVo> appResponse = tMemberServiceFeign.getAdminPermission(id);

       if(appResponse != null && appResponse.getCode() == 0){
           AdminPermissionVo adminPermissionVo = appResponse.getData();
           return adminPermissionVo;
       }else{
           return null;
       }
    }

    @PostMapping("/updatePermission")
    @ResponseBody
    public String updatePermission(@RequestParam("id") String id,
                             @RequestParam("name") String name,
                             @RequestParam("icon") String icon,
                             @RequestParam("title") String title){
        AdminPermissionUpdateVo adminPermissionUpdateVo = new AdminPermissionUpdateVo();
        adminPermissionUpdateVo.setId(Integer.parseInt(id));
        adminPermissionUpdateVo.setName(name);
        adminPermissionUpdateVo.setIcon(icon);
        adminPermissionUpdateVo.setTitle(title);
        adminPermissionUpdateVo.setPid(null);

        AppResponse appResponse = tMemberServiceFeign.updateAdminPermission(adminPermissionUpdateVo);

        if(appResponse != null && appResponse.getCode() == 0){
            String result = (String) appResponse.getData();
            return result;
        }else{
            return "fail";
        }
    }

    @PostMapping("/deletePermission")
    @ResponseBody
    public String deletePermission(@RequestParam("id") String id){
        AppResponse appResponse = tMemberServiceFeign.deleteAdminPermission(id);

        if(appResponse != null && appResponse.getCode() == 0){
            String result = (String) appResponse.getData();
            return result;
        }else{
            return "fail";
        }
    }

    @PostMapping("/assignRolePermissions")
    @ResponseBody
    public String assignRolePermissions(@RequestParam("roleId") String roleId, @RequestParam("permissionIds") String permissionIds){
        AppResponse<String> appResponse = tMemberServiceFeign.assignRolePermissions(roleId,permissionIds);

        if(appResponse != null && appResponse.getCode() == 0){
            String result = appResponse.getData();
            return result;
        }else{
            return "fail";
        }
    }

    @GetMapping("/getPermissionByRoleId")
    @ResponseBody
    public List<AdminPermissionVo> getAdminPermissionByRoleId(@RequestParam("roleId") String roleId){
        AppResponse<List<AdminPermissionVo>> appResponse = tMemberServiceFeign.getAdminPermissionByRoleId(roleId);

        if(appResponse != null && appResponse.getCode() == 0){
            List<AdminPermissionVo> adminPermissionVoList = appResponse.getData();
            return adminPermissionVoList;
        }else{
            return null;
        }
    }
}
