package tk.billhu.scw.webui.vo.request;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class OrderSubmitVo {
    private String address;

    private String invoice;

    private String invoictitle;

    private String remark;
}
