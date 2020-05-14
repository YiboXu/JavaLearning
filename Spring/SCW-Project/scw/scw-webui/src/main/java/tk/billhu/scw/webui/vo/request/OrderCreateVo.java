package tk.billhu.scw.webui.vo.request;

import lombok.Data;

@Data
public class OrderCreateVo {

    private String accessToken;

    private Integer projectid;

    private Integer returnid;

    private Integer rtncount;

    private String address;

    private String invoice;

    private String invoictitle;

    private String remark;
}
