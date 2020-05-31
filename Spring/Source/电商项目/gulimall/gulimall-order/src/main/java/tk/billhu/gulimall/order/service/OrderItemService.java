package tk.billhu.gulimall.order.service;

import com.baomidou.mybatisplus.extension.service.IService;
import tk.billhu.gulimall.common.utils.PageUtils;
import tk.billhu.gulimall.order.entity.OrderItemEntity;

import java.util.Map;

/**
 * 订单项信息
 *
 * @author billhu
 * @email billtt@163.com
 * @date 2020-05-19 17:31:31
 */
public interface OrderItemService extends IService<OrderItemEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

