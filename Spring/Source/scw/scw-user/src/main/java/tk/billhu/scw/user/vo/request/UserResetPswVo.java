package tk.billhu.scw.user.vo.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@ApiModel
@Data
public class UserResetPswVo {

    @ApiModelProperty("手机号")
    private String loginacct;

    @ApiModelProperty("验证码")
    private String code;

    @ApiModelProperty("新密码")
    private String password;
}
