package tk.billhu.scw.webui.vo.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AdminPermissionRegisterVo {
    private Integer id;

    private String name;

    private String title;

    private String icon;

    private Integer pid;
}
