package test.dao;

import java.util.List;
import test.model.MemorySummaryByHostByEventName;

public interface MemorySummaryByHostByEventNameMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table memory_summary_by_host_by_event_name
     *
     * @mbg.generated
     */
    int insert(MemorySummaryByHostByEventName record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table memory_summary_by_host_by_event_name
     *
     * @mbg.generated
     */
    List<MemorySummaryByHostByEventName> selectAll();
}