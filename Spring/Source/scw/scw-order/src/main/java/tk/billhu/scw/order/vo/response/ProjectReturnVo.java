package tk.billhu.scw.order.vo.response;

import lombok.Data;

@Data
public class ProjectReturnVo {
    private Integer id;

    private Integer projectid;

    private String type;

    private Integer supportmoney;

    private String content;

    private Integer count;

    private Integer signalpurchase;

    private Integer purchase;

    private Integer freight;

    private String invoice;

    private Integer rtndate;

}
