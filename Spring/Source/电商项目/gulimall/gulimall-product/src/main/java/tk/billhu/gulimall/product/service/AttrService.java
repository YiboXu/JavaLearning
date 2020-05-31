package tk.billhu.gulimall.product.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.IService;
import tk.billhu.gulimall.common.utils.PageUtils;
import tk.billhu.gulimall.product.entity.AttrEntity;
import tk.billhu.gulimall.product.entity.ProductAttrValueEntity;
import tk.billhu.gulimall.product.vo.AttrResponseVo;
import tk.billhu.gulimall.product.vo.AttrVo;

import java.util.List;
import java.util.Map;

/**
 * 商品属性
 *
 * @author billhu
 * @email billtt@163.com
 * @date 2020-05-19 17:23:08
 */
public interface AttrService extends IService<AttrEntity> {

    PageUtils queryPage(Map<String, Object> params);

    PageUtils queryPage(Map<String, Object> params, QueryWrapper<AttrEntity> queryWrapper);

    PageUtils queryPageWithTypeAndCatId(Map<String, Object> params, String type, Long catId);

    void saveAttrVo(AttrVo attr);

    AttrResponseVo getAttrById(Long attrId);

    void updateAttrById(AttrVo attr);

    void removeAttrByIds(List<Long> asList);

    List<ProductAttrValueEntity> listBaseAttrBySpuId(Long spuId);

    void updateBaseAttrBySpuId(Long spuId, List<ProductAttrValueEntity> productAttrValueEntityList);
}

