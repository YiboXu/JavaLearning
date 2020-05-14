package tk.billhu.scw.webui.controller;

import io.swagger.models.auth.In;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import tk.billhu.scw.vo.resp.AppResponse;
import tk.billhu.scw.webui.service.TMemberServiceFeign;
import tk.billhu.scw.webui.vo.request.AdminMenuRegisterVo;
import tk.billhu.scw.webui.vo.request.AdminMenuUpdateVo;
import tk.billhu.scw.webui.vo.response.AdminMenuVo;

import java.util.ArrayList;
import java.util.List;

@Controller
@Slf4j
@RequestMapping("/admin/menu")
public class TAdminMenuController {

    @Autowired
    private TMemberServiceFeign tMemberServiceFeign;

    @GetMapping("/getAllMenu")
    public String getAllMenu(Model model){

        return "admin/menu/menuList";
    }

    @GetMapping("/loadAllMenu")
    @ResponseBody
    public Object loadAllMenu(){
        AppResponse<List<AdminMenuVo>> appResponse = tMemberServiceFeign.getAllMenu();

        if (appResponse != null && appResponse.getCode() == 0) {
            List<AdminMenuVo> menus = appResponse.getData();
            //增加一个根节点
            AdminMenuVo root = new AdminMenuVo();
            root.setChildMenu(menus);
            root.setId(0);
            root.setPid(0);
            root.setName("系统权限菜单");
            root.setIcon("fa fa-sitemap");
            return root;
        } else {
            log.error(appResponse.getMsg());
            return null;
        }
    }

    @PostMapping("/addMenu")
    @ResponseBody
    public String addMenu(@RequestParam("pid") String pid,
                          @RequestParam("name") String name,
                          @RequestParam("icon") String icon,
                          @RequestParam("url") String url){

        AdminMenuRegisterVo adminMenuRegisterVo = new AdminMenuRegisterVo(null,Integer.parseInt(pid),name,icon,url);

        AppResponse<String> appResponse = tMemberServiceFeign.addAdminMenu(adminMenuRegisterVo);

        if (appResponse != null && appResponse.getCode() == 0) {
            return appResponse.getData();
        }else{
            log.error(appResponse.getMsg());
            return null;
        }
    }

    @GetMapping("/getMenu")
    @ResponseBody
    public AdminMenuVo getMenu(@RequestParam("id") String id){
       AppResponse<AdminMenuVo> appResponse = tMemberServiceFeign.getAdminMenu(id);

       if(appResponse != null && appResponse.getCode() == 0){
           AdminMenuVo adminMenuVo = appResponse.getData();
           return adminMenuVo;
       }else{
           return null;
       }
    }

    @PostMapping("/updateMenu")
    @ResponseBody
    public String updateMenu(@RequestParam("id") String id,
                             @RequestParam("name") String name,
                             @RequestParam("icon") String icon,
                             @RequestParam("url") String url){
        AdminMenuUpdateVo adminMenuUpdateVo = new AdminMenuUpdateVo();
        adminMenuUpdateVo.setId(Integer.parseInt(id));
        adminMenuUpdateVo.setName(name);
        adminMenuUpdateVo.setIcon(icon);
        adminMenuUpdateVo.setUrl(url);
        adminMenuUpdateVo.setPid(null);

        AppResponse appResponse = tMemberServiceFeign.updateAdminMenu(adminMenuUpdateVo);

        if(appResponse != null && appResponse.getCode() == 0){
            String result = (String) appResponse.getData();
            return result;
        }else{
            return "fail";
        }
    }

    @PostMapping("/deleteMenu")
    @ResponseBody
    public String deleteMenu(@RequestParam("id") String id){
        AppResponse appResponse = tMemberServiceFeign.deleteAdminMenu(id);

        if(appResponse != null && appResponse.getCode() == 0){
            String result = (String) appResponse.getData();
            return result;
        }else{
            return "fail";
        }
    }
}
