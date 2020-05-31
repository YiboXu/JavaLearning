package tk.billhu.gulimall.product.service.impl;

import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.*;
import java.util.stream.Collectors;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import tk.billhu.gulimall.common.utils.PageUtils;
import tk.billhu.gulimall.common.utils.Query;

import tk.billhu.gulimall.product.dao.CategoryBrandRelationDao;
import tk.billhu.gulimall.product.dao.CategoryDao;
import tk.billhu.gulimall.product.entity.CategoryBrandRelationEntity;
import tk.billhu.gulimall.product.entity.CategoryEntity;
import tk.billhu.gulimall.product.service.CategoryService;


@Service("categoryService")
public class CategoryServiceImpl extends ServiceImpl<CategoryDao, CategoryEntity> implements CategoryService {

    @Autowired
    private CategoryBrandRelationDao categoryBrandRelationDao;

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<CategoryEntity> page = this.page(
                new Query<CategoryEntity>().getPage(params),
                new QueryWrapper<CategoryEntity>()
        );

        return new PageUtils(page);
    }

    @Override
    public List<CategoryEntity> listWithTree() {
        List<CategoryEntity> categoryEntityList = baseMapper.selectList(null);

        List<CategoryEntity> level1EntityList =
                categoryEntityList.stream()
                        .filter(category -> category.getParentCid().longValue() == 0L)
                        .map(category -> {
                            category.setChildren(getChildren(category,categoryEntityList));
                            //set sort to avoid null point exception
                            if(category.getSort() == null){
                                category.setSort(0);
                            }
                            return category;
                        })
                        .sorted(Comparator.comparingInt(CategoryEntity::getSort))
                        .collect(Collectors.toList());

        return level1EntityList;
    }

    private List<CategoryEntity> getChildren(CategoryEntity parentCategory, List<CategoryEntity> categoryEntityList) {
        List<CategoryEntity> children =
                categoryEntityList.stream()
                        //Long对象比较大小不能用==,
                .filter(category -> category.getParentCid().equals(parentCategory.getCatId()))
                .map(category -> {
                    category.setChildren(getChildren(category,categoryEntityList));
                    //set sort to avoid null point exception
                    if(category.getSort() == null){
                        category.setSort(0);
                    }
                    return category;
                })
                .sorted(Comparator.comparingInt(CategoryEntity::getSort))
                .collect(Collectors.toList());

        return children;
    }

    @Override
    public Long[] findCategoryPathById(Long catId) {
        List<Long> categoryPath = new ArrayList<>();
        categoryPath.add(catId);

        findParentCategoryPath(catId, categoryPath);

        Collections.reverse(categoryPath);

        return categoryPath.toArray(new Long[categoryPath.size()]);
    }

    private void findParentCategoryPath(Long catId, List<Long> categoryPath) {
        //获取父id
        CategoryEntity categoryEntity = this.baseMapper.selectById(catId);

        if(categoryEntity.getParentCid() != 0){
            categoryPath.add(categoryEntity.getParentCid());
            findParentCategoryPath(categoryEntity.getParentCid(),categoryPath);
        }
    }

    @Override
    public void updateDetail(CategoryEntity category) {
        //更新pms_category
        this.updateById(category);

        //更新其他冗余数据表(也就是包含了category name的其他表)
        String categoryName = category.getName();
        if(!StringUtils.isEmpty(categoryName)){
            CategoryBrandRelationEntity categoryBrandRelationEntity = new CategoryBrandRelationEntity();
            categoryBrandRelationEntity.setCatelogId(category.getCatId());
            categoryBrandRelationEntity.setCatelogName(categoryName);

            UpdateWrapper<CategoryBrandRelationEntity> updateWrapper = new UpdateWrapper();
            updateWrapper.eq("catelog_id",category.getCatId());

            categoryBrandRelationDao.update(categoryBrandRelationEntity,updateWrapper);
        }
    }

    @Override
    public boolean removeByIds(Collection<? extends Serializable> idList) {
        Boolean result1 = super.removeByIds(idList);

        //删除关联表记录
        //pms_category_brand_relation
        UpdateWrapper<CategoryBrandRelationEntity> updateWrapper = new UpdateWrapper<>();
        updateWrapper.in("catelog_id",idList);
        categoryBrandRelationDao.delete(updateWrapper);

        return result1;
    }
}