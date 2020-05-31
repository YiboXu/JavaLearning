package tk.billhu.gulimall.product.service.impl;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;
import tk.billhu.gulimall.common.service.CouponFeignService;
import tk.billhu.gulimall.common.to.SkuReductionTo;
import tk.billhu.gulimall.common.to.SpuBoundTo;
import tk.billhu.gulimall.common.utils.PageUtils;
import tk.billhu.gulimall.common.utils.Query;

import tk.billhu.gulimall.common.utils.R;
import tk.billhu.gulimall.product.dao.SpuInfoDao;
import tk.billhu.gulimall.product.entity.*;
import tk.billhu.gulimall.product.service.*;
import tk.billhu.gulimall.product.vo.Attr;
import tk.billhu.gulimall.product.vo.Bounds;
import tk.billhu.gulimall.product.vo.Images;
import tk.billhu.gulimall.product.vo.SpuSaveVo;


@Service("spuInfoService")
public class SpuInfoServiceImpl extends ServiceImpl<SpuInfoDao, SpuInfoEntity> implements SpuInfoService {

    @Autowired
    private SpuInfoDescService spuInfoDescService;

    @Autowired
    private SpuImagesService spuImagesService;

    @Autowired
    private AttrService attrService;

    @Autowired
    private ProductAttrValueService productAttrValueService;

    @Autowired
    private SkuInfoService skuInfoService;

    @Autowired
    private SkuImagesService skuImagesService;

    @Autowired
    private SkuSaleAttrValueService skuSaleAttrValueService;

    @Autowired
    private CouponFeignService couponFeignService;

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        //获取查询条件
        Long catelogId = params.get("catelogId") == null ? 0L : Long.parseLong((String)params.get("catelogId"));
        Long brandId = params.get("brandId") == null ? 0L : Long.parseLong((String)params.get("brandId"));
        Integer status = params.get("status") == null || StringUtils.isEmpty((String) params.get("status"))? -1 : Integer.parseInt((String)params.get("status"));
        String keyValue = params.get("key") == null ? "" : (String) params.get("key");

        QueryWrapper<SpuInfoEntity> queryWrapper = new QueryWrapper<>();

        if(catelogId != 0L){
            queryWrapper.eq("catelog_id",catelogId);
        }

        if(brandId != 0L){
            queryWrapper.eq("brand_id",brandId);
        }

        if(status >= 0){
            queryWrapper.eq("publish_status",status);
        }

        if(StringUtils.isEmpty(keyValue)){
            queryWrapper.and(obj -> {
                obj.eq("id",keyValue).or().like("spu_name",keyValue).or().like("spu_description",keyValue);
            });
        }

        IPage<SpuInfoEntity> page = this.page(
                new Query<SpuInfoEntity>().getPage(params),
                queryWrapper
        );

