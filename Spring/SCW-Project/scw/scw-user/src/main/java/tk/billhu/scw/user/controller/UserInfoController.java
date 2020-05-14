package tk.billhu.scw.user.controller;

import java.util.ArrayList;
import java.util.List;

import com.github.pagehelper.PageInfo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import tk.billhu.scw.enums.UserExceptionEnum;
import tk.billhu.scw.user.entities.TMember;
import tk.billhu.scw.user.entities.TOrder;
import tk.billhu.scw.user.exception.UserException;
import tk.billhu.scw.user.mapper.TMemberMapper;
import tk.billhu.scw.user.service.TMemberService;
import tk.billhu.scw.user.vo.request.*;
import tk.billhu.scw.user.vo.response.*;
import tk.billhu.scw.vo.resp.AppResponse;


@Api(tags = "用户个人信息模块")
@RequestMapping("/user/info")
@RestController
@Slf4j
public class UserInfoController {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Autowired
    private TMemberMapper tMemberMapper;

    @Autowired
    private TMemberService tMemberService;

    @ApiOperation(value="获取个人信息")
    @ApiImplicitParams(value={
            @ApiImplicitParam(value="访问令牌",name="accessToken",required=true)
    })
    @GetMapping("/")
    public AppResponse<UserDetailVo> info(String accessToken){
        try {
            UserDetailVo userDetailVo = tMemberService.getUserDetail(accessToken);
            //返回UserDetailVo
            return AppResponse.ok(userDetailVo);
        }catch (Exception e){
            e.printStackTrace();
            log.error("获取用户信息异常-{}",accessToken);
            AppResponse response = AppResponse.fail(null);
            response.setMsg("获取用户信息异常");
            return response;
        }
    }

    @ApiOperation(value="更新个人信息")
    @PostMapping("/")
    public AppResponse<Object> updateInfo(UserUpdateVo updateVo){
        try{
            tMemberService.updateUserDetail(updateVo);
        }catch (Exception e){
            e.printStackTrace();
            log.error("用户详细信息更新异常-{}",updateVo.getAccessToken());
            AppResponse response = AppResponse.fail(null);
            response.setMsg("用户详细信息更新异常");
            return response;
        }

        return AppResponse.ok(updateVo);
    }

    @ApiOperation(value="获取我支持的项目")
    @ApiImplicitParams(value={
            @ApiImplicitParam(value="访问令牌",name="accessToken",required=true)
    })
    @GetMapping("/support/project")
    public AppResponse<List<UserProjectVo>> support(String accessToken){
        List<UserProjectVo> list;

        try{
            list = tMemberService.getUserSupportProjectList(accessToken);
        }catch (Exception e){
            e.printStackTrace();
            log.error("获取用户支持项目信息异常-{}",accessToken);
            AppResponse response = AppResponse.fail(null);
            response.setMsg("获取用户支持项目信息异常");
            return response;
        }

        return AppResponse.ok(list);
    }

    @ApiOperation(value="获取我关注的项目")
    @ApiImplicitParams(value={
            @ApiImplicitParam(value="访问令牌",name="accessToken",required=true)
    })
    @GetMapping("/star/project")
    public AppResponse<List<UserProjectVo>> star(String accessToken){

        List<UserProjectVo> list;

        try{
            list = tMemberService.getUserFollowedProjectList(accessToken);
        }catch (Exception e){
            e.printStackTrace();
            log.error("获取用户关注项目信息异常-{}",accessToken);
            AppResponse response = AppResponse.fail(null);
            response.setMsg("获取用户关注项目信息异常");
            return response;
        }

        return AppResponse.ok(list);
    }

