package tk.billhu.scw.webui.vo.response;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

@Data
public class ReturnPayConfirmVo implements Serializable {
    /**
     * t_project
     */
    private String projectId;

    private String projectName;

    private String remark;

    /**
     * t_member
     */
    private Integer memberid;

    private String memberName;

    /**
     * t_return
     */
    private String returnId;

    private String content;

    private Integer num; //数量

    private Integer price; //单价

    private Integer signalpurchase;  //单笔限购数量

    private Integer freight;  //运费

    private BigDecimal totalPrice; //总价totalPrice = price * num + freight
}
