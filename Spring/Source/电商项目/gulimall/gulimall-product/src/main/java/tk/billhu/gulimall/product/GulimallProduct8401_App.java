package tk.billhu.gulimall.product;

import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import tk.billhu.gulimall.common.valid.AddGroup;

/**
 * 1. 逻辑删除
 * - 配置mybatis-plus
 * mybatis-plus:
 *   global-config:
 *     db-config:
 *       #指定逻辑删除value, 具体哪个字段用来做逻辑删除, 需要在对应的Entity类的字段上添加@TableLogic
 *       logic-delete-value: 1
 *       logic-not-delete-value: 0
 *
 * - 给Bean加上逻辑产出注解@TableLogic
 *  由于和application.yml里面定义的全局逻辑删除值相反，所以这里通过value和delval对表示删除状态值进行重置
 *  @TableLogic(value = "1", delval = "0")
 * 	private Integer showStatus;
 *
 * 	2. JSR303
 * 	- 在需要检验的Bean上添加检验注解, 并添加自定义错误提示
 *  @NotBlank(message = "品牌名不能为空")         //不能为null和去掉首尾空格后长度为0的字符串
 * 	private String name;
 *  @NotBlank
 *  @URL(message = "logo地址必须是合法的URL地址")
 * 	private String logo;
 *  @NotBlank
 *  @Pattern(regexp = "^[a-zA-Z]$")
 * 	private String firstLetter;
 *  @NotNull                                    //不能为null, 但是可以为长度为0的字符串
 *  @Min(value= 0, message = "显示状态不合法 0-不显示；1-显示")
 * 	private Integer sort;
 *
 * 	- 开启校验功能
 *  @RequestMapping("/save")
 *  public R save(@Valid @RequestBody BrandEntity brand, BindingResult bindingResult){...}
 * 	- 给校验的Bean后面紧跟一个BindingResult, 就可以获取到校验的结果, 从而可以自定义返回结果
 *     @RequestMapping("/save")
 *     public R save(@Valid @RequestBody BrandEntity brand, BindingResult bindingResult){
 *         if(bindingResult.hasErrors()){
 *             Map<String,String> resultMap = new HashMap<>();
 *             bindingResult.getFieldErrors().forEach(fieldError -> {
 *                 resultMap.put(fieldError.getField(),fieldError.getDefaultMessage());
 *             });
 *
 *             return R.error("保存商品品牌失败").put("data",resultMap);
 *         }else{
 *             brandService.save(brand);
 *         }
 *
 *         return R.ok();
 *     }
 *  - 校验分组
 *     针对不同的操作，比如新增，修改，删除需要有不同的验证规则
 *     - 创建空接口作为分组 (tk.billhu.gulimall.common.valid.AddGroup, tk.billhu.gulimall.common.valid.UpdateGroup)
 *     - 在指定校验规则的时候添加分组信息
 *       @NotNull(message = "检索首字母不能为null", groups = {AddGroup.class})  //新增时不能为N    l
 * 	     @Pattern(regexp = "^[a-zA-Z]$", message = "非法检索首字符", groups = {AddGroup.class, UpdateGroup.class})
 * 	     private String firstLetter;
 *     - 在controller添加所属分组
 *           @RequestMapping("/save")
 *           public R save(@Validated(AddGroup.class) @RequestBody BrandEntity brand){...}
 *           @RequestMapping("/update")
 *           public R update(@Validated(UpdateGroup.class) @RequestBody BrandEntity brand){...}
 *     - 注意: 没有分组的校验规则,比如@NotNull, 对于添加进分组的controller, 比如@Validated(AddGroup.class), 不生效,
 *            但是如果controller中添加的是@Validated, 没有分组信息是会生效的
 *
 *  - 自定义校验注解
 *    - 添加依赖
 *     <dependency>
 *        <groupId>javax.validation</groupId>
 *        <artifactId>validation-api</artifactId>
 *     </dependency>
 *    - 创建注解 (参考tk.billhu.gulimall.common.valid.ListValue)
 *    - 创建注解验证器 (参考 tk.billhu.gulimall.common.valid.ListValueConstraintValidator
 *    - 使用注解
 *      @ListValue(value={0,1},groups={AddGroup.class,UpdateGroup.class})
 * 	    private Integer showStatus;
 *
 *  3. 全局统一的异常处理
 *  - 定义错误代码枚举类型 (tk.billhu.gulimall.common.exception.BizCodeEnum)
 *  - controller里面不处理异常, 发现异常直接抛出
 *  - 创建ControllerAdvice来统一处理异常 (tk.billhu.gulimall.product.exception.GulimallExceptionControllerAdvice)
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableTransactionManagement
//指定OpenFeign接口所在的包，如果不指定，就从当前包下查找
@EnableFeignClients(basePackages = "tk.billhu.gulimall.common.service")
public class GulimallProduct8401_App {
    public static void main(String[] args) {
        SpringApplication.run(GulimallProduct8401_App.class,args);
    }

    //Mybatis-Plus 分页插件
    @Bean
    public PaginationInterceptor paginationInterceptor(){
        return new PaginationInterceptor();
    }
}
