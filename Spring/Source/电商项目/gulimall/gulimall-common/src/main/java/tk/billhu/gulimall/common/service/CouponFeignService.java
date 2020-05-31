package tk.billhu.gulimall.common.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import tk.billhu.gulimall.common.to.SkuReductionTo;
import tk.billhu.gulimall.common.to.SpuBoundTo;
import tk.billhu.gulimall.common.utils.R;

@FeignClient("gulimall-coupon")
public interface CouponFeignService {

    //虽然参数类型和SpuBoundsController里面的save(@RequestBody SpuBoundsEntity spuBounds)不一样，但是SpuBoundTo里面包含了需要传递给SpuBoundsEntity的字段
    @RequestMapping("coupon/spubounds/save")
    R saveSpuBound(@RequestBody SpuBoundTo spuBoundTo);

    @PostMapping("/coupon/skufullreduction/saveinfo")
    R saveSkuReduction(@RequestBody SkuReductionTo skuReductionTo);
}
