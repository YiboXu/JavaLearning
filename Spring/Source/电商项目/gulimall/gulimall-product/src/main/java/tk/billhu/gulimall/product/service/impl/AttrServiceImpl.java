package tk.billhu.gulimall.product.service.impl;

import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import tk.billhu.gulimall.common.constant.Product;
import tk.billhu.gulimall.common.utils.PageUtils;
import tk.billhu.gulimall.common.utils.Query;

import tk.billhu.gulimall.product.dao.AttrAttrgroupRelationDao;
import tk.billhu.gulimall.product.dao.AttrDao;
import tk.billhu.gulimall.product.dao.AttrGroupDao;
import tk.billhu.gulimall.product.dao.CategoryDao;
import tk.billhu.gulimall.product.entity.AttrAttrgroupRelationEntity;
import tk.billhu.gulimall.product.entity.AttrEntity;
import tk.billhu.gulimall.product.entity.CategoryEntity;
import tk.billhu.gulimall.product.entity.ProductAttrValueEntity;
import tk.billhu.gulimall.product.service.AttrAttrgroupRelationService;
import tk.billhu.gulimall.product.service.AttrService;
import tk.billhu.gulimall.product.service.CategoryService;
import tk.billhu.gulimall.product.service.ProductAttrValueService;
import tk.billhu.gulimall.product.vo.AttrResponseVo;
import tk.billhu.gulimall.product.vo.AttrVo;


@Service("attrService")
public class AttrServiceImpl extends ServiceImpl<AttrDao, AttrEntity> implements AttrService {

    @Autowired
    private AttrAttrgroupRelationDao attrAttrgroupRelationDao;

    @Autowired
    private CategoryDao categoryDao;

    @Autowired
    private AttrGroupDao attrGroupDao;

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private ProductAttrValueService productAttrValueService;

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<AttrEntity> page = this.page(
                new Query<AttrEntity>().getPage(params),
                new QueryWrapper<AttrEntity>()
        );

