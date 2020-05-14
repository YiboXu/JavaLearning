package tk.billhu.scw.user.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.billhu.scw.user.entities.TMenu;
import tk.billhu.scw.user.entities.TMenuExample;
import tk.billhu.scw.user.entities.TRole;
import tk.billhu.scw.user.exception.MenuException;
import tk.billhu.scw.user.exception.MenuExceptionEnum;
import tk.billhu.scw.user.exception.RoleException;
import tk.billhu.scw.user.exception.RoleExceptionEnum;
import tk.billhu.scw.user.mapper.TMenuMapper;
import tk.billhu.scw.user.service.TAdminMenuService;
import tk.billhu.scw.user.vo.request.AdminMenuRegisterVo;
import tk.billhu.scw.user.vo.request.AdminMenuUpdateVo;
import tk.billhu.scw.user.vo.response.AdminMenuVo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Slf4j
public class TAdminMenuServiceImpl implements TAdminMenuService {
    @Autowired
    private TMenuMapper tMenuMapper;

    @Override
    public List<AdminMenuVo> getAdminMenuList() {
        List<AdminMenuVo> adminMenuVoList = new ArrayList<>();
        //获取所有t_menu记录
        List<TMenu> menuList = tMenuMapper.selectByExample(null);
        Map<Integer,AdminMenuVo> cache = new HashMap<Integer,AdminMenuVo>();
        //将pid=0的记录添加到结果集
        menuList.stream()
                .filter(x -> x.getPid() == 0)
                .forEach(tMenu -> {
                    AdminMenuVo adminMenuVo = new AdminMenuVo();
                    BeanUtils.copyProperties(tMenu,adminMenuVo);
                    adminMenuVoList.add(adminMenuVo);
                    cache.put(tMenu.getId(),adminMenuVo);
                });
        //将Pid>0的记录添加到对应结果集记录的childMenu
        menuList.stream()
                .filter(x -> x.getPid() > 0)
                .forEach(tMenu -> {
                    AdminMenuVo adminMenuVo = new AdminMenuVo();
                    BeanUtils.copyProperties(tMenu,adminMenuVo);
                    cache.get(tMenu.getPid()).getChildMenu().add(adminMenuVo);
                });

        //将没有子菜单的菜单的childMenu设置为null, 前端页面通过是否有子菜单来进行不同的显示效果
        adminMenuVoList.forEach(menuVo -> {
            if(menuVo.getChildMenu().size()==0)
                menuVo.setChildMenu(null);
        });

        return adminMenuVoList;
    }

    @Override
    public String create(AdminMenuRegisterVo adminMenuRegisterVo) {
        if(checkExist(adminMenuRegisterVo.getPid(),adminMenuRegisterVo.getName())){
            log.error("管理员菜单创建失败, 菜单名被占用-{}",adminMenuRegisterVo.getName());
            throw new MenuException(MenuExceptionEnum.NAME_EXIST);
        }

        try{
            //创建角色
            TMenu tMenu = new TMenu();
            BeanUtils.copyProperties(adminMenuRegisterVo, tMenu);

            int n = tMenuMapper.insert(tMenu);
            if(n == 1) {
                log.debug("管理员惨淡创建成功-{}", tMenu);
            }else{
                throw new Exception("保存结果多于一条记录");
            }

        }catch(Exception e){
            log.error("创建管理员菜单失败-{}",e.getMessage());
            throw new MenuException(MenuExceptionEnum.SAVE_ERROR);
        }

        return "ok";
    }

    @Override
    public AdminMenuVo getAdminMenu(String id) {
        AdminMenuVo adminMenuVo = new AdminMenuVo();

        TMenu tMenu = tMenuMapper.selectByPrimaryKey(Integer.parseInt(id));

        BeanUtils.copyProperties(tMenu,adminMenuVo);

        return adminMenuVo;
    }

    @Override
    public String UpdateAdminMenu(AdminMenuUpdateVo adminMenuUpdateVo) {
        TMenu tMenu = new TMenu();

        BeanUtils.copyProperties(adminMenuUpdateVo,tMenu);

        int n = tMenuMapper.updateByPrimaryKeySelective(tMenu);

        if(n == 1){
            return "ok";
        }
        return "fail";
    }

    @Override
    public String deleteAdminMenu(String id) {
        int n = tMenuMapper.deleteByPrimaryKey(Integer.parseInt(id));

        if (n == 1){
            return "ok";
        }
        else{
            return "fail";
        }
    }

    private boolean checkExist(Integer pid, String name){
        TMenuExample tMenuExample = new TMenuExample();
        tMenuExample.createCriteria().andPidEqualTo(pid).andNameEqualTo(name);

        int n = tMenuMapper.selectByExample(tMenuExample).size();

        return n > 0;
    }
}
