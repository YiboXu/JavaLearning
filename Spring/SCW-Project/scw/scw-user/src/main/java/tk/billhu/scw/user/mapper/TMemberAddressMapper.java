package tk.billhu.scw.user.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import tk.billhu.scw.user.entities.TMemberAddress;
import tk.billhu.scw.user.entities.TMemberAddressExample;

public interface TMemberAddressMapper {
    long countByExample(TMemberAddressExample example);

    int deleteByExample(TMemberAddressExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TMemberAddress record);

    int insertSelective(TMemberAddress record);

    List<TMemberAddress> selectByExample(TMemberAddressExample example);

    TMemberAddress selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TMemberAddress record, @Param("example") TMemberAddressExample example);

    int updateByExample(@Param("record") TMemberAddress record, @Param("example") TMemberAddressExample example);

    int updateByPrimaryKeySelective(TMemberAddress record);

    int updateByPrimaryKey(TMemberAddress record);
}