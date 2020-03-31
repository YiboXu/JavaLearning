package tk.springlearning.springcloud.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import tk.springlearning.springcloud.domain.CommonResult;

@FeignClient(value = "seata-storage-service")
public interface StorageService {
    @PostMapping("/storage/decrease")
    //@RequestParam对应http://localhost:2001/storage/decrease?produceId=1&count=10
    //PathVariable对应http://localhost:2001/storage/decrease/1/10
    CommonResult decrease(@RequestParam("productId") Long productId, @RequestParam("count") Integer count);
}
