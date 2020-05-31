package tk.billhu.gulimall.ware.service.impl;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import tk.billhu.gulimall.common.utils.PageUtils;
import tk.billhu.gulimall.common.utils.Query;

import tk.billhu.gulimall.ware.dao.PurchaseDetailDao;
import tk.billhu.gulimall.ware.entity.PurchaseDetailEntity;
import tk.billhu.gulimall.ware.entity.WareSkuEntity;
import tk.billhu.gulimall.ware.service.PurchaseDetailService;


@Service("purchaseDetailService")
public class PurchaseDetailServiceImpl extends ServiceImpl<PurchaseDetailDao, PurchaseDetailEntity> implements PurchaseDetailService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        //获取查询参数
        Long wareId = StringUtils.isEmpty((String) params.get("wareId")) ? 0L : Long.parseLong((String) params.get("wareId"));
        Long status = StringUtils.isEmpty((String) params.get("status")) ? -1L : Long.parseLong((String) params.get("status"));
        String keyValue = params.get("key") == null ? "" : (String) params.get("key");

        QueryWrapper<PurchaseDetailEntity> queryWrapper = new QueryWrapper<>();

        if(wareId != 0L){
            queryWrapper.eq("ware_id",wareId);
        }

        if(status != -1L){
            queryWrapper.eq("status",status);
        }

        if(!StringUtils.isEmpty(keyValue)){
            queryWrapper.and(obj -> {
                obj.eq("id",keyValue).or().eq("purchase_id",keyValue).or().eq("sku_id",keyValue);
            });
        }

        IPage<PurchaseDetailEntity> page = this.page(
                new Query<PurchaseDetailEntity>().getPage(params),
                queryWrapper
        );

        return new PageUtils(page);
    }

}