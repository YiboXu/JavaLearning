package tk.billhu.scw.webui.controller;

import com.sun.deploy.association.utility.AppUtility;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import tk.billhu.scw.util.AppDateUtils;
import tk.billhu.scw.vo.resp.AppResponse;
import tk.billhu.scw.webui.service.TMemberServiceFeign;
import tk.billhu.scw.webui.vo.request.AdminRegisterVo;
import tk.billhu.scw.webui.vo.request.AdminUpdateVo;
import tk.billhu.scw.webui.vo.request.UserRegisterVo;
import tk.billhu.scw.webui.vo.response.AdminMenuVo;
import tk.billhu.scw.webui.vo.response.AdminResponseVo;
import tk.billhu.scw.webui.vo.response.AdminRoleResponseVo;
import tk.billhu.scw.webui.vo.response.UserResponseVo;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@Slf4j
@RequestMapping("/admin/user")
public class TAdminUserController {

    @Autowired
    private TMemberServiceFeign tMemberServiceFeign;

    @PreAuthorize("hasAuthority('user:get')")
    @GetMapping("/getAllUser")
    public String index(@RequestParam(value="pageNum",required = false, defaultValue = "1") int pageNum,
                        @RequestParam(value="pageSize",required = false, defaultValue = "5") int pageSize,
                        @RequestParam(value = "condition",required = false, defaultValue = "") String condition,Model model){

        AppResponse<Object> appResponse = tMemberServiceFeign.getAllUser(pageNum, pageSize, condition);

        if (appResponse != null && appResponse.getCode() == 0) {
            model.addAttribute("userList",appResponse.getData());
        } else {
            log.error(appResponse.getMsg());
            model.addAttribute("error", appResponse.getMsg());
            return "/error500";
        }

        return "admin/user/userList";
    }

    @PreAuthorize("hasAuthority('user:add')")
    @GetMapping("/addUser")
    public String addUser(){
        return "admin/user/addUser";
    }

    @PreAuthorize("hasAuthority('user:add')")
    @PostMapping("/doAddUser")
    public String doAddUser(AdminRegisterVo adminRegisterVo, Model model){

        //设置临时密码和创建日期
        adminRegisterVo.setUserpswd("111111");
        adminRegisterVo.setCreatetime(AppDateUtils.getFormatTime("yyyy-MM-dd HH:mm:ss"));

        AppResponse<String> appResponse = tMemberServiceFeign.createAdmin(adminRegisterVo);

        if(appResponse == null || appResponse.getCode() != 0){
            log.error(appResponse.getMsg());
            model.addAttribute("error",appResponse.getMsg());
            return "/error500";
        }

        return "redirect:/admin/user/getAllUser";
    }

    @PreAuthorize("hasAuthority('user:update')")
    @GetMapping("/edit")
    public String editUser(@RequestParam("id") String id, Model model){

        AppResponse<AdminResponseVo> appResponse = tMemberServiceFeign.getAdminUser(id);

        if (appResponse != null && appResponse.getCode() == 0) {
            model.addAttribute("adminUser", appResponse.getData());
        } else {
            log.error(appResponse.getMsg());
            model.addAttribute("error", appResponse.getMsg());
            return "/error500";
        }

        return "admin/user/edit";
    }

    @PreAuthorize("hasAuthority('user:update')")
    @PostMapping("/doEdit")
    public String editUser(AdminUpdateVo adminUpdateVo, String id, Model model){

        adminUpdateVo.setId(Integer.parseInt(id));

        AppResponse<AdminResponseVo> appResponse = tMemberServiceFeign.updateAdminUser(adminUpdateVo);

        if (appResponse != null && appResponse.getCode() == 0) {
            //nop
        } else {
            log.error(appResponse.getMsg());
            model.addAttribute("error", appResponse.getMsg());
            return "/error500";
        }

        return "redirect:/admin/user/getAllUser";
    }

    @PreAuthorize("hasAuthority('user:delete')")
    @RequestMapping("/delete")
    public String deleteUser(String id, Model model){

        AppResponse<Object> appResponse = tMemberServiceFeign.deleteAdminUser(id);

        if (appResponse != null && appResponse.getCode() == 0) {
            //nop
        } else {
            log.error(appResponse.getMsg());
            model.addAttribute("error", appResponse.getMsg());
            return "/error500";
        }

        return "redirect:/admin/user/getAllUser";
    }

    @PreAuthorize("hasAuthority('user:delete')")
    @RequestMapping("/deleteAdminUsers")
    public String deleteUsers(String ids, Model model){
        AppResponse<Object> appResponse = tMemberServiceFeign.deleteAdminUsers(ids);

        if (appResponse != null && appResponse.getCode() == 0) {
            //nop
        } else {
            log.error(appResponse.getMsg());
            model.addAttribute("error", appResponse.getMsg());
            return "/error500";
        }

        return "redirect:/admin/user/getAllUser";
    }

    @PreAuthorize("hasAuthority('user:assign:role')")
    @GetMapping("assignRole")
    public String assignRole(@RequestParam("id") String id, Model model){
        //获取已经赋予的角色
        AppResponse<List<AdminRoleResponseVo>> appResponse = tMemberServiceFeign.getAssignedRole(id);
        if(appResponse != null && appResponse.getCode() == 0){
            model.addAttribute("assignedRole",appResponse.getData());
        }else{
            log.error(appResponse.getMsg());
            model.addAttribute("error", appResponse.getMsg());
            return "/error500";
        }

        //获取能够赋予的角色
        appResponse = tMemberServiceFeign.getUnAssignedRole(id);
        if(appResponse != null && appResponse.getCode() == 0){
            model.addAttribute("unAssignedRole",appResponse.getData());
        }else{
            log.error(appResponse.getMsg());
            model.addAttribute("error", appResponse.getMsg());
            return "/error500";
        }

        return "admin/user/assignRole";
    }
}
