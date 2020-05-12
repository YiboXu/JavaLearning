package tk.billhu.scw.webui.controller;

import lombok.experimental.Accessors;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import tk.billhu.scw.vo.resp.AppResponse;
import tk.billhu.scw.webui.service.TMemberServiceFeign;
import tk.billhu.scw.webui.service.TProjectServiceFeign;
import tk.billhu.scw.webui.vo.request.BaseVo;
import tk.billhu.scw.webui.vo.request.ProjectBaseInfoVo;
import tk.billhu.scw.webui.vo.request.ProjectLegalVo;
import tk.billhu.scw.webui.vo.request.ProjectReturnVo;
import tk.billhu.scw.webui.vo.response.*;

import javax.servlet.http.HttpSession;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

@Controller
@RequestMapping("/project")
@Slf4j
public class TProjectController {

    @Autowired
    private TProjectServiceFeign tProjectServiceFeign;

    @Autowired
    private TMemberServiceFeign tMemberServiceFeign;

    @GetMapping("/start")
    public String start(HttpSession session){

        //获取用户信息
        UserResponseVo userResponseVo = (UserResponseVo) session.getAttribute("loginmember");

        //如果未登录, 跳转登录界面
        if(userResponseVo == null){
            return "/login";
        }

        return "project/start";
    }

    @GetMapping("/doStart")
    public String startPorject(HttpSession session, Model model){

        //获取用户信息
        UserResponseVo userResponseVo = (UserResponseVo) session.getAttribute("loginmember");

        //如果未登录, 跳转登录界面
        if(userResponseVo == null){
            return "/login";
        }

        //初始化项目
        BaseVo baseVo = new BaseVo();
        baseVo.setAccessToken(userResponseVo.getAccessToken());
        AppResponse<Object> appResponse = tProjectServiceFeign.init(baseVo);

        if(appResponse != null && appResponse.getCode() == 0){
            session.setAttribute("projectRedisStorageVo",appResponse.getData());
        }else{
            log.error(appResponse.getMsg());
            model.addAttribute("error",appResponse.getMsg());
            return "/error500";
        }

        return "project/start-step-1";
    }

    @PostMapping("/start-step-1")
    public String startStep1(@RequestParam("uploadFiles") CommonsMultipartFile[] imageFiles, ProjectBaseInfoVo projectBaseInfoVo, HttpSession session, Model model){

        //获取用户信息
        UserResponseVo userResponseVo = (UserResponseVo) session.getAttribute("loginmember");

        //如果未登录, 跳转登录界面
        if(userResponseVo == null){
            return "/login";
        }

        //获取登录令牌
        String accessToken = userResponseVo.getAccessToken();
        projectBaseInfoVo.setAccessToken(accessToken);

        HashMap<String,String> bigVo = (HashMap<String,String> ) session.getAttribute("projectRedisStorageVo");
        projectBaseInfoVo.setProjectToken(bigVo.get("projectToken"));

        //上传图片
        if(imageFiles.length > 0) {
            List<String> imgUrls = new ArrayList<>();
            //调用远程服务上传文件
            for(CommonsMultipartFile imageFile : imageFiles){
                CommonsMultipartFile[] file = new CommonsMultipartFile[1];
                file[0] = imageFile;
                AppResponse<List<String>> resp = tProjectServiceFeign.multiUpload(file);
                if (resp != null && resp.getCode() == 0) {
                    imgUrls.add(resp.getData().get(0));
                }else{
                    log.error(resp.getMsg());
                    model.addAttribute("error", resp.getMsg());
                    return "/error500";
                }
            }

            //设置头部图片 - 默认第一个上传文件为头部图片
            projectBaseInfoVo.setHeaderImage(imgUrls.get(0));

            //设置详细信息图片
            if(imgUrls.size() > 1) {
                List<String> detailImages = new ArrayList<>();
                detailImages.add(imgUrls.get(1));
                projectBaseInfoVo.setDetailsImage(detailImages);
            }else{
                projectBaseInfoVo.setDetailsImage(new ArrayList<>());
            }
        }else {
            projectBaseInfoVo.setHeaderImage("");
            projectBaseInfoVo.setDetailsImage(new ArrayList<>());
        }

        //用于测试，真实环境需要从页面获取tag
        projectBaseInfoVo.setTagIds(Arrays.asList(1, 2, 3, 4));

        AppResponse<Object> appResponse = tProjectServiceFeign.baseInfo(projectBaseInfoVo);

        if(appResponse != null && appResponse.getCode() == 0){
            session.setAttribute("projectRedisStorageVo",appResponse.getData());
        }else{
            log.error(appResponse.getMsg());
            model.addAttribute("error",appResponse.getMsg());
            return "/error500";
        }

        return "project/start-step-2";
    }

