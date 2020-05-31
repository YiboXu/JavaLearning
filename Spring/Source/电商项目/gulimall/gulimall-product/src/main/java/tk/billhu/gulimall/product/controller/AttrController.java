package tk.billhu.gulimall.product.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import tk.billhu.gulimall.product.entity.AttrEntity;
import tk.billhu.gulimall.product.entity.ProductAttrValueEntity;
import tk.billhu.gulimall.product.service.AttrService;
import tk.billhu.gulimall.common.utils.PageUtils;
import tk.billhu.gulimall.common.utils.R;
import tk.billhu.gulimall.product.service.ProductAttrValueService;
import tk.billhu.gulimall.product.vo.AttrResponseVo;
import tk.billhu.gulimall.product.vo.AttrVo;


/**
 * 商品属性
 *
 * @author billhu
 * @email billtt@163.com
 * @date 2020-05-19 17:23:08
 */
@RestController
@RequestMapping("product/attr")
public class AttrController {
    @Autowired
    private AttrService attrService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    //@RequiresPermissions("product:attr:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = attrService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{attrId}")
    //@RequiresPermissions("product:attr:info")
    public R info(@PathVariable("attrId") Long attrId){
		AttrResponseVo attr = attrService.getAttrById(attrId);

        return R.ok().put("attr", attr);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    //@RequiresPermissions("product:attr:save")
    public R save(@RequestBody AttrVo attr){

		attrService.saveAttrVo(attr);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    //@RequiresPermissions("product:attr:update")
    public R update(@RequestBody AttrVo attr){
		attrService.updateAttrById(attr);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("product:attr:delete")
    public R delete(@RequestBody Long[] attrIds){
		attrService.removeAttrByIds(Arrays.asList(attrIds));

        return R.ok();
    }

    /**
     * 根据属性类别获取属性列表
     */
    @RequestMapping("/{type}/list/{catId}")
    public R listWithType(@PathVariable("type") String type, @PathVariable("catId") Long catId, @RequestParam Map<String, Object> params){

        PageUtils page = attrService.queryPageWithTypeAndCatId(params,type,catId);

        return R.ok().put("page", page);
    }

    /**
     *
     */
    @RequestMapping("/sale/list/{catelogId}")
    public R listSaleAttrWithCatId(@PathVariable("catelogId") Long catelogId, @RequestParam Map<String, Object> params){
        PageUtils page = attrService.queryPageWithTypeAndCatId(params,"sale",catelogId);

        return R.ok().put("page",page);
    }

    @RequestMapping("/base/listforspu/{spuId}")
    public R listBaseAttrBySpuId(@PathVariable("spuId") Long spuId){
        List<ProductAttrValueEntity> productAttrValueEntityList = attrService.listBaseAttrBySpuId(spuId);

        return R.ok().put("data",productAttrValueEntityList);
    }

    @RequestMapping("/update/{spuId}")
    public R updateBaseAttrBySpuId(@PathVariable("spuId") Long spuId, @RequestBody List<ProductAttrValueEntity> productAttrValueEntityList){
        attrService.updateBaseAttrBySpuId(spuId,productAttrValueEntityList);

        return R.ok();
    }
}
