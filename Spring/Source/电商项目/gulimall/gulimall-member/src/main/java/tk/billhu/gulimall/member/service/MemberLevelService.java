package tk.billhu.gulimall.member.service;

import com.baomidou.mybatisplus.extension.service.IService;
import tk.billhu.gulimall.common.utils.PageUtils;
import tk.billhu.gulimall.member.entity.MemberLevelEntity;

import java.util.Map;

/**
 * 会员等级
 *
 * @author billhu
 * @email billtt@163.com
 * @date 2020-05-19 17:35:15
 */
public interface MemberLevelService extends IService<MemberLevelEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

