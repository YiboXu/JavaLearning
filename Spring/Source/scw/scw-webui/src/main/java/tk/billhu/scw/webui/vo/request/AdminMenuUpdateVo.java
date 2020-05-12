package tk.billhu.scw.webui.vo.request;

import lombok.Data;

@Data
public class AdminMenuUpdateVo {
    private Integer id;

    private Integer pid;

    private String name;

    private String icon;

    private String url;
}
