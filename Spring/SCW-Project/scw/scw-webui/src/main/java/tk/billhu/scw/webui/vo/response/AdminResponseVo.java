package tk.billhu.scw.webui.vo.response;

import lombok.Data;

@Data
public class AdminResponseVo {
    private Integer id;

    private String loginacct;

    private String username;

    private String email;

    private String createtime;
}