        return new PageUtils(page);
    }

    @Override
    public PageUtils queryPage(Map<String, Object> params, QueryWrapper<AttrEntity> queryWrapper) {
        IPage<AttrEntity> page = this.page(
                new Query<AttrEntity>().getPage(params),
                queryWrapper
        );

        return new PageUtils(page);
    }

    @Override
    public PageUtils queryPageWithTypeAndCatId(Map<String, Object> params, String type, Long catId) {
        QueryWrapper<AttrEntity> queryWrapper = new QueryWrapper<>();

        if(!catId.equals(0L)){
            queryWrapper.eq("catelog_id",catId);
        }

        if("sale".equals(type)){
            queryWrapper.in("attr_type", Product.AttrEnum.SALES_ATTR.getCode(),Product.AttrEnum.BASE_SALES_ATTR.getCode());
        }else if("base".equals(type)){
            queryWrapper.in("attr_type",Product.AttrEnum.BASE_ATTR.getCode(),Product.AttrEnum.BASE_SALES_ATTR.getCode());
        }

        String keyValue = (String) params.get("key");
        if(!StringUtils.isEmpty(keyValue)){
            queryWrapper.and(obj -> {
                obj.eq("attr_id",keyValue).or().like("attr_name",keyValue);
            });
        }

        IPage<AttrEntity> page = this.page(
                new Query<AttrEntity>().getPage(params),
                queryWrapper
        );

        //将AttrEntity转换成AttrResponseVo
        List<AttrResponseVo> attrResponseVoList = page.getRecords().stream()
                .map(attrEntity -> getAttrByEntity(attrEntity))
                .collect(Collectors.toList());

        PageUtils pageUtils = new PageUtils(page);
        pageUtils.setList(attrResponseVoList);

        return pageUtils;
    }

    @Override
    public void saveAttrVo(AttrVo attr) {
        AttrEntity attrEntity = new AttrEntity();
        BeanUtils.copyProperties(attr,attrEntity);

        //添加记录到pms_attr
        this.save(attrEntity);

        //添加记录到其他表(pms_attr_attrgroup_relation)
        if(attrEntity.getAttrType().equals(Product.AttrEnum.BASE_ATTR.getCode()) && attr.getAttrGroupId() != null) {
            AttrAttrgroupRelationEntity attrAttrgroupRelationEntity = new AttrAttrgroupRelationEntity();
            attrAttrgroupRelationEntity.setAttrId(attrEntity.getAttrId());
            attrAttrgroupRelationEntity.setAttrGroupId(attr.getAttrGroupId());
            attrAttrgroupRelationEntity.setAttrSort(0);

            attrAttrgroupRelationDao.insert(attrAttrgroupRelationEntity);
        }
    }

    @Override
    public AttrResponseVo getAttrById(Long attrId) {
        AttrEntity attrEntity = this.getById(attrId);

        AttrResponseVo attrResponseVo = getAttrByEntity(attrEntity);

        return attrResponseVo;
    }

    private AttrResponseVo getAttrByEntity(AttrEntity attrEntity){
        AttrResponseVo attrResponseVo = new AttrResponseVo();
        BeanUtils.copyProperties(attrEntity,attrResponseVo);

        //获取catelogName
        CategoryEntity categoryEntity = categoryDao.selectById(attrResponseVo.getCatelogId());
        if(categoryEntity != null){
            attrResponseVo.setCatelogName(categoryEntity.getName());
        }

        //获取分类路径catelogPath
        attrResponseVo.setCatelogPath(categoryService.findCategoryPathById(attrResponseVo.getCatelogId()));

        if(attrEntity.getAttrType().equals(Product.AttrEnum.BASE_ATTR.getCode())) {
            //获取groupId和groupName
            QueryWrapper<AttrAttrgroupRelationEntity> queryWrapper1 = new QueryWrapper<>();
            queryWrapper1.eq("attr_id", attrResponseVo.getAttrId());
            AttrAttrgroupRelationEntity attrAttrgroupRelationEntity = attrAttrgroupRelationDao.selectOne(queryWrapper1);
            if (attrAttrgroupRelationEntity != null) {
                Long attrGroupId = attrAttrgroupRelationEntity.getAttrGroupId();
                if (attrGroupId != null) {
                    attrResponseVo.setAttrGroupId(attrGroupId);
                    attrResponseVo.setGroupName(attrGroupDao.selectById(attrGroupId).getAttrGroupName());
                }
            }
        }

        return attrResponseVo;
    }

    @Override
    public void updateAttrById(AttrVo attr) {
        AttrEntity attrEntity = new AttrEntity();
        BeanUtils.copyProperties(attr,attrEntity);

        //update pms_attr
        this.updateById(attrEntity);

        if(attrEntity.getAttrType().equals(Product.AttrEnum.BASE_ATTR.getCode())) {
            //update pms_attr_attrgroup_relation
            AttrAttrgroupRelationEntity attrAttrgroupRelationEntity = new AttrAttrgroupRelationEntity();
            attrAttrgroupRelationEntity.setAttrGroupId(attr.getAttrGroupId());

            UpdateWrapper<AttrAttrgroupRelationEntity> updateWrapper = new UpdateWrapper<>();
            updateWrapper.eq("attr_id", attr.getAttrId());

            //判断是新增还是修改
            int n = attrAttrgroupRelationDao.selectCount(updateWrapper);
            if (n == 0) {
                attrAttrgroupRelationEntity.setAttrId(attr.getAttrId());
                attrAttrgroupRelationEntity.setAttrSort(0);
                attrAttrgroupRelationDao.insert(attrAttrgroupRelationEntity);
            } else {
                attrAttrgroupRelationDao.update(attrAttrgroupRelationEntity, updateWrapper);
            }
        }
    }

    @Override
    public void removeAttrByIds(List<Long> asList) {
        this.removeByIds(asList);

        //删除关联表数据 pms_attr_attrgroup_relation
        UpdateWrapper<AttrAttrgroupRelationEntity> updateWrapper = new UpdateWrapper<>();
        updateWrapper.in("attr_id",asList);
        attrAttrgroupRelationDao.delete(updateWrapper);
    }

    @Override
    public List<ProductAttrValueEntity> listBaseAttrBySpuId(Long spuId) {
        QueryWrapper<ProductAttrValueEntity> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("spu_id",spuId);
        List<ProductAttrValueEntity> productAttrValueEntityList = productAttrValueService.list(queryWrapper);

        return productAttrValueEntityList;
    }

    @Override
    public void updateBaseAttrBySpuId(Long spuId, List<ProductAttrValueEntity> productAttrValueEntityList) {
        productAttrValueEntityList.stream().forEach(productAttrValueEntity -> {
            UpdateWrapper<ProductAttrValueEntity> updateWrapper = new UpdateWrapper<>();
            updateWrapper.eq("spu_id",spuId);
            updateWrapper.eq("attr_id",productAttrValueEntity.getAttrId());
            productAttrValueService.update(productAttrValueEntity,updateWrapper);
        });
    }
}