package tk.billhu.gulimall.coupon.service;

import com.baomidou.mybatisplus.extension.service.IService;
import tk.billhu.gulimall.common.utils.PageUtils;
import tk.billhu.gulimall.coupon.entity.HomeAdvEntity;

import java.util.Map;

/**
 * 首页轮播广告
 *
 * @author billhu
 * @email billtt@163.com
 * @date 2020-05-19 17:38:43
 */
public interface HomeAdvService extends IService<HomeAdvEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

