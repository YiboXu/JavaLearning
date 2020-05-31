package tk.billhu.gulimall.product.service.impl;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import tk.billhu.gulimall.common.utils.PageUtils;
import tk.billhu.gulimall.common.utils.Query;

import tk.billhu.gulimall.product.dao.SkuInfoDao;
import tk.billhu.gulimall.product.entity.SkuInfoEntity;
import tk.billhu.gulimall.product.service.SkuInfoService;


@Service("skuInfoService")
public class SkuInfoServiceImpl extends ServiceImpl<SkuInfoDao, SkuInfoEntity> implements SkuInfoService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        //获取查询参数
        Long catelogId = params.get("catelogId") == null ? 0L : Long.parseLong((String)params.get("catelogId"));
        Long brandId = params.get("brandId") == null ? 0L : Long.parseLong((String)params.get("brandId"));
        Integer status = params.get("status") == null || org.springframework.util.StringUtils.isEmpty((String) params.get("status"))? -1 : Integer.parseInt((String)params.get("status"));
        String keyValue = params.get("key") == null ? "" : (String) params.get("key");
        Long min = params.get("min") == null ? 0L : Long.parseLong((String)params.get("min"));
        Long max = params.get("max") == null ? 0L : Long.parseLong((String)params.get("max"));

        QueryWrapper<SkuInfoEntity> queryWrapper = new QueryWrapper<>();

        if(catelogId != 0L){
            queryWrapper.eq("catalog_id",catelogId);
        }
        if(brandId != 0L){
            queryWrapper.eq("brand_id",brandId);
        }
        if(min != 0L){
            queryWrapper.ge("price",min);
        }
        if(max != 0L){
            queryWrapper.le("price",max);
        }
        if(!StringUtils.isEmpty(keyValue)){
            queryWrapper.and(obj -> {
                obj.eq("sku_id",keyValue).or().like("sku_name",keyValue).or().like("sku_desc ",keyValue);
            });
        }

        IPage<SkuInfoEntity> page = this.page(
                new Query<SkuInfoEntity>().getPage(params),
                queryWrapper
        );

        return new PageUtils(page);
    }

}