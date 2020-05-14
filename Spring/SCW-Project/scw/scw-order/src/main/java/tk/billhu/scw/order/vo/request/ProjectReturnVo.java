package tk.billhu.scw.order.vo.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
@ApiModel
public class ProjectReturnVo extends BaseVo {

    @ApiModelProperty("项目token")
    private String projectToken;

    @ApiModelProperty("回报类型")
    private String type;

    @ApiModelProperty("支持金额")
    private Integer supportmoney;

    @ApiModelProperty("回报内容")
    private String content;

    @ApiModelProperty("回报数量")
    private Integer count;

    @ApiModelProperty("单笔限购数量  0 - 不限购  n - 限购数量")
    private Integer signalpurchase;

    @ApiModelProperty("限购数量")
    private Integer purchase;

    @ApiModelProperty("运费")
    private Integer freight;

    @ApiModelProperty("发票 0 - 不可开发票  1 - 可开发票")
    private String invoice;

    @ApiModelProperty("回报时间")
    private Integer rtndate;
}
