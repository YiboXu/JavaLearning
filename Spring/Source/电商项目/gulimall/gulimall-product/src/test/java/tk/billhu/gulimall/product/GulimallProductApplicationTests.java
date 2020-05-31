package tk.billhu.gulimall.product;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import org.springframework.test.context.junit4.SpringRunner;

import tk.billhu.gulimall.common.utils.PageUtils;
import tk.billhu.gulimall.product.dao.BrandDao;
import tk.billhu.gulimall.product.entity.BrandEntity;
import tk.billhu.gulimall.product.entity.CategoryBrandRelationEntity;
import tk.billhu.gulimall.product.service.BrandService;
import tk.billhu.gulimall.product.service.CategoryBrandRelationService;
import tk.billhu.gulimall.product.service.CategoryService;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class GulimallProductApplicationTests {

    @Autowired
    private BrandService brandService;

    @Autowired
    private BrandDao brandDao;

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private CategoryBrandRelationService categoryBrandRelationService;

    @Test
    public void test01(){
        BrandEntity brandEntity = new BrandEntity();
        brandEntity.setDescript("hua-wei");
        brandEntity.setName("huawei");
        brandService.save(brandEntity);

        brandEntity.setDescript("xiao-mi");
        brandEntity.setName("xiaomi");
        brandService.save(brandEntity);

        brandEntity.setDescript("apple");
        brandEntity.setName("applie");
        brandService.save(brandEntity);

        brandEntity.setDescript("vi-va");
        brandEntity.setName("viva");
        brandService.save(brandEntity);
    }

    @Test
    public void test02(){
        //brandService.listByIds(Arrays.asList(1,2,3)).forEach(System.out::println);
        Map<String, Object> map = new HashMap<>();
        map.put("page","2");
        map.put("limit","2");
        PageUtils pageUtils = brandService.queryPage(map);
        System.out.println(pageUtils.getCurrPage());
        System.out.println(pageUtils.getList());
        System.out.println(pageUtils.getPageSize());

    }

    @Test
    public void test03(){
        BrandEntity brand = brandDao.selectById(2);
        System.out.println(brand);

        Map<String,Object> map = new HashMap<>();
        map.put("name","xiaomi");
        List<BrandEntity> brandEntityList = brandDao.selectByMap(map);
        System.out.println(brandEntityList);

        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.eq("name","viva");
        List<BrandEntity> brandEntityList1 = brandDao.selectList(queryWrapper);
        System.out.println(brandEntityList1);

        Page<BrandEntity> page = new Page<>(1,2);
        brandDao.selectPage(page,null);
        System.out.println(page.getTotal());
        System.out.println(page.getRecords());
        System.out.println(page.getCurrent());

        brandDao.selectPage(page,queryWrapper);
        System.out.println("=============");
        System.out.println(page.getTotal());
        System.out.println(page.getRecords());
        System.out.println(page.getCurrent());
    }

    @Test
    public void test04(){
        Long[] categoryPath = categoryService.findCategoryPathById(225L);
        log.info("完整路径: {}", Arrays.asList(categoryPath));
    }

    @Test
    public void test05(){
        List<CategoryBrandRelationEntity> categoryBrandRelationEntityList = categoryBrandRelationService.listWithBrandId(1L);
        log.info("查询结果: {}", categoryBrandRelationEntityList);
    }
}
