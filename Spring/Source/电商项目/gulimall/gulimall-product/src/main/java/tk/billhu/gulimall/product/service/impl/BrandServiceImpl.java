package tk.billhu.gulimall.product.service.impl;

import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.Collection;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import tk.billhu.gulimall.common.utils.PageUtils;
import tk.billhu.gulimall.common.utils.Query;

import tk.billhu.gulimall.product.dao.BrandDao;
import tk.billhu.gulimall.product.dao.CategoryBrandRelationDao;
import tk.billhu.gulimall.product.entity.BrandEntity;
import tk.billhu.gulimall.product.entity.CategoryBrandRelationEntity;
import tk.billhu.gulimall.product.service.BrandService;


@Service("brandService")
public class BrandServiceImpl extends ServiceImpl<BrandDao, BrandEntity> implements BrandService {

    @Autowired
    private CategoryBrandRelationDao categoryBrandRelationDao;

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        //获取查询参数
        String keyValue = (String) params.get("key");
        QueryWrapper<BrandEntity> queryWrapper = new QueryWrapper<BrandEntity>();
        if(!StringUtils.isEmpty(keyValue)){
            queryWrapper.eq("brand_id",keyValue).or().like("name",keyValue).like("descript",keyValue);
        }
        IPage<BrandEntity> page = this.page(
                new Query<BrandEntity>().getPage(params),
                queryWrapper
        );

        return new PageUtils(page);
    }

    @Override
    public void updateDetail(BrandEntity brand) {
        //更新pms_brand
        this.updateById(brand);

        //更新其他冗余数据表(也就是包含了brand name的其他表)
        String brandName = brand.getName();

        if(!StringUtils.isEmpty(brandName)){
            CategoryBrandRelationEntity categoryBrandRelationEntity = new CategoryBrandRelationEntity();
            categoryBrandRelationEntity.setBrandId(brand.getBrandId());
            categoryBrandRelationEntity.setBrandName(brandName);

            UpdateWrapper<CategoryBrandRelationEntity> updateWrapper = new UpdateWrapper();
            updateWrapper.eq("brand_id",brand.getBrandId());

            categoryBrandRelationDao.update(categoryBrandRelationEntity,updateWrapper);
        }
    }

    @Override
    public boolean removeByIds(Collection<? extends Serializable> idList) {
        boolean result1 = super.removeByIds(idList);

        //删除关联表记录
        //pms_category_brand_relation
        UpdateWrapper<CategoryBrandRelationEntity> updateWrapper = new UpdateWrapper<>();
        updateWrapper.in("brand_id",idList);
        categoryBrandRelationDao.delete(updateWrapper);

        return result1;
    }
}