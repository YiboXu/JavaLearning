package tk.billhu.scw.webui.vo.response;

import lombok.Data;
import lombok.ToString;
import tk.billhu.scw.webui.entities.TReturn;
import tk.billhu.scw.webui.vo.request.BaseVo;

import java.util.List;

@Data
@ToString
public class ProjectRedisStorageVo extends BaseVo {

    private String projectToken;   //项目的临时token

    /**
     * t_project_type
     */
    private List<Integer> typeIds; //项目的分类id

    /**
     * t_project_tag
     */
    private List<Integer> tagIds;  //项目的标签id

    /**
     * t_project
     */
    private String name;

    private String remark;

    private Long money;

    private Integer day;

    /**
     * t_project_images
     */
    private String headerImage;     //项目头部图片

    private List<String> detailsImage;   //项目详情图片

    /**
     * t_project_initiator
     */

    private String selfintroduction;

    private String detailselfintroduction;

    private String telphone;

    private String hotline;

    /**
     * t_return
     */

    private List<TReturn> projectReturns; //项目回报

    /**
     * t_project_legal
     */
    private String account;   //用于收款的企业账号

    private String cardnum;   //法人身份证号
}
