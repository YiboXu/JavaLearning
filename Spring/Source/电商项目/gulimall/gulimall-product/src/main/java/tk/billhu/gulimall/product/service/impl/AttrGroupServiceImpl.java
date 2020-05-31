package tk.billhu.gulimall.product.service.impl;

import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.util.StringUtils;
import tk.billhu.gulimall.common.constant.Product;
import tk.billhu.gulimall.common.utils.PageUtils;
import tk.billhu.gulimall.common.utils.Query;

import tk.billhu.gulimall.product.dao.AttrAttrgroupRelationDao;
import tk.billhu.gulimall.product.dao.AttrGroupDao;
import tk.billhu.gulimall.product.entity.AttrAttrgroupRelationEntity;
import tk.billhu.gulimall.product.entity.AttrEntity;
import tk.billhu.gulimall.product.entity.AttrGroupEntity;
import tk.billhu.gulimall.product.service.AttrAttrgroupRelationService;
import tk.billhu.gulimall.product.service.AttrGroupService;
import tk.billhu.gulimall.product.service.AttrService;
import tk.billhu.gulimall.product.service.CategoryService;
import tk.billhu.gulimall.product.vo.AttrGroupWithAttrVo;


@Service("attrGroupService")
public class AttrGroupServiceImpl extends ServiceImpl<AttrGroupDao, AttrGroupEntity> implements AttrGroupService {

    @Autowired
    private AttrAttrgroupRelationService attrAttrgroupRelationService;

    @Autowired
    private AttrService attrService;

    @Autowired
    private CategoryService categoryService;

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<AttrGroupEntity> page = this.page(
                new Query<AttrGroupEntity>().getPage(params),
                new QueryWrapper<AttrGroupEntity>()
        );

        return new PageUtils(page);
    }

    @Override
    public PageUtils queryPage(Map<String, Object> params, Long catelogId) {
        QueryWrapper<AttrGroupEntity> queryWrapper = new QueryWrapper<>();

        //如果params里面包含一个键值为"key"的值, 那么还需要通过"key"的值进行模糊查询
        // - attr_group_id = keyValue
        // - attr_group_name like keyValue
        String keyValue = (String) params.get("key");
        if(!StringUtils.isEmpty(keyValue)) {
            queryWrapper.and(obj ->
                    obj.eq("attr_group_id", keyValue)
                            .or()
                            .like("attr_group_name",keyValue));
        }

        //如果catelogId 为0,就查询所有的属性分组信息
        if(!catelogId.equals(0L)) {
            queryWrapper.eq("catelog_id", catelogId);
        }

        IPage<AttrGroupEntity> page = this.page(
                new Query<AttrGroupEntity>().getPage(params),
                queryWrapper
        );

        //设置分类名
        page.getRecords().stream()
                .forEach(attrGroupEntity ->
                        attrGroupEntity.setCatelogName(categoryService.getById(attrGroupEntity.getCatelogId()).getName()));

        return new PageUtils(page);
    }

    @Override
    public List<AttrEntity> listAttrByGroupId(Long attrGroupId) {
        List<Long> attrIdList = attrAttrgroupRelationService
                .list(new QueryWrapper<AttrAttrgroupRelationEntity>().eq("attr_group_id",attrGroupId))
                .stream()
                .map(AttrAttrgroupRelationEntity::getAttrId)
                .collect(Collectors.toList());

        List<AttrEntity> attrEntityList = new ArrayList<>();

        if(attrIdList.size() > 0) {
            attrEntityList = attrService.list(new QueryWrapper<AttrEntity>().in("attr_id", attrIdList));
        }

        return attrEntityList;
    }

    @Override
    public PageUtils listNoAttr(Long attrGroupId, Map<String, Object> params) {
        //获取当前分组所在类别
        Long catelogId = this.getById(attrGroupId).getCatelogId();

        //获取所有已经被关联的属性的attrId (每个属性只能关联于一个属性组)
        QueryWrapper<AttrAttrgroupRelationEntity> queryWrapper1 = new QueryWrapper<>();
        //queryWrapper1.eq("attr_group_id",attrGroupId);

        List<Long> attrIdList = attrAttrgroupRelationService.list(queryWrapper1)
                                .stream()
                                .map(AttrAttrgroupRelationEntity::getAttrId)
                                .collect(Collectors.toList());

        //从pms_attr里面获取其他attr
        QueryWrapper<AttrEntity> queryWrapper2 = new QueryWrapper<>();
        //排除销售属性
        queryWrapper2.ne("attr_type", Product.AttrEnum.SALES_ATTR.getCode());
        //只返回同属性组属于同一个catelog的属性
        queryWrapper2.eq("catelog_id",catelogId);

        //设置查询关键字
        String keyValue = (String) params.get("key");
        if(!StringUtils.isEmpty(keyValue)){
            queryWrapper2.eq("attr_id",keyValue).or().like("attr_name",keyValue);
        }

        if(attrIdList.size() > 0){
            queryWrapper2.notIn("attr_id",attrIdList);
        }

        PageUtils pageUtils = attrService.queryPage(params,queryWrapper2);
        return pageUtils;
    }

    @Override
    public void addRelation(Long attrGroupId, Long[] attrIds) {
        for(Long attrId : attrIds){
            AttrAttrgroupRelationEntity attrAttrgroupRelationEntity = new AttrAttrgroupRelationEntity();
            attrAttrgroupRelationEntity.setAttrId(attrId);
            attrAttrgroupRelationEntity.setAttrGroupId(attrGroupId);
            attrAttrgroupRelationEntity.setAttrSort(0);

            attrAttrgroupRelationService.save(attrAttrgroupRelationEntity);
        }
    }

    @Override
    public void removeRelation(Long attrGroupId, Long[] attrIds) {
        UpdateWrapper<AttrAttrgroupRelationEntity> updateWrapper = new UpdateWrapper<>();
        updateWrapper.eq("attr_group_id",attrGroupId);
        updateWrapper.in("attr_id",attrIds);

        attrAttrgroupRelationService.remove(updateWrapper);
    }

    @Override
    public boolean removeByIds(Collection<? extends Serializable> idList) {
        boolean result = super.removeByIds(idList);

        //删除关联表
        UpdateWrapper<AttrAttrgroupRelationEntity> updateWrapper = new UpdateWrapper<>();
        updateWrapper.in("attr_group_id",idList);
        attrAttrgroupRelationService.remove(updateWrapper);

        return result;
    }

    @Override
    public List<AttrGroupWithAttrVo> getAttrGroupWithAttrs(Long catelogId) {
        List<AttrGroupWithAttrVo> attrGroupWithAttrVoList = new ArrayList<>();

        QueryWrapper<AttrGroupEntity> queryWrapper1 = new QueryWrapper<>();
        queryWrapper1.eq("catelog_id",catelogId);
        this.list(queryWrapper1).stream()
                .forEach(attrGroupEntity -> {
                    //装配属性组信息
                    AttrGroupWithAttrVo attrGroupWithAttrVo = new AttrGroupWithAttrVo();
                    BeanUtils.copyProperties(attrGroupEntity,attrGroupWithAttrVo);

                    //装配属性列表
                    List<AttrEntity> attrEntityList = this.listAttrByGroupId(attrGroupEntity.getAttrGroupId());
                    attrGroupWithAttrVo.setAttrs(attrEntityList);

                    attrGroupWithAttrVoList.add(attrGroupWithAttrVo);
                });

        return attrGroupWithAttrVoList;
    }
}