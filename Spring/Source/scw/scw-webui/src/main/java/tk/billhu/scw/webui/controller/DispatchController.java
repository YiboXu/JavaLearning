package tk.billhu.scw.webui.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import tk.billhu.scw.vo.resp.AppResponse;
import tk.billhu.scw.webui.entities.TUser;
import tk.billhu.scw.webui.service.TMemberServiceFeign;
import tk.billhu.scw.webui.service.TProjectServiceFeign;
import tk.billhu.scw.webui.vo.response.AdminMenuVo;
import tk.billhu.scw.webui.vo.response.ProjectGeneralInfoVo;
import tk.billhu.scw.webui.vo.response.UserResponseVo;

import javax.servlet.http.HttpSession;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

@Controller
@Slf4j
public class DispatchController {

    @Autowired
    private TMemberServiceFeign tMemberServiceFeign;

    @Autowired
    private TProjectServiceFeign tProjectServiceFeign;

    @Autowired
    private RedisTemplate redisTemplate;

    @GetMapping("/login")
    public String index(){
        return "login";
    }

    @PostMapping("/doLogin")
    public String doLogin(@RequestParam("loginacct") String loginacct, @RequestParam("userpswd") String userpswd, HttpSession session, Model model){
        AppResponse<UserResponseVo> appResponse = tMemberServiceFeign.login(loginacct,userpswd);
        UserResponseVo userResponseVo = appResponse.getData();

        if(userResponseVo != null) {
            session.setAttribute("loginmember", userResponseVo);
        }
        else{
            log.error(appResponse.getMsg());
            model.addAttribute("error",appResponse.getMsg());
            return "login";
        }

        return "redirect:index";
    }

    @RequestMapping("/doLogout")
    public String doLogout(HttpSession session){
        session.removeAttribute("loginmember");
        session.invalidate();
        return "redirect:/index";
    }

    @RequestMapping(value={"/","/index"})
    public String index(Model model){
        //获取项目信息
        List<ProjectGeneralInfoVo> data = (List<ProjectGeneralInfoVo>) redisTemplate.opsForValue().get("projectList");

        //if(data == null) {
            AppResponse<List<ProjectGeneralInfoVo>> appResponse = tProjectServiceFeign.all();
            if(appResponse.getCode() == 0){
                data = appResponse.getData();
                redisTemplate.opsForValue().set("projectList", data, 1, TimeUnit.HOURS);
            }else{
                log.error(appResponse.getMsg());
                model.addAttribute("error",appResponse.getMsg());
            }
        //}

        List<ProjectGeneralInfoVo> projectTop3 = data.stream().sorted((x,y) -> x.getFollower() >= y.getFollower()?1:0).limit(30).collect(Collectors.toList());

        model.addAttribute("projectTop3",projectTop3);

        return "index";
    }

    @RequestMapping("/loginSuccess")
    public String loginSuccess(HttpSession session, Model model){
        TUser principal = (TUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        UserResponseVo userResponseVo = new UserResponseVo();
        BeanUtils.copyProperties(principal.getUserLoginVo(),userResponseVo);

        session.setAttribute("loginmember", userResponseVo);

        //系统管理员入口
        if("9".equals(userResponseVo.getUsertype())) {
            return "redirect:admin/index";
        }

        //用户入口
        return "redirect:index";
    }

    @GetMapping("/admin/index")
    public String index(HttpSession session, Model model){
        if(session.getAttribute("menuList") == null) {
            AppResponse<List<AdminMenuVo>> appResponse = tMemberServiceFeign.getAllMenu();

            if (appResponse != null && appResponse.getCode() == 0) {
                session.setAttribute("menuList", appResponse.getData());
            } else {
                log.error(appResponse.getMsg());
                model.addAttribute("error", appResponse.getMsg());
                return "/error500";
            }
        }

        return "admin/index";
    }

    @PreAuthorize("hasRole('ADMIN')")
    @RequestMapping("/special1/test1")
    @ResponseBody
    public String test1(){
        return "special1-test1";
    }

    @PreAuthorize("hasAuthority('普通用户')")
    @RequestMapping("/special2/test2")
    @ResponseBody
    public String test2(){
        return "special2-test2";
    }

    @RequestMapping("/accessDeny")
    public String accessDeny(){
        return "accessDeny";
    }
}
