package tk.billhu.scw.user.vo.request;

import io.swagger.annotations.ApiModel;
import lombok.Data;

@Data
@ApiModel
public class UserUpdateVo {

    private String accessToken;

    private String username;

    private String email;

    private String realname;

    private String cardnum;

    private String accttype;
}
