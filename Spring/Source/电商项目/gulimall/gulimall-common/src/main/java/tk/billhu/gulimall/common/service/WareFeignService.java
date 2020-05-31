package tk.billhu.gulimall.common.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import tk.billhu.gulimall.common.utils.R;

import java.util.Map;

@FeignClient("gulimall-ware")
public interface WareFeignService {

    @RequestMapping("/ware/purchase/list")
    R list(@RequestParam Map<String, Object> params);

    @RequestMapping("/ware/purchase/info/{id}")
    public R info(@PathVariable("id") Long id);

    //@RequestMapping("/ware/purchase/save")
    //R save(@RequestBody PurchaseEntity purchase);
    /**
     * 修改
     */
    //@RequestMapping("/ware/purchase/update")
    //R update(@RequestBody PurchaseEntity purchase);

    /**
     * 删除
     */
    @RequestMapping("/ware/purchase/delete")
    R delete(@RequestBody Long[] ids);
}
