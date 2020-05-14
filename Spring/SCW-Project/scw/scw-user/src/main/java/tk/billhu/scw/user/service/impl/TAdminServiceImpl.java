package tk.billhu.scw.user.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import tk.billhu.scw.enums.AuthEnume;
import tk.billhu.scw.enums.UserExceptionEnum;
import tk.billhu.scw.user.entities.TAdmin;
import tk.billhu.scw.user.entities.TAdminExample;
import tk.billhu.scw.user.entities.TMember;
import tk.billhu.scw.user.entities.TMemberExample;
import tk.billhu.scw.user.exception.UserException;
import tk.billhu.scw.user.mapper.TAdminMapper;
import tk.billhu.scw.user.service.TAdminService;
import tk.billhu.scw.user.vo.request.AdminRegisterVo;
import tk.billhu.scw.user.vo.request.AdminUpdateVo;
import tk.billhu.scw.user.vo.response.AdminResponseVo;
import tk.billhu.scw.user.vo.response.UserResponseVo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class TAdminServiceImpl implements TAdminService {
    private static BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

    @Autowired
    TAdminMapper tAdminMapper;

    @Override
    public int register(AdminRegisterVo adminRegisterVo) {
        //验证手机号和邮箱是否被使用过
        if(checkExist(adminRegisterVo.getLoginacct(),adminRegisterVo.getEmail())){
            log.error("注册会员失败, 手机号或邮箱被占用-{}-{}",adminRegisterVo.getLoginacct(),adminRegisterVo.getEmail());
            throw new UserException(UserExceptionEnum.USER_REGISTERED);
        }

        try{
            //注册管理员
            TAdmin tAdmin = new TAdmin();
            BeanUtils.copyProperties(adminRegisterVo, tAdmin);

            //密码加密
            String password = adminRegisterVo.getUserpswd();
            tAdmin.setUserpswd(encoder.encode(password));

            int n = tAdminMapper.insert(tAdmin);
            if(n == 1) {
                log.debug("管理员创建成功-{}", tAdmin);
            }else{
                throw new Exception("保存结果多于一条记录");
            }

            return n;
        }catch(Exception e){
            log.error("创建管理员失败-{}",e.getMessage());
            throw new UserException(UserExceptionEnum.SAVE_ERROR);
        }
    }

    @Override
    public PageInfo<AdminResponseVo> getAllUser(int pageNum, int pageSize, String condition) {
        PageHelper.startPage(pageNum, pageSize);

        List<AdminResponseVo> adminResponseVoList = new ArrayList<>();

        TAdminExample tAdminExample = new TAdminExample();
        tAdminExample.setOrderByClause("createtime desc");

        if(!"".equals(condition)) {
            //set search criteria on loginacct
            tAdminExample.createCriteria().andLoginacctLike("%"+condition+"%");
            //set search criteria on username
            TAdminExample.Criteria criteriaOfUsername = tAdminExample.createCriteria().andUsernameLike("%"+condition+"%");
            TAdminExample.Criteria criteriaOfEmail = tAdminExample.createCriteria().andEmailLike("%"+condition+"%");

            //combination criteria using OR
            tAdminExample.or(criteriaOfUsername);
            tAdminExample.or(criteriaOfEmail);
        }

        List<TAdmin> tAdminList = tAdminMapper.selectByExample(tAdminExample);

        //PageInfo里面的list必须是mybatis mapper执行后返回的list, 但是可以在后面通过setList来更改集合元素
        PageInfo pageInfo = new PageInfo(tAdminList);

        tAdminList.stream().forEach(tAdmin -> {
            AdminResponseVo adminResponseVo = new AdminResponseVo();
            BeanUtils.copyProperties(tAdmin,adminResponseVo);
            adminResponseVoList.add(adminResponseVo);
        });

        pageInfo.setList(adminResponseVoList);

        return pageInfo;
    }

    /**
     * 检验手机号或邮箱是否被注册使用过
     * @param loginacct
     * @param email
     * @return
     */
    private boolean checkExist(String loginacct, String email) {
        TAdminExample tAdminExample = new TAdminExample();
        //这2个条件是 OR 的关系
        //如果需要AND关系，就用tMemberExample.createCriteria().andLoginacctEqualTo(loginacct).andEmailEqualTo(email)
        tAdminExample.createCriteria().andLoginacctEqualTo(loginacct);
        tAdminExample.createCriteria().andEmailEqualTo(email);

        long n = tAdminMapper.countByExample(tAdminExample);

        return n > 0;
    }

    @Override
    public AdminResponseVo getAdminUser(String id) {
        AdminResponseVo adminResponseVo = new AdminResponseVo();

        TAdmin tAdmin = tAdminMapper.selectByPrimaryKey(Integer.parseInt(id));

        BeanUtils.copyProperties(tAdmin,adminResponseVo);

        return adminResponseVo;
    }

    @Override
    public AdminResponseVo UpdateAdminUser(AdminUpdateVo adminUpdateVo) {
        TAdmin tAdmin = new TAdmin();
        BeanUtils.copyProperties(adminUpdateVo,tAdmin);

        AdminResponseVo adminResponseVo = new AdminResponseVo();
        int n = tAdminMapper.updateByPrimaryKeySelective(tAdmin);

        if(n == 1){
            BeanUtils.copyProperties(adminUpdateVo,adminResponseVo);
            return adminResponseVo;
        }

        return null;
    }

    @Override
    public int deleteAdminUser(String id) {
        return tAdminMapper.deleteByPrimaryKey(Integer.parseInt(id));
    }

    @Override
    public int deleteAdminUsers(String ids) {

        List<Integer> deleteIdList = Arrays.asList(ids.split(",")).stream().map(Integer::parseInt).collect(Collectors.toList());

        TAdminExample tAdminExample = new TAdminExample();
        tAdminExample.createCriteria().andIdIn(deleteIdList);
        return tAdminMapper.deleteByExample(tAdminExample);
    }
}
