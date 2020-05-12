package tk.billhu.scw.user.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.github.pagehelper.PageSerializable;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;
import tk.billhu.scw.enums.AuthEnume;
import tk.billhu.scw.enums.UserExceptionEnum;
import tk.billhu.scw.user.entities.*;
import tk.billhu.scw.user.exception.UserException;
import tk.billhu.scw.user.mapper.*;
import tk.billhu.scw.user.service.TMemberService;
import tk.billhu.scw.user.vo.request.*;
import tk.billhu.scw.user.vo.response.*;
import tk.billhu.scw.vo.resp.AppResponse;

import java.util.*;

@Service
@Slf4j
@Transactional(readOnly = true)
public class TMemberServiceImpl implements TMemberService {
    private static BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

    @Autowired
    private TMemberMapper tMemberMapper;

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Autowired
    private TOrderMapper tOrderMapper;

    @Autowired
    private TProjectMapper tProjectMapper;

    @Autowired
    private TMemberProjectFollowMapper tMemberProjectFollowMapper;

    @Autowired
    private TMemberAddressMapper tMemberAddressMapper;

    @Autowired
    private TAdminMapper tAdminMapper;

    @Autowired
    private TAdminRoleMapper tAdminRoleMapper;

    @Autowired
    private TRoleMapper tRoleMapper;

    @Autowired
    private TMenuMapper tMenuMapper;

