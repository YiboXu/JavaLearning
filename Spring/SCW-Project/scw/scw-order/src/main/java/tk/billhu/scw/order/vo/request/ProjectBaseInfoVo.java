package tk.billhu.scw.order.vo.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.ToString;

import java.util.List;

@Data
@ToString
@ApiModel
public class ProjectBaseInfoVo extends BaseVo {

    @ApiModelProperty("项目token")
    private String projectToken;   //项目的临时token

    /**
     * t_project_type
     */
    @ApiModelProperty("项目所属类别")
    private List<Integer> typeIds; //项目的分类id

    /**
     * t_project_tag
     */
    @ApiModelProperty("标签")
    private List<Integer> tagIds;  //项目的标签id

    /**
     * t_project
     */
    @ApiModelProperty("名称")
    private String name;

    @ApiModelProperty("一句话简介")
    private String remark;

    @ApiModelProperty("筹资金额")
    private Long money;

    @ApiModelProperty("项目天数")
    private Integer day;

    /**
     * t_project_images
     */
    @ApiModelProperty("头部图片")
    private String headerImage;     //项目头部图片

    @ApiModelProperty("详情图片")
    private List<String> detailsImage;   //项目详情图片

    /**
     * t_project_initiator
     */

    @ApiModelProperty("项目发起人简介")
    private String selfintroduction;

    @ApiModelProperty("项目发起人详细介绍")
    private String detailselfintroduction;

    @ApiModelProperty("项目发起人电话")
    private String telphone;

    @ApiModelProperty("客服电话")
    private String hotline;
}
