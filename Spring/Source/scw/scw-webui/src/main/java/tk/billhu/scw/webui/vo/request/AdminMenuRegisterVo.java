package tk.billhu.scw.webui.vo.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AdminMenuRegisterVo {
    private Integer id;

    private Integer pid;

    private String name;

    private String icon;

    private String url;
}