    @Override
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.REPEATABLE_READ, rollbackFor = Exception.class)
    public int register(UserRegisterVo userRegisterVo) {
        //验证手机号和邮箱是否被使用过
        if(checkExist(userRegisterVo.getLoginacct(),userRegisterVo.getEmail())){
            log.error("注册会员失败, 手机号或邮箱被占用-{}-{}",userRegisterVo.getLoginacct(),userRegisterVo.getEmail());
            throw new UserException(UserExceptionEnum.USER_REGISTERED);
        }

        try{
            //注册用户
            TMember tMember = new TMember();
            BeanUtils.copyProperties(userRegisterVo, tMember);
            tMember.setUsername(userRegisterVo.getLoginacct());
            tMember.setAuthstatus(AuthEnume.UN_AUTH.getCode() + "");

            //密码加密
            String password = userRegisterVo.getUserpswd();
            tMember.setUserpswd(encoder.encode(password));

            int n = tMemberMapper.insert(tMember);
            if(n == 1) {
                log.debug("注册用户成功-{}", tMember);
            }else{
                throw new Exception("保存结果多余一条记录");
            }

            return n;
        }catch(Exception e){
            log.error("注册会员失败-{}",e.getMessage());
            throw new UserException(UserExceptionEnum.SAVE_ERROR);
        }
    }

    @Override
    public UserResponseVo login(String loginacct, String password) {
        TMemberExample tMemberExample = new TMemberExample();

        tMemberExample.createCriteria().andLoginacctEqualTo(loginacct);

        List<TMember> result = tMemberMapper.selectByExample(tMemberExample);

        if(result != null && result.size() > 0) {
            if(encoder.matches(password,result.get(0).getUserpswd())) {
                //验证通过
                UserResponseVo userResponseVo = new UserResponseVo();
                BeanUtils.copyProperties(result.get(0), userResponseVo);
                //生成令牌
                String token = UUID.randomUUID().toString().replace("-", "");
                userResponseVo.setAccessToken(token);
                //缓存令牌
                stringRedisTemplate.opsForValue().set(token, result.get(0).getId().toString());

                return userResponseVo;
            }else{
                throw new UserException(UserExceptionEnum.USER_PASSWORD_ERROR);
            }
        }else{
            throw new UserException(UserExceptionEnum.USER_UNEXIST);
        }
    }

    /**
     * 检验手机号或邮箱是否被注册使用过
     * @param loginacct
     * @return
     */
    private boolean checkExist(String loginacct) {
        TMemberExample tMemberExample = new TMemberExample();
        tMemberExample.createCriteria().andLoginacctEqualTo(loginacct);

        long n = tMemberMapper.countByExample(tMemberExample);

        return n > 0;
    }

    /**
     * 检验手机号或邮箱是否被注册使用过
     * @param loginacct
     * @param email
     * @return
     */
    private boolean checkExist(String loginacct, String email) {
        TMemberExample tMemberExample = new TMemberExample();
        //这2个条件是 OR 的关系
        //如果需要AND关系，就用tMemberExample.createCriteria().andLoginacctEqualTo(loginacct).andEmailEqualTo(email)
        tMemberExample.createCriteria().andLoginacctEqualTo(loginacct);
        tMemberExample.createCriteria().andEmailEqualTo(email);

        long n = tMemberMapper.countByExample(tMemberExample);

        return n > 0;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.REPEATABLE_READ, rollbackFor = Exception.class)
    public int resetPsw(UserResetPswVo userResetPswVo) {
        //检查用户是否存在
        if(!checkExist(userResetPswVo.getLoginacct())){
            log.error("重置密码失败, 会员不存在-{}",userResetPswVo.getLoginacct());
            throw new UserException(UserExceptionEnum.USER_UNEXIST);
        }

        try {
            //重置密码
            TMemberExample tMemberExample = new TMemberExample();
            tMemberExample.createCriteria().andLoginacctEqualTo(userResetPswVo.getLoginacct());

            TMember tMember = new TMember();
            tMember.setLoginacct(userResetPswVo.getLoginacct());
            tMember.setUserpswd(encoder.encode(userResetPswVo.getPassword()));

            tMemberMapper.updateByExampleSelective(tMember, tMemberExample);
        }catch (Exception e){
            log.debug("重置密码失败-{}",e.getMessage());
            throw new UserException(UserExceptionEnum.SAVE_ERROR);
        }

        return 0;
    }

    @Override
    public UserDetailVo getUserDetail(String accessToken) {
        //通过accessToken获取t_member.id
        String memberId = stringRedisTemplate.opsForValue().get(accessToken);
        if(StringUtils.isEmpty(memberId)){
            throw new UserException(UserExceptionEnum.USER_UNLOGIN);
        }
        //通过t_member.id获取t_member详细信息
        TMember tMember = tMemberMapper.selectByPrimaryKey(Integer.parseInt(memberId));
        //将t_member详细信息复制到UserDetailVo
        UserDetailVo detailVo = new UserDetailVo();
        BeanUtils.copyProperties(tMember,detailVo);

        return detailVo;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.REPEATABLE_READ, rollbackFor = Exception.class)
    public UserUpdateVo updateUserDetail(UserUpdateVo updateVo) {
        //通过accessToken获取t_member.id
        String memberId = stringRedisTemplate.opsForValue().get(updateVo.getAccessToken());
        if(StringUtils.isEmpty(memberId)){
            throw new UserException(UserExceptionEnum.USER_UNLOGIN);
        }
        //通过t_member.id获取t_member详细信息
        TMember tMember = tMemberMapper.selectByPrimaryKey(Integer.parseInt(memberId));
        //将t_member详细信息复制到UserDetailVo
        UserDetailVo detailVo = new UserDetailVo();
        BeanUtils.copyProperties(updateVo,tMember);
        tMemberMapper.updateByPrimaryKey(tMember);

        return updateVo;
    }

    @Override
    public List<UserProjectVo> getUserSupportProjectList(String accessToken) {
        //通过accessToken获取t_member.id
        String memberId = stringRedisTemplate.opsForValue().get(accessToken);
        if(StringUtils.isEmpty(memberId)){
            throw new UserException(UserExceptionEnum.USER_UNLOGIN);
        }

        //获取订单信息
        TOrderExample tOrderExample = new TOrderExample();
        tOrderExample.createCriteria().andMemberidEqualTo(Integer.parseInt(memberId));
        List<TOrder> tOrders = tOrderMapper.selectByExample(tOrderExample);
        //复制订单信息
        List<UserProjectVo> userProjectVoList = new ArrayList<>();

        for(TOrder tOrder : tOrders) {
            UserProjectVo userProjectVo = new UserProjectVo();
            BeanUtils.copyProperties(tOrder,userProjectVo);

            //复制项目信息
            TProject tProject = tProjectMapper.selectByPrimaryKey(tOrder.getProjectid());
            BeanUtils.copyProperties(tProject,userProjectVo);
            userProjectVo.setProjectStatus(tProject.getStatus());
            userProjectVo.setStatus(tOrder.getStatus());
            userProjectVo.setCreatedate(tOrder.getCreatedate());
            userProjectVoList.add(userProjectVo);
        }

        return userProjectVoList;
    }

    @Override
    public List<UserProjectVo> getUserFollowedProjectList(String accessToken) {
        //通过accessToken获取t_member.id
        String memberId = stringRedisTemplate.opsForValue().get(accessToken);
        if(StringUtils.isEmpty(memberId)){
            throw new UserException(UserExceptionEnum.USER_UNLOGIN);
        }

        //获取项目信息
        TMemberProjectFollowExample tMemberProjectFollowExample = new TMemberProjectFollowExample();
        tMemberProjectFollowExample.createCriteria().andMemberidEqualTo(Integer.parseInt(memberId));
        List<TMemberProjectFollow> tMemberProjectFollowList = tMemberProjectFollowMapper.selectByExample(tMemberProjectFollowExample);

        //复制项目信息
        List<UserProjectVo> userProjectVoList = new ArrayList<>();
        for(TMemberProjectFollow tMemberProjectFollow : tMemberProjectFollowList){
            UserProjectVo userProjectVo = new UserProjectVo();
            BeanUtils.copyProperties(tMemberProjectFollow,userProjectVo);
            TProject tProject = tProjectMapper.selectByPrimaryKey(tMemberProjectFollow.getProjectid());
            BeanUtils.copyProperties(tProject,userProjectVo);

            userProjectVo.setProjectStatus(tProject.getStatus());

            userProjectVoList.add(userProjectVo);
        }

        return userProjectVoList;
    }

    @Override
    public List<UserProjectVo> getUserStartProjectList(String accessToken) {
        //通过accessToken获取t_member.id
        String memberId = stringRedisTemplate.opsForValue().get(accessToken);
        if(StringUtils.isEmpty(memberId)){
            throw new UserException(UserExceptionEnum.USER_UNLOGIN);
        }

        //获取项目信息
        TProjectExample tProjectExample = new TProjectExample();
        tProjectExample.createCriteria().andMemberidEqualTo(Integer.parseInt(memberId));
        List<TProject> tProjectList = tProjectMapper.selectByExample(tProjectExample);

        List<UserProjectVo> userProjectVoList = new ArrayList<>();
        for(TProject tProject : tProjectList){
            UserProjectVo userProjectVo = new UserProjectVo();
            BeanUtils.copyProperties(tProject,userProjectVo);

            userProjectVo.setProjectStatus(tProject.getStatus());

            userProjectVoList.add(userProjectVo);
        }

        return userProjectVoList;
    }

    @Override
    public List<UserAddressVo> getUserAddressList(String accessToken) {
        //通过accessToken获取t_member.id
        String memberId = stringRedisTemplate.opsForValue().get(accessToken);
        if(StringUtils.isEmpty(memberId)){
            throw new UserException(UserExceptionEnum.USER_UNLOGIN);
        }

        //获取地址信息
        TMemberAddressExample tMemberAddressExample = new TMemberAddressExample();
        tMemberAddressExample.createCriteria().andMemberidEqualTo(Integer.parseInt(memberId));
        List<TMemberAddress> tMemberAddressList = tMemberAddressMapper.selectByExample(tMemberAddressExample);

        //复制地址信息
        List<UserAddressVo> userAddressVoList = new ArrayList<>();
        for(TMemberAddress tMemberAddress : tMemberAddressList){
            UserAddressVo userAddressVo = new UserAddressVo();
            BeanUtils.copyProperties(tMemberAddress,userAddressVo);
            userAddressVoList.add(userAddressVo);
        }

        return userAddressVoList;
    }

    @Override
    public int addUserAddress(String accessToken, UserAddressAddVo addressAddVo) {
        //通过accessToken获取t_member.id
        String memberId = stringRedisTemplate.opsForValue().get(accessToken);
        if(StringUtils.isEmpty(memberId)){
            throw new UserException(UserExceptionEnum.USER_UNLOGIN);
        }

        addressAddVo.setMemberid(Integer.parseInt(memberId));
        TMemberAddress tMemberAddress = new TMemberAddress();
        BeanUtils.copyProperties(addressAddVo,tMemberAddress);

        return tMemberAddressMapper.insert(tMemberAddress);
    }

    @Override
    public int updateUserAddress(String accessToken, UserAddressUpdateVo updateAddressVo) {
        //通过accessToken获取t_member.id
        String memberId = stringRedisTemplate.opsForValue().get(accessToken);
        if(StringUtils.isEmpty(memberId)){
            throw new UserException(UserExceptionEnum.USER_UNLOGIN);
        }

        TMemberAddress tMemberAddress = new TMemberAddress();
        BeanUtils.copyProperties(updateAddressVo,tMemberAddress);

        return tMemberAddressMapper.updateByPrimaryKeySelective(tMemberAddress);
    }

    @Override
    public int deleteUserAddress(String accessToken, UserAddressDeleteVo userAddressDeleteVo) {
        //通过accessToken获取t_member.id
        String memberId = stringRedisTemplate.opsForValue().get(accessToken);
        if(StringUtils.isEmpty(memberId)){
            throw new UserException(UserExceptionEnum.USER_UNLOGIN);
        }

        return tMemberAddressMapper.deleteByPrimaryKey(userAddressDeleteVo.getId());
    }

    @Override
    public List<UserOrderVo> getUserOrderList(String accessToken) {
        //通过accessToken获取t_member.id
        String memberId = stringRedisTemplate.opsForValue().get(accessToken);
        if(StringUtils.isEmpty(memberId)){
            throw new UserException(UserExceptionEnum.USER_UNLOGIN);
        }

        //获取订单信息
        TOrderExample tOrderExample = new TOrderExample();
        tOrderExample.createCriteria().andMemberidEqualTo(Integer.parseInt(memberId));
        List<TOrder> tOrders = tOrderMapper.selectByExample(tOrderExample);

        //复制订单信息
        List<UserOrderVo> userOrderVoList = new ArrayList<>();

        for(TOrder tOrder : tOrders) {
            UserOrderVo userOrderVo = new UserOrderVo();
            BeanUtils.copyProperties(tOrder,userOrderVo);

            userOrderVoList.add(userOrderVo);
        }

        return userOrderVoList;
    }

    @Override
    public int deleteUserOrder(String accessToken, UserDeleteOrderVo userDeleteOrderVo) {
        //通过accessToken获取t_member.id
        String memberId = stringRedisTemplate.opsForValue().get(accessToken);
        if(StringUtils.isEmpty(memberId)){
            throw new UserException(UserExceptionEnum.USER_UNLOGIN);
        }

        return tOrderMapper.deleteByPrimaryKey(userDeleteOrderVo.getId());
    }

    @Override
    public UserLoginVo getUserLogin(String loginacct) {
        TMemberExample tMemberExample = new TMemberExample();
        tMemberExample.createCriteria().andLoginacctEqualTo(loginacct);

        List<TMember> result = tMemberMapper.selectByExample(tMemberExample);

        if(result != null && result.size() > 0) {
            TMember tMember = result.get(0);
            UserLoginVo userLoginVo = new UserLoginVo();
            BeanUtils.copyProperties(tMember, userLoginVo);

            //生成令牌
            String token = UUID.randomUUID().toString().replace("-", "");
            userLoginVo.setAccessToken(token);
            //缓存令牌
            stringRedisTemplate.opsForValue().set(token, result.get(0).getId().toString());

            return userLoginVo;
        }else{
            throw new UserException(UserExceptionEnum.USER_UNEXIST);
        }
    }

    @Override
    public UserResponseVo getAccessToken(String loginacct) {
        TMemberExample tMemberExample = new TMemberExample();

        tMemberExample.createCriteria().andLoginacctEqualTo(loginacct);

        List<TMember> result = tMemberMapper.selectByExample(tMemberExample);

        if(result != null && result.size() > 0) {
            UserResponseVo userResponseVo = new UserResponseVo();
            BeanUtils.copyProperties(result.get(0), userResponseVo);
            //生成令牌
            String token = UUID.randomUUID().toString().replace("-", "");
            userResponseVo.setAccessToken(token);
            //缓存令牌
            stringRedisTemplate.opsForValue().set(token, result.get(0).getId().toString());

            return userResponseVo;
        }else{
            throw new UserException(UserExceptionEnum.USER_UNEXIST);
        }
    }

    @Override
    public UserLoginVo getAdminLogin(String loginacct) {
        TAdminExample tAdminExample = new TAdminExample();
        tAdminExample.createCriteria().andLoginacctEqualTo(loginacct);

        List<TAdmin> result = tAdminMapper.selectByExample(tAdminExample);

        if(result != null && result.size() > 0) {
            TAdmin tAdmin = result.get(0);
            UserLoginVo userLoginVo = new UserLoginVo();
            BeanUtils.copyProperties(tAdmin, userLoginVo);

            //生成令牌
            String token = UUID.randomUUID().toString().replace("-", "");
            userLoginVo.setAccessToken(token);
            //缓存令牌
            stringRedisTemplate.opsForValue().set(token, result.get(0).getId().toString());

            return userLoginVo;
        }else{
            throw new UserException(UserExceptionEnum.USER_UNEXIST);
        }
    }


    @Override
    public List<TRole> getAdminRoles(String loginacct) {
        TAdminExample tAdminExample = new TAdminExample();
        tAdminExample.createCriteria().andLoginacctEqualTo(loginacct);

        List<TAdmin> result = tAdminMapper.selectByExample(tAdminExample);

        if(result != null && result.size() > 0) {
            TAdmin tAdmin = result.get(0);
            TAdminRoleExample tAdminRoleExample = new TAdminRoleExample();
            tAdminRoleExample.createCriteria().andAdminidEqualTo(tAdmin.getId());
            List<TAdminRole> tAdminRoleList = tAdminRoleMapper.selectByExample(tAdminRoleExample);

            List<TRole> tRoleList = new ArrayList<>();
            for(TAdminRole tAdminRole : tAdminRoleList){
                TRole tRole = tRoleMapper.selectByPrimaryKey(tAdminRole.getRoleid());
                if(tRole != null){
                    tRoleList.add(tRole);
                }
            }

            return tRoleList;
        }else{
            throw new UserException(UserExceptionEnum.USER_UNEXIST);
        }
    }

    @Override
    public PageInfo<UserResponseVo> getAllUser(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);

        List<UserResponseVo> userResponseVoList = new ArrayList<>();

        List<TMember> tMemberList = tMemberMapper.selectByExample(null);

        //PageInfo里面的list必须是mybatis mapper执行后返回的list, 但是可以在后面通过setList来更改集合元素
        PageInfo pageInfo = new PageInfo(tMemberList);

        tMemberList.stream().forEach(tMember -> {
            UserResponseVo userResponseVo = new UserResponseVo();
            BeanUtils.copyProperties(tMember,userResponseVo);
            userResponseVoList.add(userResponseVo);
        });

        pageInfo.setList(userResponseVoList);

        return pageInfo;
    }
}
