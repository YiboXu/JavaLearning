package tk.billhu.gulimall.product.dao;

import tk.billhu.gulimall.product.entity.CategoryEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 商品三级分类
 * 
 * @author billhu
 * @email billtt@163.com
 * @date 2020-05-19 17:23:07
 */
@Mapper
public interface CategoryDao extends BaseMapper<CategoryEntity> {
	
}
