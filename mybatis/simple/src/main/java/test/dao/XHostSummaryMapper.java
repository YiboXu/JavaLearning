package test.dao;

import java.util.List;
import test.model.XHostSummary;

public interface XHostSummaryMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table x$host_summary
     *
     * @mbg.generated
     */
    int insert(XHostSummary record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table x$host_summary
     *
     * @mbg.generated
     */
    List<XHostSummary> selectAll();
}