package tk.billhu.gulimall.product.service;

import com.baomidou.mybatisplus.extension.service.IService;
import tk.billhu.gulimall.common.utils.PageUtils;
import tk.billhu.gulimall.product.entity.CategoryBrandRelationEntity;
import tk.billhu.gulimall.product.entity.CategoryEntity;

import java.util.List;
import java.util.Map;

/**
 * 品牌分类关联
 *
 * @author billhu
 * @email billtt@163.com
 * @date 2020-05-19 17:23:08
 */
public interface CategoryBrandRelationService extends IService<CategoryBrandRelationEntity> {

    PageUtils queryPage(Map<String, Object> params);

    List<CategoryBrandRelationEntity> listWithBrandId(Long brandId);

    void saveDetail(CategoryBrandRelationEntity categoryBrandRelation);
}

