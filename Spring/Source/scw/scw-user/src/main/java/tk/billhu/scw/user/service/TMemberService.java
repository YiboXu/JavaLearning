package tk.billhu.scw.user.service;

import com.github.pagehelper.PageInfo;
import tk.billhu.scw.user.entities.TOrder;
import tk.billhu.scw.user.entities.TRole;
import tk.billhu.scw.user.vo.request.*;
import tk.billhu.scw.user.vo.response.*;

import java.util.List;

public interface TMemberService {
    int register(UserRegisterVo userRegisterVo);

    UserResponseVo login(String loginacct, String password);

    int resetPsw(UserResetPswVo userResetPswVo);

    UserDetailVo getUserDetail(String accessToken);

    UserUpdateVo updateUserDetail(UserUpdateVo updateVo);

    List<UserProjectVo> getUserSupportProjectList(String accessToken);

    List<UserProjectVo> getUserFollowedProjectList(String accessToken);

    List<UserProjectVo> getUserStartProjectList(String accessToken);

    List<UserAddressVo> getUserAddressList(String accessToken);

    int addUserAddress(String accessToken, UserAddressAddVo addressAddVo);

    int updateUserAddress(String accessToken, UserAddressUpdateVo updateAddressVo);

    int deleteUserAddress(String accessToken, UserAddressDeleteVo userAddressDeleteVo);

    List<UserOrderVo> getUserOrderList(String accessToken);

    int deleteUserOrder(String accessToken, UserDeleteOrderVo userDeleteOrderVo);

    UserLoginVo getUserLogin(String username);

    UserResponseVo getAccessToken(String loginacct);

    UserLoginVo getAdminLogin(String username);

    PageInfo<UserResponseVo> getAllUser(int pageNum, int pageSize);

    List<TRole> getAdminRoles(String loginacct);
}
