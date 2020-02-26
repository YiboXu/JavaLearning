package test.model;

import java.math.BigDecimal;

/**
 * Database Table Remarks:
 *   VIEW
 *
 * This class was generated by MyBatis Generator.
 * This class corresponds to the database table x$memory_by_thread_by_current_bytes
 */
public class XMemoryByThreadByCurrentBytes {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column x$memory_by_thread_by_current_bytes.thread_id
     *
     * @mbg.generated
     */
    private Long threadId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column x$memory_by_thread_by_current_bytes.user
     *
     * @mbg.generated
     */
    private String user;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column x$memory_by_thread_by_current_bytes.current_count_used
     *
     * @mbg.generated
     */
    private BigDecimal currentCountUsed;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column x$memory_by_thread_by_current_bytes.current_allocated
     *
     * @mbg.generated
     */
    private BigDecimal currentAllocated;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column x$memory_by_thread_by_current_bytes.current_avg_alloc
     *
     * @mbg.generated
     */
    private BigDecimal currentAvgAlloc;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column x$memory_by_thread_by_current_bytes.current_max_alloc
     *
     * @mbg.generated
     */
    private Long currentMaxAlloc;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column x$memory_by_thread_by_current_bytes.total_allocated
     *
     * @mbg.generated
     */
    private BigDecimal totalAllocated;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column x$memory_by_thread_by_current_bytes.thread_id
     *
     * @return the value of x$memory_by_thread_by_current_bytes.thread_id
     *
     * @mbg.generated
     */
    public Long getThreadId() {
        return threadId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column x$memory_by_thread_by_current_bytes.thread_id
     *
     * @param threadId the value for x$memory_by_thread_by_current_bytes.thread_id
     *
     * @mbg.generated
     */
    public void setThreadId(Long threadId) {
        this.threadId = threadId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column x$memory_by_thread_by_current_bytes.user
     *
     * @return the value of x$memory_by_thread_by_current_bytes.user
     *
     * @mbg.generated
     */
    public String getUser() {
        return user;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column x$memory_by_thread_by_current_bytes.user
     *
     * @param user the value for x$memory_by_thread_by_current_bytes.user
     *
     * @mbg.generated
     */
    public void setUser(String user) {
        this.user = user == null ? null : user.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column x$memory_by_thread_by_current_bytes.current_count_used
     *
     * @return the value of x$memory_by_thread_by_current_bytes.current_count_used
     *
     * @mbg.generated
     */
    public BigDecimal getCurrentCountUsed() {
        return currentCountUsed;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column x$memory_by_thread_by_current_bytes.current_count_used
     *
     * @param currentCountUsed the value for x$memory_by_thread_by_current_bytes.current_count_used
     *
     * @mbg.generated
     */
    public void setCurrentCountUsed(BigDecimal currentCountUsed) {
        this.currentCountUsed = currentCountUsed;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column x$memory_by_thread_by_current_bytes.current_allocated
     *
     * @return the value of x$memory_by_thread_by_current_bytes.current_allocated
     *
     * @mbg.generated
     */
    public BigDecimal getCurrentAllocated() {
        return currentAllocated;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column x$memory_by_thread_by_current_bytes.current_allocated
     *
     * @param currentAllocated the value for x$memory_by_thread_by_current_bytes.current_allocated
     *
     * @mbg.generated
     */
    public void setCurrentAllocated(BigDecimal currentAllocated) {
        this.currentAllocated = currentAllocated;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column x$memory_by_thread_by_current_bytes.current_avg_alloc
     *
     * @return the value of x$memory_by_thread_by_current_bytes.current_avg_alloc
     *
     * @mbg.generated
     */
    public BigDecimal getCurrentAvgAlloc() {
        return currentAvgAlloc;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column x$memory_by_thread_by_current_bytes.current_avg_alloc
     *
     * @param currentAvgAlloc the value for x$memory_by_thread_by_current_bytes.current_avg_alloc
     *
     * @mbg.generated
     */
    public void setCurrentAvgAlloc(BigDecimal currentAvgAlloc) {
        this.currentAvgAlloc = currentAvgAlloc;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column x$memory_by_thread_by_current_bytes.current_max_alloc
     *
     * @return the value of x$memory_by_thread_by_current_bytes.current_max_alloc
     *
     * @mbg.generated
     */
    public Long getCurrentMaxAlloc() {
        return currentMaxAlloc;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column x$memory_by_thread_by_current_bytes.current_max_alloc
     *
     * @param currentMaxAlloc the value for x$memory_by_thread_by_current_bytes.current_max_alloc
     *
     * @mbg.generated
     */
    public void setCurrentMaxAlloc(Long currentMaxAlloc) {
        this.currentMaxAlloc = currentMaxAlloc;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column x$memory_by_thread_by_current_bytes.total_allocated
     *
     * @return the value of x$memory_by_thread_by_current_bytes.total_allocated
     *
     * @mbg.generated
     */
    public BigDecimal getTotalAllocated() {
        return totalAllocated;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column x$memory_by_thread_by_current_bytes.total_allocated
     *
     * @param totalAllocated the value for x$memory_by_thread_by_current_bytes.total_allocated
     *
     * @mbg.generated
     */
    public void setTotalAllocated(BigDecimal totalAllocated) {
        this.totalAllocated = totalAllocated;
    }
}