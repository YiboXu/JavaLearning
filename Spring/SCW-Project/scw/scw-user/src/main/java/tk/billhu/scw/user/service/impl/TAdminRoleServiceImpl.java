package tk.billhu.scw.user.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import tk.billhu.scw.user.entities.TAdminRole;
import tk.billhu.scw.user.entities.TAdminRoleExample;
import tk.billhu.scw.user.entities.TRole;
import tk.billhu.scw.user.entities.TRoleExample;
import tk.billhu.scw.user.exception.RoleException;
import tk.billhu.scw.user.exception.RoleExceptionEnum;
import tk.billhu.scw.user.mapper.TAdminRoleMapper;
import tk.billhu.scw.user.mapper.TRoleMapper;
import tk.billhu.scw.user.service.TAdminRoleService;
import tk.billhu.scw.user.vo.request.AdminRoleRegisterVo;
import tk.billhu.scw.user.vo.request.AdminRoleUpdateVo;
import tk.billhu.scw.user.vo.response.AdminRoleResponseVo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
@Transactional(readOnly = true)
public class TAdminRoleServiceImpl implements TAdminRoleService {

    @Autowired
    private TRoleMapper tRoleMapper;

    @Autowired
    private TAdminRoleMapper tAdminRoleMapper;

    @Override
    public PageInfo<AdminRoleResponseVo> getAllAdminRole(int pageNum, int pageSize, String condition) {
        PageHelper.startPage(pageNum,pageSize);

        List<TRole> tRoleList;

        //条件查询
        if(!"".equals(condition)) {
            TRoleExample tRoleExample = new TRoleExample();
            tRoleExample.createCriteria().andNameLike("%"+condition+"%");
            tRoleList = tRoleMapper.selectByExample(tRoleExample);
        }else {
            tRoleList = tRoleMapper.selectByExample(null);
        }

        PageInfo pageInfo = new PageInfo<>(tRoleList);

        List<AdminRoleResponseVo> adminRoleResponseVoList = new ArrayList<>();

        tRoleList.stream().forEach(role -> {
            AdminRoleResponseVo adminRoleResponseVo = new AdminRoleResponseVo();
            BeanUtils.copyProperties(role,adminRoleResponseVo);
            adminRoleResponseVoList.add(adminRoleResponseVo);
        });

        pageInfo.setList(adminRoleResponseVoList);

        return pageInfo;
    }

    @Override
    public AdminRoleResponseVo getAdminRole(String id) {
        AdminRoleResponseVo adminRoleResponseVo = new AdminRoleResponseVo();

        TRole tRole = tRoleMapper.selectByPrimaryKey(Integer.parseInt(id));

        BeanUtils.copyProperties(tRole,adminRoleResponseVo);

        return adminRoleResponseVo;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.REPEATABLE_READ, rollbackFor = Exception.class)
    public String UpdateAdminRole(AdminRoleUpdateVo adminRoleUpdateVo) {
        TRole tRole = new TRole();

        BeanUtils.copyProperties(adminRoleUpdateVo,tRole);

        int n = tRoleMapper.updateByPrimaryKey(tRole);

        if(n==1){
            AdminRoleResponseVo adminRoleResponseVo = new AdminRoleResponseVo();
            BeanUtils.copyProperties(adminRoleResponseVo,adminRoleResponseVo);
            return "ok";
        }

        return "fail";
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.REPEATABLE_READ, rollbackFor = Exception.class)
    public String deleteAdminRole(String id) {
        int result = tRoleMapper.deleteByPrimaryKey(Integer.parseInt(id));
        if(result > 0) {
            return "ok";
        }else{
            return "fail";
        }
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.REPEATABLE_READ, rollbackFor = Exception.class)
    public String deleteAdminRoles(String ids) {
        List<Integer> deleteIdList = Arrays.asList(ids.split(",")).stream().map(Integer::parseInt).collect(Collectors.toList());

        TRoleExample tRoleExample = new TRoleExample();
        tRoleExample.createCriteria().andIdIn(deleteIdList);

        int result =  tRoleMapper.deleteByExample(tRoleExample);

        if(result > 0){
            return "ok";
        }else{
            return "fail";
        }
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.REPEATABLE_READ, rollbackFor = Exception.class)
    public String create(AdminRoleRegisterVo adminRoleRegisterVo) {
        if(checkExist(adminRoleRegisterVo.getName())){
            log.error("管理员角色创建失败, 角色名被占用-{}",adminRoleRegisterVo.getName());
            throw new RoleException(RoleExceptionEnum.NAME_EXIST);
        }

        try{
            //创建角色
            TRole tRole = new TRole();
            BeanUtils.copyProperties(adminRoleRegisterVo, tRole);

            int n = tRoleMapper.insert(tRole);
            if(n == 1) {
                log.debug("管理员角色创建成功-{}", tRole);
            }else{
                throw new Exception("保存结果多于一条记录");
            }

        }catch(Exception e){
            log.error("创建管理员角色失败-{}",e.getMessage());
            throw new RoleException(RoleExceptionEnum.SAVE_ERROR);
        }

        return "ok";
    }

