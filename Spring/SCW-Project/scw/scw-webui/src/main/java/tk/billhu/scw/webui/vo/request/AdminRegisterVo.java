package tk.billhu.scw.webui.vo.request;

import lombok.Data;

@Data
public class AdminRegisterVo {
    private Integer id;

    private String loginacct;

    private String userpswd;

    private String username;

    private String email;

    private String createtime;
}
