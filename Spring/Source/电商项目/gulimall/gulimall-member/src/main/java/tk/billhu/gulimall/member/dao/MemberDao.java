package tk.billhu.gulimall.member.dao;

import tk.billhu.gulimall.member.entity.MemberEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 会员
 * 
 * @author billhu
 * @email billtt@163.com
 * @date 2020-05-19 17:35:15
 */
@Mapper
public interface MemberDao extends BaseMapper<MemberEntity> {
	
}
