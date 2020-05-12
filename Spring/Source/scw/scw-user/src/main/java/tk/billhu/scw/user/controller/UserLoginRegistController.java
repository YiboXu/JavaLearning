package tk.billhu.scw.user.controller;

import com.mysql.cj.x.protobuf.MysqlxDatatypes;
import com.netflix.discovery.converters.Auto;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import tk.billhu.scw.user.component.SmsTemplate;
import tk.billhu.scw.user.entities.TMemberExample;
import tk.billhu.scw.user.entities.TRole;
import tk.billhu.scw.user.mapper.TMemberMapper;
import tk.billhu.scw.user.service.TMemberService;
import tk.billhu.scw.user.vo.request.UserRegisterVo;
import tk.billhu.scw.user.vo.request.UserResetPswVo;
import tk.billhu.scw.user.vo.response.UserLoginVo;
import tk.billhu.scw.user.vo.response.UserResponseVo;
import tk.billhu.scw.vo.resp.AppResponse;

import java.util.*;
import java.util.concurrent.TimeUnit;

@Slf4j
@Api(tags = "用户登陆注册模块")
@RequestMapping("/user")
@RestController
public class UserLoginRegistController {
    @Autowired
    SmsTemplate smsTemplate;

    @Autowired
    StringRedisTemplate stringRedisTemplate;

    @Autowired
    TMemberService tMemberService;

    private static Random random = new Random(37);

    @PostMapping("/login")
    public AppResponse<UserResponseVo> login(String loginacct, String userpswd){
        try {
            //登录验证
            UserResponseVo userResponseVo = tMemberService.login(loginacct, userpswd);

            log.debug("登录成功-{}", userResponseVo);

            return AppResponse.ok(userResponseVo);
        }catch(Exception e){
            e.printStackTrace();
            AppResponse response = AppResponse.fail(null);
            response.setMsg(e.getMessage());
            return response;
        }
    }

    @ApiOperation(value="用户注册")
    @PostMapping("/register")
    public AppResponse<String> register(@RequestBody UserRegisterVo userRegisterVo){

        //检查验证码
        AppResponse response = validate(userRegisterVo.getLoginacct(),userRegisterVo.getCode());
        if(response.getCode() == 0) {
            //如果验证通过, 调用业务层(service)进行用户注册
            try{
                tMemberService.register(userRegisterVo);
            }catch (Exception e){
                //如果注册失败,返回错误
                log.error("注册失败，请重新注册-{}", userRegisterVo);
                return AppResponse.fail("注册失败，请重新注册");
            }
        }else {
            return response;
        }

        return AppResponse.ok("用户注册成功");
    }

    @ApiOperation(value="发送短信验证码")
    @PostMapping("/sendsms")
    public AppResponse<String> sendsms(String loginacct){
        //生成短线验证码
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<4;i++){
            sb.append(random.nextInt(10));
        }

        //缓存短信验证码(有效期5分钟)
        stringRedisTemplate.opsForValue().set(loginacct,sb.toString(),5, TimeUnit.MINUTES);

        //发送短信验证码
        Map<String,String> queries = new HashMap<String,String>();
        queries.put("mobile",loginacct);
        queries.put("param","code:"+sb.toString());
        queries.put("tpl_id","TP1711063");

        smsTemplate.sendSms(queries);

        //DEGUG
        log.info("用户注册短信验证码: "+sb.toString());

        return AppResponse.ok(sb.toString());
    }

    @ApiOperation(value="验证短信验证码")
    @PostMapping("/validate")
    public AppResponse<Object> validate(String loginacct, String inputCode){
        String code = stringRedisTemplate.opsForValue().get(loginacct);
        if(!StringUtils.isEmpty(code)){
            if(code.equals(inputCode)){
                //如果验证通过, 删除验证码缓存
                stringRedisTemplate.delete(loginacct);
            }else{
                //如果验证失败, 返回错误
                log.error("验证码不匹配-{}",loginacct);
                return AppResponse.fail("验证码不匹配");
            }
        }else{
            //如果验证失败, 返回错误
            log.error("验证码过期,请重新获取-{}",loginacct);
            return AppResponse.fail("验证码过期,请重新获取");
        }

        return AppResponse.ok("ok");
    }

    @ApiOperation(value="重置密码")
    @PostMapping("/reset")
    public AppResponse<Object> reset(UserResetPswVo userResetPswVo){
        //检查验证码
        AppResponse response = validate(userResetPswVo.getLoginacct(),userResetPswVo.getCode());
        if(response.getCode() == 0) {
            //如果验证通过, 调用业务层(service)
            try{
                tMemberService.resetPsw(userResetPswVo);
            }catch (Exception e){
                //如果重置密码失败,返回错误
                log.error("密码重置失败-{}", userResetPswVo);
                return AppResponse.fail("注册失败，请重新注册");
            }
        }else {
            return response;
        }

        return AppResponse.ok("用户密码重置成功");
    }

    @ApiOperation(value="获取用户账号信息")
    @PostMapping("/getUserLogin")
    public AppResponse<UserLoginVo> getUserLogin(String loginacct){
        UserLoginVo userLoginVo;

        try{
            userLoginVo = tMemberService.getUserLogin(loginacct);
        }catch (Exception e){
            //如果重置密码失败,返回错误
            log.error("获取账号失败-{}", loginacct);
            AppResponse response = AppResponse.fail(null);
            response.setMsg("获取账号失败");
            return response;
        }

        return AppResponse.ok(userLoginVo);
    }

    @ApiOperation(value="获取登录令牌")
    @PostMapping("/getAccessToken")
    public AppResponse<UserResponseVo> getAccessToken(String loginacct){
        try {
            UserResponseVo userResponseVo = tMemberService.getAccessToken(loginacct);

            log.debug("令牌获取成功-{}", userResponseVo);

            return AppResponse.ok(userResponseVo);
        }catch(Exception e){
            e.printStackTrace();
            AppResponse response = AppResponse.fail(null);
            response.setMsg(e.getMessage());
            return response;
        }
    }

    @ApiOperation(value="获取管理员账号信息")
    @PostMapping("/getAdminLogin")
    public AppResponse<UserLoginVo> getAdminLogin(String loginacct){
        UserLoginVo userLoginVo;

        try{
            userLoginVo = tMemberService.getAdminLogin(loginacct);
        }catch (Exception e){
            //如果重置密码失败,返回错误
            log.error("获取管理员账号失败-{}", loginacct);
            AppResponse response = AppResponse.fail(null);
            response.setMsg("获取管理员账号失败");
            return response;
        }

        return AppResponse.ok(userLoginVo);
    }

    @ApiOperation(value="获取管理员账号角色信息")
    @PostMapping("/getAdminRoles")
    public AppResponse<List<TRole>> getAdminRoles(String loginacct){
        List<TRole> roleList = new ArrayList<>();

        try{
            roleList = tMemberService.getAdminRoles(loginacct);
        }catch (Exception e){
            //如果重置密码失败,返回错误
            log.error("获取管理员角色失败-{}", loginacct);
            AppResponse response = AppResponse.fail(null);
            response.setMsg("获取管理员角色失败");
            return response;
        }

        return AppResponse.ok(roleList);
    }
}