    private boolean checkExist(String name) {
        TRoleExample tRoleExample = new TRoleExample();
        tRoleExample.createCriteria().andNameEqualTo(name);

        long n = tRoleMapper.countByExample(tRoleExample);

        return n > 0;
    }

    @Override
    public List<AdminRoleResponseVo> getAssignedRole(int adminid) {
        TAdminRoleExample tAdminRoleExample = new TAdminRoleExample();
        tAdminRoleExample.createCriteria().andAdminidEqualTo(adminid);

        List<TAdminRole> tAdminRoleList = tAdminRoleMapper.selectByExample(tAdminRoleExample);

        List<AdminRoleResponseVo> adminRoleResponseVoList = new ArrayList<>();

        for(TAdminRole tAdminRole : tAdminRoleList){
            TRole tRole = tRoleMapper.selectByPrimaryKey(tAdminRole.getRoleid());
            if(tRole != null){
                AdminRoleResponseVo adminRoleResponseVo = new AdminRoleResponseVo();
                BeanUtils.copyProperties(tRole,adminRoleResponseVo);
                adminRoleResponseVoList.add(adminRoleResponseVo);
            }
        }

        return adminRoleResponseVoList;
    }

    @Override
    public List<AdminRoleResponseVo> getUnAssignedRole(int adminid) {
        //获取已经赋予的角色
        TAdminRoleExample tAdminRoleExample = new TAdminRoleExample();
        tAdminRoleExample.createCriteria().andAdminidEqualTo(adminid);

        List<TAdminRole> assignedRoleList = tAdminRoleMapper.selectByExample(tAdminRoleExample);

        //获取能够赋予的角色
        List<Integer> assignedRoleIds = assignedRoleList.stream().map(TAdminRole::getRoleid).collect(Collectors.toList());

        //avoid sql error (empty list will generate sql NOT IN without element, so add one to avoid sql error)
        if(assignedRoleIds.size() == 0){
            assignedRoleIds.add(-1);
        }

        TRoleExample tRoleExample = new TRoleExample();
        tRoleExample.createCriteria().andIdNotIn(assignedRoleIds);

        List<TRole> tRoleList = tRoleMapper.selectByExample(tRoleExample);

        List<AdminRoleResponseVo> unAssignedRoleList = new ArrayList<>();

        for(TRole tRole : tRoleList){
            AdminRoleResponseVo adminRoleResponseVo = new AdminRoleResponseVo();
            BeanUtils.copyProperties(tRole,adminRoleResponseVo);
            unAssignedRoleList.add(adminRoleResponseVo);
        }

        return unAssignedRoleList;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.REPEATABLE_READ, rollbackFor = Exception.class)
    public String assignAdminRoles(String adminId, String roleIds) {

        //获取已经赋予的角色
        TAdminRoleExample tAdminRoleExample = new TAdminRoleExample();
        tAdminRoleExample.createCriteria().andAdminidEqualTo(Integer.parseInt(adminId));

        List<TAdminRole> newAssignedRoleList = Arrays.stream(roleIds.split(",")).map(roleId -> {
                                                    TAdminRole tAdminRole = new TAdminRole();
                                                    tAdminRole.setAdminid(Integer.parseInt(adminId));
                                                    tAdminRole.setRoleid(Integer.parseInt(roleId));
                                                    return tAdminRole;
                                                }).collect(Collectors.toList());

        //删除当前所有权限
        tAdminRoleMapper.deleteByExample(tAdminRoleExample);

        //重新赋予新的权限
        for(TAdminRole tAdminRole : newAssignedRoleList) {
            try{
                int n = tAdminRoleMapper.insertSelective(tAdminRole);
                if(n!=1){
                    throw new RoleException(RoleExceptionEnum.SAVE_ERROR);
                }
            }catch (Exception e){
                throw new RoleException(RoleExceptionEnum.SAVE_ERROR);
            }
        }

        return "ok";
    }
}
