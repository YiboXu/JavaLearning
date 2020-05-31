package tk.billhu.gulimall.coupon.dao;

import tk.billhu.gulimall.coupon.entity.SkuLadderEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 商品阶梯价格
 * 
 * @author billhu
 * @email billtt@163.com
 * @date 2020-05-19 17:38:43
 */
@Mapper
public interface SkuLadderDao extends BaseMapper<SkuLadderEntity> {
	
}
