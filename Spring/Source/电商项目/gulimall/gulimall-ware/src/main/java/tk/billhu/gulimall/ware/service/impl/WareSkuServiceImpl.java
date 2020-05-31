package tk.billhu.gulimall.ware.service.impl;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import tk.billhu.gulimall.common.utils.PageUtils;
import tk.billhu.gulimall.common.utils.Query;

import tk.billhu.gulimall.ware.dao.WareSkuDao;
import tk.billhu.gulimall.ware.entity.WareSkuEntity;
import tk.billhu.gulimall.ware.service.WareSkuService;


@Service("wareSkuService")
public class WareSkuServiceImpl extends ServiceImpl<WareSkuDao, WareSkuEntity> implements WareSkuService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        //获取查询参数
        Long wareId = StringUtils.isEmpty((String) params.get("wareId")) ? 0L : Long.parseLong((String) params.get("wareId"));
        Long skuId = StringUtils.isEmpty((String) params.get("skuId")) ? 0L : Long.parseLong((String) params.get("skuId"));

        QueryWrapper<WareSkuEntity> queryWrapper = new QueryWrapper<>();

        if(wareId != 0L){
            queryWrapper.eq("ware_id",wareId);
        }

        if(skuId != 0L){
            queryWrapper.eq("sku_id",skuId);
        }

        IPage<WareSkuEntity> page = this.page(
                new Query<WareSkuEntity>().getPage(params),
                queryWrapper
        );

        return new PageUtils(page);
    }

}