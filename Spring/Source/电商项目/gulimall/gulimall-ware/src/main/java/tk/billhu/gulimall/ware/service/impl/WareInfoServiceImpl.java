package tk.billhu.gulimall.ware.service.impl;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import tk.billhu.gulimall.common.utils.PageUtils;
import tk.billhu.gulimall.common.utils.Query;

import tk.billhu.gulimall.ware.dao.WareInfoDao;
import tk.billhu.gulimall.ware.entity.WareInfoEntity;
import tk.billhu.gulimall.ware.service.WareInfoService;


@Service("wareInfoService")
public class WareInfoServiceImpl extends ServiceImpl<WareInfoDao, WareInfoEntity> implements WareInfoService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        //获取查询参数
        String keyValue = (String) params.get("key");

        QueryWrapper<WareInfoEntity> queryWrapper = new QueryWrapper<>();

        if(!StringUtils.isEmpty(keyValue)){
            queryWrapper.eq("id",keyValue).or().like("name",keyValue).or().like("address",keyValue);
        }

        IPage<WareInfoEntity> page = this.page(
                new Query<WareInfoEntity>().getPage(params),
                queryWrapper
        );

        return new PageUtils(page);
    }

}