package tk.billhu.scw.webui.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import tk.billhu.scw.vo.resp.AppResponse;
import tk.billhu.scw.webui.service.TMemberServiceFeign;
import tk.billhu.scw.webui.vo.request.UserRegisterVo;
import tk.billhu.scw.webui.vo.response.UserProjectVo;
import tk.billhu.scw.webui.vo.response.UserResponseVo;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/member")
@Slf4j
public class TMemberController {
    @Autowired
    private TMemberServiceFeign tMemberServiceFeign;

    @GetMapping("/index")
    public String index(){
        return "member/index";
    }

    @GetMapping("/minecrowdfunding")
    public String minecrowdfunding(HttpSession session, Model model){
        //获取用户信息
        UserResponseVo userResponseVo = (UserResponseVo) session.getAttribute("loginmember");

        //如果未登录, 跳转登录界面
        if(userResponseVo == null){
            return "/login";
        }

        //获取登录令牌
        String accessToken = userResponseVo.getAccessToken();

        //1. 获取我支持的项目
        AppResponse<List<UserProjectVo>> appResponse = tMemberServiceFeign.support(accessToken);

        if(appResponse != null && appResponse.getCode() == 0){
            model.addAttribute("supportProjects",appResponse.getData());
        }else{
            log.error(appResponse.getMsg());
            model.addAttribute("error",appResponse.getMsg());
            return "/error500";
        }

        //2. 获取我关注的项目
        appResponse = tMemberServiceFeign.star(accessToken);

        if(appResponse != null && appResponse.getCode() == 0){
            model.addAttribute("starProjects",appResponse.getData());
        }else{
            log.error(appResponse.getMsg());
            model.addAttribute("error",appResponse.getMsg());
            return "/error500";
        }

        //3. 获取我发起的项目
        appResponse = tMemberServiceFeign.create(accessToken);

        if(appResponse != null && appResponse.getCode() == 0){
            model.addAttribute("createProjects",appResponse.getData());
        }else{
            log.error(appResponse.getMsg());
            model.addAttribute("error",appResponse.getMsg());
            return "/error500";
        }

        return "member/minecrowdfunding";
    }

    @GetMapping("/register")
    public String reg(){
        return "member/reg";
    }

    @PostMapping("/doRegister")
    public String doRegister(UserRegisterVo userRegisterVo, Model model){
        AppResponse<String> appResponse = tMemberServiceFeign.register(userRegisterVo);

        if(appResponse == null || appResponse.getCode() != 0){
            log.error(appResponse.getMsg());
            model.addAttribute("error",appResponse.getMsg());
            return "/error500";
        }

        return "/login";
    }

    //ajax异步调用
    @PostMapping("/sendsms")
    public void sendsms(String loginacct, HttpServletResponse response) throws IOException {
        AppResponse<String> appResponse = tMemberServiceFeign.sendsms(loginacct);

        if(appResponse != null && appResponse.getCode() == 0){
             response.getWriter().print(appResponse.getData());
        }else{
            response.getWriter().print("验证码发送失败, 请重试");
        }
    }
}
