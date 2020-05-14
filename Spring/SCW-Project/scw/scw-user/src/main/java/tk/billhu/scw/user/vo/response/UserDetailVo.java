package tk.billhu.scw.user.vo.response;

import io.swagger.annotations.ApiModel;
import lombok.Data;

@Data
@ApiModel
public class UserDetailVo {

    private String loginacct;

    private String username;

    private String email;

    private String authstatus;

    private String usertype;

    private String realname;

    private String cardnum;

    private String accttype;
}
