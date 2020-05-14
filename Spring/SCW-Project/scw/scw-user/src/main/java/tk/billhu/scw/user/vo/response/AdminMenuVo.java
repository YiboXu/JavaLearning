package tk.billhu.scw.user.vo.response;

import lombok.Data;

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
