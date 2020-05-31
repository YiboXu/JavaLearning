package tk.billhu.gulimall.product.controller;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import tk.billhu.gulimall.common.valid.AddGroup;
import tk.billhu.gulimall.common.valid.DeleteGroup;
import tk.billhu.gulimall.common.valid.UpdateGroup;
import tk.billhu.gulimall.product.entity.BrandEntity;
import tk.billhu.gulimall.product.service.BrandService;
import tk.billhu.gulimall.common.utils.PageUtils;
import tk.billhu.gulimall.common.utils.R;

import javax.validation.Valid;


/**
 * 品牌
 *
 * @author billhu
 * @email billtt@163.com
 * @date 2020-05-19 17:23:08
 */
@RestController
@RequestMapping("product/brand")
public class BrandController {
    @Autowired
    private BrandService brandService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    //@RequiresPermissions("product:brand:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = brandService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{brandId}")
    //@RequiresPermissions("product:brand:info")
    public R info(@PathVariable("brandId") Long brandId){
		BrandEntity brand = brandService.getById(brandId);

        return R.ok().put("brand", brand);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    //public R save(@Valid @RequestBody BrandEntity brand /*, BindingResult bindingResult */){
    public R save(@Validated(AddGroup.class) @RequestBody BrandEntity brand /*, BindingResult bindingResult */){
        /*
        if(bindingResult.hasErrors()){
            Map<String,String> resultMap = new HashMap<>();
            bindingResult.getFieldErrors().forEach(fieldError -> {
                resultMap.put(fieldError.getField(),fieldError.getDefaultMessage());
            });

            return R.error("保存商品品牌失败").put("data",resultMap);
        }else{
            brandService.save(brand);
        }
        */

        brandService.save(brand);
        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    //@RequiresPermissions("product:brand:update")
    public R update(@Validated(UpdateGroup.class) @RequestBody BrandEntity brand){
		//brandService.updateById(brand);
        brandService.updateDetail(brand);
        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("product:brand:delete")
    public R delete(@Validated(DeleteGroup.class) @RequestBody Long[] brandIds){
		brandService.removeByIds(Arrays.asList(brandIds));

        return R.ok();
    }

}
