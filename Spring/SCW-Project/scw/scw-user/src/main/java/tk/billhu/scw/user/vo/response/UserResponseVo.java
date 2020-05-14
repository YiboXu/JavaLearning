package tk.billhu.scw.user.vo.response;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel
public class UserResponseVo {
    @ApiModelProperty("访问令牌")
    //登录后会分配给当前用户一个临时令牌. 以后对系统的任何访问必须携带这个令牌, 否则, 拒绝访问, 必须去登录。
    private String accessToken;

    private String loginacct;

    private String username;

    private String email;

    private String authstatus;

    private String usertype;

    private String realname;

    private String cardnum;

    private String accttype;
}
