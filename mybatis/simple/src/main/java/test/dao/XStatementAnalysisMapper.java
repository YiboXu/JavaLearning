package test.dao;

import java.util.List;
import test.model.XStatementAnalysis;

public interface XStatementAnalysisMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table x$statement_analysis
     *
     * @mbg.generated
     */
    int insert(XStatementAnalysis record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table x$statement_analysis
     *
     * @mbg.generated
     */
    List<XStatementAnalysis> selectAll();
}