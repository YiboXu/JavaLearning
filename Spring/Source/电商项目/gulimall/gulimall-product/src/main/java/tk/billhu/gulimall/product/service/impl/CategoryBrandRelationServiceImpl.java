package tk.billhu.gulimall.product.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import tk.billhu.gulimall.common.utils.PageUtils;
import tk.billhu.gulimall.common.utils.Query;

import tk.billhu.gulimall.product.dao.BrandDao;
import tk.billhu.gulimall.product.dao.CategoryBrandRelationDao;
import tk.billhu.gulimall.product.dao.CategoryDao;
import tk.billhu.gulimall.product.entity.BrandEntity;
import tk.billhu.gulimall.product.entity.CategoryBrandRelationEntity;
import tk.billhu.gulimall.product.entity.CategoryEntity;
import tk.billhu.gulimall.product.service.CategoryBrandRelationService;


@Service("categoryBrandRelationService")
public class CategoryBrandRelationServiceImpl extends ServiceImpl<CategoryBrandRelationDao, CategoryBrandRelationEntity> implements CategoryBrandRelationService {

    @Autowired
    private BrandDao brandDao;

    @Autowired
    private CategoryDao categoryDao;

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<CategoryBrandRelationEntity> page = this.page(
                new Query<CategoryBrandRelationEntity>().getPage(params),
                new QueryWrapper<CategoryBrandRelationEntity>()
        );

        return new PageUtils(page);
    }

    @Override
    public List<CategoryBrandRelationEntity> listWithBrandId(Long brandId) {
        QueryWrapper<CategoryBrandRelationEntity> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("brand_id",brandId);

        return this.baseMapper.selectList(queryWrapper);
    }

    @Override
    public void saveDetail(CategoryBrandRelationEntity categoryBrandRelation) {
        //获取brand name
        BrandEntity brandEntity = brandDao.selectById(categoryBrandRelation.getBrandId());
        categoryBrandRelation.setBrandName(brandEntity.getName());
        //获取catelog name
        CategoryEntity categoryEntity = categoryDao.selectById(categoryBrandRelation.getCatelogId());
        categoryBrandRelation.setCatelogName(categoryEntity.getName());
        //执行新增
        this.save(categoryBrandRelation);
    }
}