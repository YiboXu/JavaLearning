package tk.billhu.gulimall.product.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;
import org.apache.ibatis.annotations.Update;
import org.hibernate.validator.constraints.URL;
import tk.billhu.gulimall.common.valid.AddGroup;
import tk.billhu.gulimall.common.valid.DeleteGroup;
import tk.billhu.gulimall.common.valid.ListValue;
import tk.billhu.gulimall.common.valid.UpdateGroup;

import javax.validation.constraints.*;

/**
 * 品牌
 * 
 * @author billhu
 * @email billtt@163.com
 * @date 2020-05-19 17:23:08
 */

/**
 *     @NotNull 验证对象是否不为null, 无法查检长度为0的字符串
 *     @NotBlank 检查约束 (字符串) 是不是Null还有被Trim的长度是否大于0,只对字符串,且会去掉前后空格.
 *     @NotEmpty 检查(集合)约束元素是否为NULL或者是EMPTY.
 */
@Data
@TableName("pms_brand")
public class BrandEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 品牌id
	 */
	@TableId
	@Null(message = "品牌ID必须为空", groups = {AddGroup.class})   //新增时brandId必须为null
	@NotNull(message = "品牌ID不能为空", groups = {UpdateGroup.class, DeleteGroup.class})  //更新和删除时brandId不能为空
	private Long brandId;
	/**
	 * 品牌名
	 */
	@NotNull(message = "品牌名不能为Null", groups = {AddGroup.class})  //新增时不能为Null
	@Pattern(regexp=".*$",message="非法品牌名",groups={AddGroup.class,UpdateGroup.class})
	private String name;
	/**
	 * 品牌logo地址
	 */
	@NotBlank (message = "logo不能为Null", groups = {AddGroup.class})  //新增时logo不能为空
	@URL(message = "logo地址必须是合法的URL地址", groups = {AddGroup.class, UpdateGroup.class})  //新增和修改时必须时合法的URL
	private String logo;
	/**
	 * 介绍
	 */
	@NotNull(message = "品牌介绍不能为Null", groups = {AddGroup.class})  //新增时不能为Null
	@Pattern(regexp=".*$",message="非法品牌介绍",groups={AddGroup.class,UpdateGroup.class}) //新增和修改时不能为长度是0的字符串
	private String descript;
	/**
	 * 显示状态[0-不显示；1-显示]
	 */
	/**
	 * 是否显示[0-不显示，1显示]
	 * 由于和application.yml里面定义的全局逻辑删除值相反，所以这里通过value和delval对表示删除状态值进行重置
	 * logic-delete-value: 1
	 * logic-not-delete-value: 0
	 */
	//@TableLogic(value = "1", delval = "0")
	@NotNull(message = "显示状态不能为Null",groups = {AddGroup.class})
	//@Min(value=0,message="非法显示状态值",groups={AddGroup.class, UpdateGroup.class})
	//@Max(value=1,message="非法显示状态值",groups={AddGroup.class, UpdateGroup.class})
	@ListValue(value={0,1},groups={AddGroup.class,UpdateGroup.class})
	private Integer showStatus;
	/**
	 * 检索首字母
	 */
	@NotNull(message = "检索首字母不能为null", groups = {AddGroup.class})  //新增时不能为Null
	@Pattern(regexp = "^[a-zA-Z]$", message = "非法检索首字符", groups = {AddGroup.class, UpdateGroup.class})
	private String firstLetter;
	/**
	 * 排序
	 */
	@NotNull(message = "排序值不能为null", groups = {AddGroup.class})
	@Min(value= 0, message = "显示状态不合法 0-不显示；1-显示", groups = {AddGroup.class, UpdateGroup.class})
	private Integer sort;

}
