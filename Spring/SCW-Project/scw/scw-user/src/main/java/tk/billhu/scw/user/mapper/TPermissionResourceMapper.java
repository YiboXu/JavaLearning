package tk.billhu.scw.user.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import tk.billhu.scw.user.entities.TPermissionResource;
import tk.billhu.scw.user.entities.TPermissionResourceExample;

public interface TPermissionResourceMapper {
    long countByExample(TPermissionResourceExample example);

    int deleteByExample(TPermissionResourceExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TPermissionResource record);

    int insertSelective(TPermissionResource record);

    List<TPermissionResource> selectByExample(TPermissionResourceExample example);

    TPermissionResource selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TPermissionResource record, @Param("example") TPermissionResourceExample example);

    int updateByExample(@Param("record") TPermissionResource record, @Param("example") TPermissionResourceExample example);

    int updateByPrimaryKeySelective(TPermissionResource record);

    int updateByPrimaryKey(TPermissionResource record);
}