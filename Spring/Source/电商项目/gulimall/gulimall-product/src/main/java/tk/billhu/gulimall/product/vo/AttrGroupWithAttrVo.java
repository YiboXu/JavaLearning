package tk.billhu.gulimall.product.vo;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import tk.billhu.gulimall.product.entity.AttrEntity;
import tk.billhu.gulimall.product.entity.AttrGroupEntity;

import java.util.List;

@Data
public class AttrGroupWithAttrVo {
    /**
     * 分组id
     */
    @TableId
    private Long attrGroupId;
    /**
     * 组名
     */
    private String attrGroupName;
    /**
     * 排序
     */
    private Integer sort;
    /**
     * 描述
     */
    private String descript;
    /**
     * 组图标
     */
    private String icon;
    /**
     * 所属分类id
     */
    private Long catelogId;

    /**
     * 属性列表
     */
    private List<AttrEntity> attrs;
}
