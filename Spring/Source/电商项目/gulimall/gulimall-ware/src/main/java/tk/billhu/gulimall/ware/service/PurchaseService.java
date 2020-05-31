package tk.billhu.gulimall.ware.service;

import com.baomidou.mybatisplus.extension.service.IService;
import tk.billhu.gulimall.common.utils.PageUtils;
import tk.billhu.gulimall.ware.entity.PurchaseEntity;
import tk.billhu.gulimall.ware.vo.MergeVo;

import java.util.Map;

/**
 * 采购信息
 *
 * @author billhu
 * @email billtt@163.com
 * @date 2020-05-19 17:14:45
 */
public interface PurchaseService extends IService<PurchaseEntity> {

    PageUtils queryPage(Map<String, Object> params);

    PageUtils listUnreceivePerchase(Map<String, Object> params);

    void merge(MergeVo mergeVo);
}

