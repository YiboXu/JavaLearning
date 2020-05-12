package tk.billhu.scw.webui.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import tk.billhu.scw.vo.resp.AppResponse;
import tk.billhu.scw.webui.entities.TOrder;
import tk.billhu.scw.webui.exp.handler.TOrderServiceFallbackFactory;
import tk.billhu.scw.webui.vo.request.OrderCreateVo;

//一旦需要调用的微服务不可用，就调用类DeptClientServiceFallbackFactory所返回的服务(服务降级)
@FeignClient(value = "SCW-ORDER", fallbackFactory = TOrderServiceFallbackFactory.class)
public interface TOrderServiceFeign {
    @PostMapping("/order/create")
    AppResponse<TOrder> create(@RequestBody OrderCreateVo orderCreateVo);
}
