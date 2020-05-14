package tk.billhu.scw.webui.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import tk.billhu.scw.vo.resp.AppResponse;
import tk.billhu.scw.webui.config.ProjectFeignConfig;
import tk.billhu.scw.webui.exp.handler.TMemberServiceFallbackFactory;
import tk.billhu.scw.webui.exp.handler.TProjectServiceFallbackFactory;
import tk.billhu.scw.webui.vo.request.BaseVo;
import tk.billhu.scw.webui.vo.request.ProjectBaseInfoVo;
import tk.billhu.scw.webui.vo.request.ProjectLegalVo;
import tk.billhu.scw.webui.vo.request.ProjectReturnVo;
import tk.billhu.scw.webui.vo.response.*;

import java.util.List;

//一旦需要调用的微服务不可用，就调用类DeptClientServiceFallbackFactory所返回的服务(服务降级)
@FeignClient(value = "SCW-PROJECT", configuration=ProjectFeignConfig.class, fallbackFactory = TProjectServiceFallbackFactory.class)
public interface TProjectServiceFeign {
    @GetMapping("/project/all/index")
    AppResponse<List<ProjectGeneralInfoVo>> all();

    @GetMapping("/project/sys/type")
    AppResponse<List<ProjectTypeVo>> systype();

    @GetMapping("/project/sys/tags")
    AppResponse<List<ProjectTagVo>> systags();

    @GetMapping("/project/info/detail")
    AppResponse<ProjectDetailVo> detail(@RequestParam("projectId") String projectId);

    @GetMapping("/project/confirm/return/{projectId}/{returnId}")
    AppResponse<ReturnPayConfirmVo> support(@PathVariable("projectId") String projectId, @PathVariable("returnId") String returnId);

    @PostMapping("/project/create/init")
    AppResponse<Object> init(@RequestBody BaseVo baseVo);

    @PostMapping("/project/create/baseInfo")
    AppResponse<Object> baseInfo(@RequestBody ProjectBaseInfoVo projectBaseInfoVo);

    @PostMapping("/project/create/return")
    AppResponse<Object> returnDetail(@RequestBody List<ProjectReturnVo> projectReturnVos);

    @PostMapping("/project/create/confirm/legal")
    AppResponse<Object> legal(@RequestBody ProjectLegalVo projectLegalVo);

    @PostMapping("/project/create/submit")
    AppResponse<Object> submit(@RequestParam("accessToken") String accessToken, @RequestParam("projectToken") String projectToken, @RequestParam("operation") String operation);

    @PostMapping(value="/project/create/multiUpload", produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes=MediaType.MULTIPART_FORM_DATA_VALUE)
    AppResponse<List<String>> multiUpload(@RequestPart(name = "uploadFiles") MultipartFile[] uploadFiles);

    @PostMapping(value="/project/create/upload",produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes=MediaType.MULTIPART_FORM_DATA_VALUE)
    AppResponse<String> upload(@RequestPart(name = "uploadFile") MultipartFile uploadFile);
}