    @ApiOperation(value="获取我发起的项目")
    @ApiImplicitParams(value={
            @ApiImplicitParam(value="访问令牌",name="accessToken",required=true)
    })
    @GetMapping("/create/project")
    public AppResponse<List<UserProjectVo>> create(String accessToken){

        List<UserProjectVo> list;

        try{
            list = tMemberService.getUserStartProjectList(accessToken);
        }catch (Exception e){
            e.printStackTrace();
            log.error("获取用户发起项目信息异常-{}",accessToken);
            AppResponse response = AppResponse.fail(null);
            response.setMsg("获取用户发起项目信息异常");
            return response;
        }

        return AppResponse.ok(list);
    }

    @ApiOperation(value="获取用户收货地址")
    @ApiImplicitParams(value={
            @ApiImplicitParam(value="访问令牌",name="accessToken",required=true)
    })
    @GetMapping("/getAddress")
    public AppResponse<List<UserAddressVo>> address(String accessToken){
        List<UserAddressVo> list;

        try{
            list = tMemberService.getUserAddressList(accessToken);
        }catch (Exception e){
            e.printStackTrace();
            log.error("获取用户收货地址信息异常-{}",accessToken);
            AppResponse response = AppResponse.fail(null);
            response.setMsg("获取用户收货地址信息异常");
            return response;
        }

        return AppResponse.ok(list);
    }

    @ApiOperation(value="新增用户收货地址")
    @PostMapping("/addAddress")
    public AppResponse<Object> addAddress(String accessToken, UserAddressAddVo addressAddVo){
        try{
            tMemberService.addUserAddress(accessToken, addressAddVo);
        }catch (Exception e){
            e.printStackTrace();
            log.error("新增用户收货地址信息异常-{}",accessToken);
            AppResponse response = AppResponse.fail(null);
            response.setMsg("新增用户收货地址信息异常");
            return response;
        }

        return AppResponse.ok(addressAddVo);
    }

    @ApiOperation(value="修改用户收货地址")
    @PutMapping("/address")
    public AppResponse<Object> updateAddress(String accessToken, UserAddressUpdateVo updateAddressVo){
        try{
            tMemberService.updateUserAddress(accessToken, updateAddressVo);
        }catch (Exception e){
            e.printStackTrace();
            log.error("修改用户收货地址信息异常-{}",accessToken);
            AppResponse response = AppResponse.fail(null);
            response.setMsg("修改用户收货地址信息异常");
            return response;
        }

        return AppResponse.ok(updateAddressVo);
    }

    @ApiOperation(value="删除用户收货地址")
    @DeleteMapping("/address")
    public AppResponse<Object> deleteAddress(String accessToken, UserAddressDeleteVo userAddressDeleteVo){
        try{
            tMemberService.deleteUserAddress(accessToken, userAddressDeleteVo);
        }catch (Exception e){
            e.printStackTrace();
            log.error("删除用户收货地址信息异常-{}",accessToken);
            AppResponse response = AppResponse.fail(null);
            response.setMsg("删除用户收货地址信息异常");
            return response;
        }

        return AppResponse.ok(userAddressDeleteVo);
    }

    @ApiOperation(value="查看我的订单")
    @GetMapping("/order")
    public AppResponse<List<UserOrderVo>> order(String accessToken){

        List<UserOrderVo> list;

        try{
            list = tMemberService.getUserOrderList(accessToken);
        }catch (Exception e){
            e.printStackTrace();
            log.error("获取用户订单信息异常-{}",accessToken);
            AppResponse response = AppResponse.fail(null);
            response.setMsg("获取用户订单信息异常");
            return response;
        }

        return AppResponse.ok(list);
    }

    @ApiOperation(value="删除我的订单")
    @DeleteMapping("/order")
    public AppResponse<Object> deleteOrder(String accessToken, UserDeleteOrderVo userDeleteOrderVo){
        try{
            tMemberService.deleteUserOrder(accessToken, userDeleteOrderVo);
        }catch (Exception e){
            e.printStackTrace();
            log.error("删除用户订单信息异常-{}",accessToken);
            AppResponse response = AppResponse.fail(null);
            response.setMsg("删除用户订单信息异常");
            return response;
        }

        return AppResponse.ok(userDeleteOrderVo);
    }
}
