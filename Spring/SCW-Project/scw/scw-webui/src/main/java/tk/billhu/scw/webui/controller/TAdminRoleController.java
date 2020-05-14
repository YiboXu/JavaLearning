package tk.billhu.scw.webui.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import tk.billhu.scw.vo.resp.AppResponse;
import tk.billhu.scw.webui.service.TMemberServiceFeign;
import tk.billhu.scw.webui.vo.request.AdminRegisterVo;
import tk.billhu.scw.webui.vo.request.AdminRoleRegisterVo;
import tk.billhu.scw.webui.vo.request.AdminRoleUpdateVo;

import java.lang.annotation.Retention;
import java.util.concurrent.TimeUnit;

@Controller
@Slf4j
@RequestMapping("/admin/role")
public class TAdminRoleController {

    @Autowired
    private TMemberServiceFeign tMemberServiceFeign;

    @GetMapping("/getAllRole")
    public String getAllAdminRole(@RequestParam(value="pageNum",required = false, defaultValue = "1") int pageNum,
                                  @RequestParam(value="pageSize",required = false, defaultValue = "5") int pageSize, Model model){
        //AppResponse<Object> appResponse = tMemberServiceFeign.getAllRole(pageNum,pageSize);

        //if (appResponse != null && appResponse.getCode() == 0) {
        //    model.addAttribute("adminRoleList",appResponse.getData());
        //} else {
        //    log.error(appResponse.getMsg());
        //    model.addAttribute("error", appResponse.getMsg());
        //    return "/error500";
        //}

        return "admin/role/roleList";
    }

    @GetMapping("/loadAllRole")
    @ResponseBody  //启用消息转换器: HttpMessageConverters 如果返回结果为对象类型, 转换为Json, 如果返回结果为String, 直接返回String
    public Object loadAllAdminRole(@RequestParam(value="pageNum",required = false, defaultValue = "1") int pageNum,
                                   @RequestParam(value="pageSize",required = false, defaultValue = "5") int pageSize,
                                   @RequestParam(value="condition",required = false, defaultValue = "") String condition){

        AppResponse<Object> appResponse = tMemberServiceFeign.getAllRole(pageNum,pageSize,condition);

        if (appResponse != null && appResponse.getCode() == 0) {
            //try {
            //    TimeUnit.SECONDS.sleep(1);
            //} catch (InterruptedException e) {
            //    e.printStackTrace();
            //}
            return appResponse.getData();
        } else {
            log.error(appResponse.getMsg());
            return "null";
        }
    }

    @PostMapping("/createRole")
    @ResponseBody
    public Object createRole(@RequestParam("name") String name){
        AdminRoleRegisterVo adminRoleRegisterVo = new AdminRoleRegisterVo();
        adminRoleRegisterVo.setName(name);
        return tMemberServiceFeign.createAdminRole(adminRoleRegisterVo).getData();
    }

    @GetMapping("/getRole")
    @ResponseBody
    public Object getRole(@RequestParam("id") String id){
        return tMemberServiceFeign.getAdminRole(id).getData();
    }

    @PostMapping("/updateRole")
    @ResponseBody
    public String updateRole(@RequestParam("id") String id, @RequestParam("name") String name){
        AdminRoleUpdateVo adminRoleUpdateVo = new AdminRoleUpdateVo();
        adminRoleUpdateVo.setId(Integer.parseInt(id));
        adminRoleUpdateVo.setName(name);

        AppResponse response = tMemberServiceFeign.UpdateAdminRole(adminRoleUpdateVo);

        if(response != null && response.getCode() == 0){
            return (String) response.getData();
        }

        return "fail";
    }

    @PostMapping("/deleteRole")
    @ResponseBody
    public String deleteRole(@RequestParam("id") String id){

        AppResponse response = tMemberServiceFeign.deleteAdminRole(id);

        if(response != null && response.getCode() == 0){
            return (String) response.getData();
        }

        return "fail";
    }

    @PostMapping("/deleteRoles")
    @ResponseBody
    public String deleteRoles(@RequestParam("ids") String ids){

        AppResponse response = tMemberServiceFeign.deleteAdminRoles(ids);

        if(response != null && response.getCode() == 0){
            return (String) response.getData();
        }

        return "fail";
    }

    @PostMapping("/assignRoles")
    @ResponseBody
    public String assignRoles(@RequestParam("adminId") String adminId, @RequestParam("roleIds") String roleIds){

        AppResponse response = tMemberServiceFeign.assignAdminRoles(adminId,roleIds);

        if(response != null && response.getCode() == 0){
            return (String) response.getData();
        }

        return "fail";
    }
}
