package tk.billhu.scw.project.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import tk.billhu.scw.project.entities.TReturn;
import tk.billhu.scw.project.service.TProjectService;
import tk.billhu.scw.project.vo.response.*;
import tk.billhu.scw.vo.resp.AppResponse;

import java.util.ArrayList;
import java.util.List;

@RestController
@Slf4j
@Api(tags = "项目信息模块")
@RequestMapping("/project")
public class ProjectInfoController {

    @Autowired
    private TProjectService tProjectService;

    @ApiOperation(value="获取项目总览列表")
    @GetMapping("/all/index")
    public AppResponse<List<ProjectGeneralInfoVo>> all(){

        List<ProjectGeneralInfoVo> list;

        try{
            list = tProjectService.getProjectGeneralInfoList();
        }catch (Exception e){
            e.printStackTrace();
            log.debug("获取项目总览列表异常");
            AppResponse response = AppResponse.fail(null);
            response.setMsg("获取项目总览列表异常");

            return response;
        }
        return AppResponse.ok(list);
    }

    @ApiOperation(value="获取项目系统分类信息")
    @GetMapping("/sys/type")
    public AppResponse<List<ProjectTypeVo>> systype(){
        List<ProjectTypeVo> list;

        try{
            list = tProjectService.getProjectTypeList();
        }catch (Exception e){
            e.printStackTrace();
            log.debug("获取项目分类列表异常");
            AppResponse response = AppResponse.fail(null);
            response.setMsg("获取项目分类列表异常");

            return response;
        }
        return AppResponse.ok(list);
    }

    @ApiOperation(value="获取项目系统标签信息")
    @GetMapping("/sys/tags")
    public AppResponse<List<ProjectTagVo>> systags(){
        List<ProjectTagVo> list;

        try{
            list = tProjectService.getProjectTagList();
        }catch (Exception e){
            e.printStackTrace();
            log.debug("获取项目标签列表异常");
            AppResponse response = AppResponse.fail(null);
            response.setMsg("获取项目标签列表异常");

            return response;
        }
        return AppResponse.ok(list);
    }

    @ApiOperation(value="获取项目详情信息")
    @GetMapping("/info/detail")
    public AppResponse<ProjectDetailVo> detail(String projectId){

        ProjectDetailVo projectDetailVo;

        try{
            projectDetailVo = tProjectService.getProjectDetailInfo(projectId);
        }catch (Exception e){
            e.printStackTrace();
            log.debug("获取项目详细信息异常-{}", projectId);
            AppResponse response = AppResponse.fail(null);
            response.setMsg("获取项目详细信息异常");

            return response;
        }
        return AppResponse.ok(projectDetailVo);
    }

    @ApiOperation(value="确认项目回报信息")
    @GetMapping("/confirm/return/{projectId}/{returnId}")
    public AppResponse<ReturnPayConfirmVo> support(@PathVariable("projectId") String projectId, @PathVariable("returnId") String returnId){

        ReturnPayConfirmVo returnPayConfirmVo;

        try{
            returnPayConfirmVo = tProjectService.confirmReturnInfo(projectId, returnId);
        }catch (Exception e){
            e.printStackTrace();
            log.debug("确认项目回报信息异常-{}-{}", projectId, returnId);
            AppResponse response = AppResponse.fail(null);
            response.setMsg("确认项目回报信息异常");

            return response;
        }

        return AppResponse.ok(returnPayConfirmVo);
    }

    @ApiOperation(value="MyBatis分页测试")
    @GetMapping("/list")
    public AppResponse<PageInfo<ProjectGeneralInfoVo>> list(@RequestParam(value = "pageNum", required = false, defaultValue = "1") Integer pageNum,
                                                            @RequestParam(value = "pageSize", required = false, defaultValue = "10") Integer pageSize){
        PageHelper.startPage(pageNum,pageSize);
        List<ProjectGeneralInfoVo> list = tProjectService.getProjectGeneralInfoList();

        PageInfo pageInfo = new PageInfo(list);

        return AppResponse.ok(pageInfo);
    }
}
