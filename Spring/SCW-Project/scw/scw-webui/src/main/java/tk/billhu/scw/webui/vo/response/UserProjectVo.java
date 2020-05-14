package tk.billhu.scw.webui.vo.response;

import lombok.Data;

@Data
public class UserProjectVo {

    /**
     * t_order
     */
    private Integer memberid;

    private Integer projectid;

    private Integer returnid;

    private String ordernum;

    private String createdate;

    private Integer money;

    private Integer rtncount;

    private String status;

    private String address;

    private String invoice;

    private String invoictitle;

    private String remark;

    /**
     * t_project
     */
    private String name;

    private Integer day;

    private String deploydate;

    private Long supportmoney;

    private Integer supporter;

    private Integer completion;

    private Integer follower;

    private String projectStatus;
}