    @PostMapping("/start-step-2")
    public String startStep2(ProjectReturnVo projectReturnVo, HttpSession session, Model model){

        //获取用户信息
        UserResponseVo userResponseVo = (UserResponseVo) session.getAttribute("loginmember");

        //如果未登录, 跳转登录界面
        if(userResponseVo == null){
            return "/login";
        }

        //获取登录令牌
        String accessToken = userResponseVo.getAccessToken();
        HashMap<String,String> bigVo = (HashMap<String,String> ) session.getAttribute("projectRedisStorageVo");

        projectReturnVo.setAccessToken(accessToken);
        projectReturnVo.setProjectToken(bigVo.get("projectToken"));
        projectReturnVo.setPurchase(projectReturnVo.getCount());

        List<ProjectReturnVo> projectReturnVoList = new ArrayList<>();
        projectReturnVoList.add(projectReturnVo);

        AppResponse<Object> appResponse = tProjectServiceFeign.returnDetail(projectReturnVoList);

        if(appResponse != null && appResponse.getCode() == 0){
            session.setAttribute("projectRedisStorageVo",appResponse.getData());
        }else{
            log.error(appResponse.getMsg());
            model.addAttribute("error",appResponse.getMsg());
            return "/error500";
        }

        return "project/start-step-3";
    }

    @PostMapping("/submit")
    public String startStep3(ProjectLegalVo projectLegalVo, HttpSession session, Model model){

        //获取用户信息
        UserResponseVo userResponseVo = (UserResponseVo) session.getAttribute("loginmember");

        //如果未登录, 跳转登录界面
        if(userResponseVo == null){
            return "/login";
        }

        //获取登录令牌
        String accessToken = userResponseVo.getAccessToken();
        HashMap<String,String> bigVo = (HashMap<String,String> ) session.getAttribute("projectRedisStorageVo");
        String projectToken = bigVo.get("projectToken");

        projectLegalVo.setAccessToken(accessToken);
        projectLegalVo.setProjectToken(projectToken);

        AppResponse<Object> appResponse = tProjectServiceFeign.legal(projectLegalVo);

        if(appResponse != null && appResponse.getCode() == 0){
            bigVo = (HashMap<String, String>) appResponse.getData();
        }else{
            log.error(appResponse.getMsg());
            model.addAttribute("error",appResponse.getMsg());
            return "/error500";
        }

        //operation=0 存草稿
        //operation=1 提交
        appResponse = tProjectServiceFeign.submit(accessToken,projectToken,"1");

        if(appResponse != null && appResponse.getCode() == 0){
            bigVo = (HashMap<String, String>) appResponse.getData();
        }else{
            log.error(appResponse.getMsg());
            model.addAttribute("error",appResponse.getMsg());
            return "/error500";
        }

        return "project/start-step-4";
    }

    @GetMapping("/projectInfo")
    public String projectDetailInfo(@RequestParam("projectId") String projectId, Model model){
        AppResponse<ProjectDetailVo> appResponse = tProjectServiceFeign.detail(projectId);

        if(appResponse != null && appResponse.getCode() == 0){
            model.addAttribute("projectDetail",appResponse.getData());
        }else{
            log.error(appResponse.getMsg());
            model.addAttribute("error",appResponse.getMsg());
            return "index";
        }

         return "project/index";
    }

    @RequestMapping("/support/{projectId}/{returnId}")
    public String support(@PathVariable("projectId") String projectId, @PathVariable("returnId") String returnId, HttpSession session, Model model){

        //检查是否登录
        UserResponseVo userResponseVo = (UserResponseVo) session.getAttribute("loginmember");
        if(userResponseVo == null){
            return "/login";
        }

        AppResponse<ReturnPayConfirmVo> appResponse = tProjectServiceFeign.support(projectId,returnId);

        if(appResponse != null && appResponse.getCode() == 0){
            model.addAttribute("returnPayConfirmVo",appResponse.getData());
            session.setAttribute("returnPayConfirmVo",appResponse.getData());
        }else{
            log.error(appResponse.getMsg());
            model.addAttribute("error",appResponse.getMsg());
            return "project/index";
        }

        return "project/pay-step-1";
    }

    @RequestMapping("/confirm/order/{num}")
    public String confirmOrder(@PathVariable("num") Integer num, HttpSession session,Model model){
        //检查是否登录
        UserResponseVo userResponseVo = (UserResponseVo) session.getAttribute("loginmember");
        if(userResponseVo == null){
            return "redirect:/login";
        }

        ReturnPayConfirmVo returnPayConfirmVo = (ReturnPayConfirmVo) session.getAttribute("returnPayConfirmVo");
        returnPayConfirmVo.setNum(num);
        returnPayConfirmVo.setTotalPrice(BigDecimal.valueOf(num*returnPayConfirmVo.getPrice()+returnPayConfirmVo.getFreight()));
        session.setAttribute("returnPayConfirmVo",returnPayConfirmVo);

        AppResponse<List<UserAddressVo>> appResponse = tMemberServiceFeign.getAddress(userResponseVo.getAccessToken());

        if(appResponse != null && appResponse.getCode() == 0){
            model.addAttribute("addressList",appResponse.getData());
            model.addAttribute("returnPayConfirmVo",returnPayConfirmVo);
        }else{
            log.error(appResponse.getMsg());
            model.addAttribute("error",appResponse.getMsg());
            model.addAttribute("returnPayConfirmVo",returnPayConfirmVo);
            return "project/pay-step-1";
        }

        return "project/pay-step-2";
    }
}
