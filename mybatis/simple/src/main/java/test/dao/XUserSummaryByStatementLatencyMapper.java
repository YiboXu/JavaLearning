package test.dao;

import java.util.List;
import test.model.XUserSummaryByStatementLatency;

public interface XUserSummaryByStatementLatencyMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table x$user_summary_by_statement_latency
     *
     * @mbg.generated
     */
    int insert(XUserSummaryByStatementLatency record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table x$user_summary_by_statement_latency
     *
     * @mbg.generated
     */
    List<XUserSummaryByStatementLatency> selectAll();
}