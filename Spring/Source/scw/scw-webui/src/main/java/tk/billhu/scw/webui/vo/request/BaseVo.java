package tk.billhu.scw.webui.vo.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.ToString;

@ToString
@Data
@ApiModel
public class BaseVo {

    @ApiModelProperty("登录令牌")
    private String accessToken;
}
