package tk.billhu.scw.webui.vo.response;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class AdminPermissionVo {
    private Integer id;

    private String name;

    private String title;

    private String icon;

    private Integer pid;

    private List<AdminPermissionVo> children = new ArrayList();
}
