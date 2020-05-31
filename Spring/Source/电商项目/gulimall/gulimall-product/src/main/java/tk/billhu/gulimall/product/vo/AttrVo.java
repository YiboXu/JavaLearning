package tk.billhu.gulimall.product.vo;

import lombok.Data;
import tk.billhu.gulimall.product.entity.AttrEntity;

import java.io.Serializable;

@Data
public class AttrVo extends AttrEntity {

    /**
     * 所属分组
     */
    private Long attrGroupId;
}
