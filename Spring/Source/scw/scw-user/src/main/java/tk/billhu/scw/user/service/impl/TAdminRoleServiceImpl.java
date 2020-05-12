package tk.billhu.scw.user.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.billhu.scw.user.entities.TRole;
import tk.billhu.scw.user.entities.TRoleExample;
import tk.billhu.scw.user.exception.RoleException;
import tk.billhu.scw.user.exception.RoleExceptionEnum;
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
public class TAdminRoleServiceImpl implements TAdminRoleService {

    @Autowired
    private TRoleMapper tRoleMapper;

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
    public String deleteAdminRole(String id) {
        int result = tRoleMapper.deleteByPrimaryKey(Integer.parseInt(id));
        if(result > 0) {
            return "ok";
        }else{
            return "fail";
        }
    }

    @Override
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
}
