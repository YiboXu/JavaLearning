package tk.billhu.gulimall.product.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.IService;
import tk.billhu.gulimall.common.utils.PageUtils;
import tk.billhu.gulimall.product.entity.AttrEntity;
import tk.billhu.gulimall.product.entity.AttrGroupEntity;
import tk.billhu.gulimall.product.vo.AttrGroupWithAttrVo;

import java.util.List;
import java.util.Map;

/**
 * 属性分组
 *
 * @author billhu
 * @email billtt@163.com
 * @date 2020-05-19 17:23:08
 */
public interface AttrGroupService extends IService<AttrGroupEntity> {

    PageUtils queryPage(Map<String, Object> params);
    PageUtils queryPage(Map<String, Object> params, Long catelogId);

    List<AttrEntity> listAttrByGroupId(Long attrGroupId);

    PageUtils listNoAttr(Long attrGroupId, Map<String, Object> params);

    void addRelation(Long attrGroupId, Long[] attrIds);

    void removeRelation(Long attrGroupId, Long[] attrIds);

    List<AttrGroupWithAttrVo> getAttrGroupWithAttrs(Long catelogId);
}

