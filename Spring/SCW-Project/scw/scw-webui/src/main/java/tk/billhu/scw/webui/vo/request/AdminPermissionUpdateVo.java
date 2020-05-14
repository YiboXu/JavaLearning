package tk.billhu.scw.webui.vo.request;

import lombok.Data;

@Data
public class AdminPermissionUpdateVo {
    private Integer id;

    private String name;

    private String title;

    private String icon;

    private Integer pid;
}
