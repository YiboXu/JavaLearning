package tk.billhu.scw.order.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import tk.billhu.scw.order.exp.handler.TProjectServiceFallbackFactory;
import tk.billhu.scw.order.vo.response.*;
import tk.billhu.scw.vo.resp.AppResponse;

import java.util.List;

//一旦需要调用的微服务不可用，就调用类DeptClientServiceFallbackFactory所返回的服务(服务降级)
@FeignClient(value = "SCW-PROJECT", fallbackFactory = TProjectServiceFallbackFactory.class)
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
}
