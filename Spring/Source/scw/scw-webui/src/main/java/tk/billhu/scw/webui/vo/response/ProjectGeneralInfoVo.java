package tk.billhu.scw.webui.vo.response;

import lombok.Data;

import java.io.Serializable;

@Data
public class ProjectGeneralInfoVo implements Serializable {
    private Integer id;

    private String name;

    private String remark;

    private Long money;

    private Integer day;

    private String status;

    private String deploydate;

    private Long supportmoney;

    private Integer supporter;

    private Integer completion;

    private Integer memberid;

    private String createdate;

    private Integer follower;

    private String headerImage;
}
