package tk.springlearning.springcloud.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import tk.springlearning.springcloud.domain.CommonResult;

@Mapper
public interface StorageDao {
    public void decrease(@Param("productId") Long productId, @Param("count") Integer count);
}
