package test.dao;

import java.util.List;
import test.model.UserSummaryByStages;

public interface UserSummaryByStagesMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_summary_by_stages
     *
     * @mbg.generated
     */
    int insert(UserSummaryByStages record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_summary_by_stages
     *
     * @mbg.generated
     */
    List<UserSummaryByStages> selectAll();
}