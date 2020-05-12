package tk.billhu.scw.project.vo.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
@ApiModel
public class ProjectLegalVo extends BaseVo {

    @ApiModelProperty("项目token")
    private String projectToken;   //项目的临时token

    @ApiModelProperty("法人企业账号")
    private String account;

    @ApiModelProperty("法人身份证号")
    private String cardnum;
}
