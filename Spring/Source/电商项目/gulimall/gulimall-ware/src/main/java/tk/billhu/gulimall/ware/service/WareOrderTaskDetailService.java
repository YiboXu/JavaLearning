package tk.billhu.gulimall.ware.service;

import com.baomidou.mybatisplus.extension.service.IService;
import tk.billhu.gulimall.common.utils.PageUtils;
import tk.billhu.gulimall.ware.entity.WareOrderTaskDetailEntity;

import java.util.Map;

/**
 * 库存工作单
 *
 * @author billhu
 * @email billtt@163.com
 * @date 2020-05-19 17:14:45
 */
public interface WareOrderTaskDetailService extends IService<WareOrderTaskDetailEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

