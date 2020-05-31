package tk.billhu.gulimall.product.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import tk.billhu.gulimall.product.entity.AttrAttrgroupRelationEntity;
import tk.billhu.gulimall.product.entity.AttrEntity;
import tk.billhu.gulimall.product.entity.AttrGroupEntity;
import tk.billhu.gulimall.product.service.AttrAttrgroupRelationService;
import tk.billhu.gulimall.product.service.AttrGroupService;
import tk.billhu.gulimall.common.utils.PageUtils;
import tk.billhu.gulimall.common.utils.R;
import tk.billhu.gulimall.product.service.CategoryService;
import tk.billhu.gulimall.product.vo.AttrGroupWithAttrVo;


/**
 * 属性分组
 *
 * @author billhu
 * @email billtt@163.com
 * @date 2020-05-19 17:23:08
 */
@RestController
@RequestMapping("product/attrgroup")
public class AttrGroupController {
    @Autowired
    private AttrGroupService attrGroupService;

    @Autowired
    private CategoryService categoryService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    //@RequiresPermissions("product:attrgroup:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = attrGroupService.queryPage(params);

        return R.ok().put("page", page);
    }

    /**
     * 通过商品类别来获取对应的属性分组信息
     */
    @RequestMapping("/list/{catelogId}")
    public R listByCatelogId(@PathVariable("catelogId") Long catelogId, @RequestParam Map<String, Object> params){

        PageUtils page = attrGroupService.queryPage(params,catelogId);

        return R.ok().put("page", page);
    }

    /**
     * 信息
     */
    @RequestMapping("/info/{attrGroupId}")
    //@RequiresPermissions("product:attrgroup:info")
    public R info(@PathVariable("attrGroupId") Long attrGroupId){
		AttrGroupEntity attrGroup = attrGroupService.getById(attrGroupId);

		Long catId = attrGroup.getCatelogId();
        Long[] catelogPath = categoryService.findCategoryPathById(catId);
        attrGroup.setCatelogPath(catelogPath);

        return R.ok().put("attrGroup", attrGroup);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    //@RequiresPermissions("product:attrgroup:save")
    public R save(@RequestBody AttrGroupEntity attrGroup){
		attrGroupService.save(attrGroup);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    //@RequiresPermissions("product:attrgroup:update")
    public R update(@RequestBody AttrGroupEntity attrGroup){
		attrGroupService.updateById(attrGroup);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("product:attrgroup:delete")
    public R delete(@RequestBody Long[] attrGroupIds){
		attrGroupService.removeByIds(Arrays.asList(attrGroupIds));

        return R.ok();
    }

    /**
     * 获取一个属性分组下所有关联的属性
     */
    @RequestMapping("/{attrGroupId}/attr/relation")
    public R listAttrRelation(@PathVariable("attrGroupId") Long attrGroupId){
        List<AttrEntity> attrEntityList = attrGroupService.listAttrByGroupId(attrGroupId);

        return R.ok().put("data",attrEntityList);
    }

    /**
     * 获取没有关联到特定属性组的属性
     */

    @RequestMapping("/{attrGroupId}/noattr/relation")
    public R listNoAttr(@PathVariable("attrGroupId") Long attrGroupId, @RequestParam Map<String, Object> params){
        PageUtils page = attrGroupService.listNoAttr(attrGroupId, params);

        return R.ok().put("page",page);
    }

    /**
     * 关联属性到属性组
     */
    @RequestMapping("/attr/relation/{attrGroupId}")
    public R attrRelation(@PathVariable("attrGroupId") Long attrGroupId, @RequestBody Long[] attrIds){
        attrGroupService.addRelation(attrGroupId, attrIds);

        return R.ok();
    }

    /**
     * 删除所关联的属性
     */
    @RequestMapping("/attr/relation/delete/{attrGroupId}")
    public R removeAttrRelation(@PathVariable("attrGroupId") Long attrGroupId, @RequestBody Long[] attrIds){
        attrGroupService.removeRelation(attrGroupId, attrIds);

        return R.ok();
    }

    /**
     *获取分类下所有分组&关联属性
     */
    @RequestMapping("/{catelogId}/withattr")
    public R getAttrGroupWithAttrs(@PathVariable("catelogId") Long catelogId){

        List<AttrGroupWithAttrVo> attrGroupWithAttrVoList = attrGroupService.getAttrGroupWithAttrs(catelogId);

        return R.ok().put("data",attrGroupWithAttrVoList);
    }
}
