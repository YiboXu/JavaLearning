package tk.billhu.scw.order.service;

import tk.billhu.scw.order.entities.TOrder;
import tk.billhu.scw.order.vo.request.OrderCreateVo;

public interface TOrderService {
    TOrder save(OrderCreateVo orderCreateVo);
    void update();
}