        return new PageUtils(page);
    }

    @Override
    @Transactional
    public void saveSpuInfo(SpuSaveVo vo) {
        //1. 保存spu基本信息 pms_spu_info
        SpuInfoEntity spuInfoEntity = new SpuInfoEntity();
        BeanUtils.copyProperties(vo,spuInfoEntity);
        spuInfoEntity.setCreateTime(new Date());
        spuInfoEntity.setUpdateTime(new Date());
        this.save(spuInfoEntity);
        //2. 保存spu的描述图片 pms_spu_info_desc
        SpuInfoDescEntity spuInfoDescEntity = new SpuInfoDescEntity();
        spuInfoDescEntity.setSpuId(spuInfoEntity.getId());
        spuInfoDescEntity.setDecript(String.join(",",vo.getDecript()));
        spuInfoDescService.save(spuInfoDescEntity);
        //3. 保存spu的图片集 pms_spu_images
        List<String> images = vo.getImages();
        spuImagesService.saveImages(spuInfoEntity.getId(),images);
        //4. 保存spu的规格参数 pms_product_attr_value
        List<ProductAttrValueEntity> productAttrValueEntityList = vo.getBaseAttrs().stream().map(baseAttr -> {
            ProductAttrValueEntity productAttrValueEntity = new ProductAttrValueEntity();
            productAttrValueEntity.setSpuId(spuInfoEntity.getId());
            productAttrValueEntity.setAttrId(baseAttr.getAttrId());
            productAttrValueEntity.setAttrName(attrService.getById(baseAttr.getAttrId()).getAttrName());
            productAttrValueEntity.setAttrValue(baseAttr.getAttrValues());
            productAttrValueEntity.setQuickShow(baseAttr.getShowDesc());

            return productAttrValueEntity;
        }).collect(Collectors.toList());

        productAttrValueService.saveProductAttr(productAttrValueEntityList);
        //5. 保存spu的积分信息 gulimall_sms -> sms_spu_bounds
        Bounds bounds = vo.getBounds();
        SpuBoundTo spuBoundTo = new SpuBoundTo();
        BeanUtils.copyProperties(bounds,spuBoundTo);
        spuBoundTo.setSpuId(spuInfoEntity.getId());

        R r = couponFeignService.saveSpuBound(spuBoundTo);

        if(r.getCode() != 0){
            log.error("远程保存spu积分信息失败");
        }

        //6. 保存当前spu对应的所有sku信息
        vo.getSkus().stream()
                .forEach(sku -> {
                    String defaultImg = "";
                    for (Images image : sku.getImages()) {
                        if(image.getDefaultImg() == 1){
                            defaultImg = image.getImgUrl();
                        }
                    }
                    //6.1 sku的基本信息 pms_sku_info
                    SkuInfoEntity skuInfoEntity = new SkuInfoEntity();
                    BeanUtils.copyProperties(sku,skuInfoEntity);
                    skuInfoEntity.setBrandId(spuInfoEntity.getBrandId());
                    skuInfoEntity.setCatalogId(spuInfoEntity.getCatalogId());
                    skuInfoEntity.setSaleCount(0L);
                    skuInfoEntity.setSpuId(spuInfoEntity.getId());
                    skuInfoEntity.setSkuDefaultImg(defaultImg);

                    skuInfoService.save(skuInfoEntity);

                    Long skuId = skuInfoEntity.getSkuId();
                    //6.2 sku的图片信息 pms_sku_images
                    List<SkuImagesEntity> skuImagesEntityList = sku.getImages().stream()
                            .map(image -> {
                                SkuImagesEntity skuImagesEntity = new SkuImagesEntity();
                                skuImagesEntity.setSkuId(skuId);
                                skuImagesEntity.setImgUrl(image.getImgUrl());
                                skuImagesEntity.setDefaultImg(image.getDefaultImg());

                                return skuImagesEntity;
                            })
                            .filter(skuImagesEntity -> !StringUtils.isEmpty(skuImagesEntity.getImgUrl()))
                            .collect(Collectors.toList());

                    skuImagesService.saveBatch(skuImagesEntityList);

                    //6.3 sku的销售属性信息 pms_sku_sale_attr_value
                    List<SkuSaleAttrValueEntity> skuSaleAttrValueEntityList = sku.getAttr().stream()
                            .map(attr -> {
                                SkuSaleAttrValueEntity skuSaleAttrValueEntity = new SkuSaleAttrValueEntity();
                                BeanUtils.copyProperties(attr,skuSaleAttrValueEntity);
                                skuSaleAttrValueEntity.setSkuId(skuId);

                                return skuSaleAttrValueEntity;
                            })
                            .collect(Collectors.toList());

                    skuSaleAttrValueService.saveBatch(skuSaleAttrValueEntityList);

                    //6.4 sku的优惠,满减等信息: gulimall_sms -> sms_sku_ladder\ sms_sku_full_reduction\ sms_member_price
                    SkuReductionTo skuReductionTo = new SkuReductionTo();
                    BeanUtils.copyProperties(sku,skuReductionTo);
                    skuReductionTo.setSkuId(skuId);
                    if(skuReductionTo.getFullCount() >0 || skuReductionTo.getFullPrice().compareTo(new BigDecimal("0")) == 1){
                        R r1 = couponFeignService.saveSkuReduction(skuReductionTo);
                        if(r1.getCode() != 0){
                            log.error("远程保存sku优惠信息失败");
                        }
                    }
                });
    }
}















