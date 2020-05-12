package tk.billhu.scw.webui.vo.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Data
public class AdminMenuVo implements Serializable {
    private Integer id;

    private Integer pid;

    private String name;

    private String icon;

    private String url;

    private List<AdminMenuVo> childMenu = new ArrayList();
}
