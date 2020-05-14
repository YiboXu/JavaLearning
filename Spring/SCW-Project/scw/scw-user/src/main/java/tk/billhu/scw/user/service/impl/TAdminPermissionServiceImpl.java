package tk.billhu.scw.user.service.impl;

import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import tk.billhu.scw.user.entities.TPermission;
import tk.billhu.scw.user.entities.TPermissionExample;
import tk.billhu.scw.user.entities.TRolePermission;
import tk.billhu.scw.user.entities.TRolePermissionExample;
import tk.billhu.scw.user.exception.PermissionException;
import tk.billhu.scw.user.exception.PermissionExceptionEnum;
import tk.billhu.scw.user.mapper.TPermissionMapper;
import tk.billhu.scw.user.mapper.TRolePermissionMapper;
import tk.billhu.scw.user.service.TAdminPermissionService;
import tk.billhu.scw.user.vo.request.AdminPermissionRegisterVo;
import tk.billhu.scw.user.vo.request.AdminPermissionUpdateVo;
import tk.billhu.scw.user.vo.response.AdminPermissionVo;
import tk.billhu.scw.vo.resp.AppResponse;

import java.util.*;
import java.util.stream.Collectors;

@Service
@Slf4j
public class TAdminPermissionServiceImpl implements TAdminPermissionService {
    @Autowired
    private TPermissionMapper tPermissionMapper;

    @Autowired
    private TRolePermissionMapper tRolePermissionMapper;

    @Override
    public List<AdminPermissionVo> getAdminPermissionList() {
        List<AdminPermissionVo> adminPermissionVoList = new ArrayList<>();
        //获取所有t_Permission记录
        List<TPermission> PermissionList = tPermissionMapper.selectByExample(null);
        Map<Integer,AdminPermissionVo> cache = new HashMap<Integer,AdminPermissionVo>();
        //将pid=0的记录添加到结果集
        PermissionList.stream()
                .filter(x -> x.getPid() == 0)
                .forEach(tPermission -> {
                    AdminPermissionVo adminPermissionVo = new AdminPermissionVo();
                    BeanUtils.copyProperties(tPermission,adminPermissionVo);
                    adminPermissionVoList.add(adminPermissionVo);
                    cache.put(tPermission.getId(),adminPermissionVo);
                });
        //将Pid>0的记录添加到对应结果集记录的childPermission
        PermissionList.stream()
                .filter(x -> x.getPid() > 0)
                .forEach(tPermission -> {
                    AdminPermissionVo adminPermissionVo = new AdminPermissionVo();
                    BeanUtils.copyProperties(tPermission,adminPermissionVo);
                    cache.get(tPermission.getPid()).getChildren().add(adminPermissionVo);
                });

        return adminPermissionVoList;
    }

    @Override
    public String create(AdminPermissionRegisterVo adminPermissionRegisterVo) {
        if(checkExist(adminPermissionRegisterVo.getPid(),adminPermissionRegisterVo.getName())){
            log.error("管理员权限创建失败, 权限名被占用-{}",adminPermissionRegisterVo.getName());
            throw new PermissionException(PermissionExceptionEnum.NAME_EXIST);
        }

        try{
            //创建权限
            TPermission tPermission = new TPermission();
            BeanUtils.copyProperties(adminPermissionRegisterVo, tPermission);

            int n = tPermissionMapper.insert(tPermission);
            if(n == 1) {
                log.debug("管理员角色创建成功-{}", tPermission);
            }else{
                throw new Exception("保存结果多于一条记录");
            }

        }catch(Exception e){
            log.error("创建管理员权限失败-{}",e.getMessage());
            throw new PermissionException(PermissionExceptionEnum.SAVE_ERROR);
        }

        return "ok";
    }

    @Override
    public AdminPermissionVo getAdminPermission(String id) {
        AdminPermissionVo adminPermissionVo = new AdminPermissionVo();

        TPermission tPermission = tPermissionMapper.selectByPrimaryKey(Integer.parseInt(id));

        BeanUtils.copyProperties(tPermission,adminPermissionVo);

        return adminPermissionVo;
    }

    @Override
    public String UpdateAdminPermission(AdminPermissionUpdateVo adminPermissionUpdateVo) {
        TPermission tPermission = new TPermission();

        BeanUtils.copyProperties(adminPermissionUpdateVo,tPermission);

        int n = tPermissionMapper.updateByPrimaryKeySelective(tPermission);

        if(n == 1){
            return "ok";
        }
        return "fail";
    }

    @Override
    public String deleteAdminPermission(String id) {
        int n = tPermissionMapper.deleteByPrimaryKey(Integer.parseInt(id));

        if (n == 1){
            return "ok";
        }
        else{
            return "fail";
        }
    }

    private boolean checkExist(Integer pid, String name){
        TPermissionExample tPermissionExample = new TPermissionExample();
        tPermissionExample.createCriteria().andPidEqualTo(pid).andNameEqualTo(name);

        int n = tPermissionMapper.selectByExample(tPermissionExample).size();

        return n > 0;
    }

    @Override
    public String assignRolePermissions(String roleId, String permissionIds) {
        try {
            //先删除已有的权限
            TRolePermissionExample tRolePermissionExample = new TRolePermissionExample();
            tRolePermissionExample.createCriteria().andRoleidEqualTo(Integer.parseInt(roleId));
            tRolePermissionMapper.deleteByExample(tRolePermissionExample);

            //在分配重定义的权限
            Arrays.stream(permissionIds.split(","))
                    .filter(permissionId -> Integer.parseInt(permissionId) > 0)
                    .map(permissionId -> {
                        TRolePermission tRolePermission = new TRolePermission();
                        tRolePermission.setRoleid(Integer.parseInt(roleId));
                        tRolePermission.setPermissionid(Integer.parseInt(permissionId));
                        return tRolePermission;
                    })
                    .forEach(tRolePermissionMapper::insert);
        }catch (Exception e){
            log.debug("角色授权异常-{}-{}",roleId, permissionIds);
            return "fail";
        }
        return "ok";
    }

    @Override
    public List<AdminPermissionVo> getPermissionByRoleId(String roleId) {
        TRolePermissionExample tRolePermissionExample = new TRolePermissionExample();
        tRolePermissionExample.createCriteria().andRoleidEqualTo(Integer.parseInt(roleId));

        List<TRolePermission> tRolePermissionList = tRolePermissionMapper.selectByExample(tRolePermissionExample);

        return tRolePermissionList.stream().map(tRolePermission -> {
            TPermission tPermission = tPermissionMapper.selectByPrimaryKey(tRolePermission.getPermissionid());
            AdminPermissionVo adminPermissionVo = new AdminPermissionVo();
            BeanUtils.copyProperties(tPermission,adminPermissionVo);
            return adminPermissionVo;
        }).collect(Collectors.toList());
    }
}
