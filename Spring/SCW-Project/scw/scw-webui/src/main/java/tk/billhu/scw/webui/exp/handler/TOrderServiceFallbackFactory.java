package tk.billhu.scw.webui.exp.handler;

import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;
import tk.billhu.scw.vo.resp.AppResponse;
import tk.billhu.scw.webui.entities.TOrder;
import tk.billhu.scw.webui.service.TOrderServiceFeign;
import tk.billhu.scw.webui.vo.request.OrderCreateVo;

@Component
public class TOrderServiceFallbackFactory implements FallbackFactory<TOrderServiceFeign> {
    @Override
    public TOrderServiceFeign create(Throwable throwable) {
        return new TOrderServiceFeign() {
            @Override
            public AppResponse<TOrder> create(OrderCreateVo orderCreateVo) {
                throwable.printStackTrace();
                AppResponse response = new AppResponse();
                response.setMsg("远程服务[创建订单]调用失败");
                return response;
            }
        };
    }
}
