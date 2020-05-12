package tk.billhu.scw.order.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import tk.billhu.scw.order.entities.TProjectLegal;
import tk.billhu.scw.order.entities.TProjectLegalExample;

public interface TProjectLegalMapper {
    long countByExample(TProjectLegalExample example);

    int deleteByExample(TProjectLegalExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TProjectLegal record);

    int insertSelective(TProjectLegal record);

    List<TProjectLegal> selectByExample(TProjectLegalExample example);

    TProjectLegal selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TProjectLegal record, @Param("example") TProjectLegalExample example);

    int updateByExample(@Param("record") TProjectLegal record, @Param("example") TProjectLegalExample example);

    int updateByPrimaryKeySelective(TProjectLegal record);

    int updateByPrimaryKey(TProjectLegal record);
}