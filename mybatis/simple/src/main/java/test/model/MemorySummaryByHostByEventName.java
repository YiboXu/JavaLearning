package test.model;

/**
 *
 * This class was generated by MyBatis Generator.
 * This class corresponds to the database table memory_summary_by_host_by_event_name
 */
public class MemorySummaryByHostByEventName {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column memory_summary_by_host_by_event_name.HOST
     *
     * @mbg.generated
     */
    private String host;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column memory_summary_by_host_by_event_name.EVENT_NAME
     *
     * @mbg.generated
     */
    private String eventName;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column memory_summary_by_host_by_event_name.COUNT_ALLOC
     *
     * @mbg.generated
     */
    private Long countAlloc;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column memory_summary_by_host_by_event_name.COUNT_FREE
     *
     * @mbg.generated
     */
    private Long countFree;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column memory_summary_by_host_by_event_name.SUM_NUMBER_OF_BYTES_ALLOC
     *
     * @mbg.generated
     */
    private Long sumNumberOfBytesAlloc;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column memory_summary_by_host_by_event_name.SUM_NUMBER_OF_BYTES_FREE
     *
     * @mbg.generated
     */
    private Long sumNumberOfBytesFree;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column memory_summary_by_host_by_event_name.LOW_COUNT_USED
     *
     * @mbg.generated
     */
    private Long lowCountUsed;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column memory_summary_by_host_by_event_name.CURRENT_COUNT_USED
     *
     * @mbg.generated
     */
    private Long currentCountUsed;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column memory_summary_by_host_by_event_name.HIGH_COUNT_USED
     *
     * @mbg.generated
     */
    private Long highCountUsed;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column memory_summary_by_host_by_event_name.LOW_NUMBER_OF_BYTES_USED
     *
     * @mbg.generated
     */
    private Long lowNumberOfBytesUsed;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column memory_summary_by_host_by_event_name.CURRENT_NUMBER_OF_BYTES_USED
     *
     * @mbg.generated
     */
    private Long currentNumberOfBytesUsed;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column memory_summary_by_host_by_event_name.HIGH_NUMBER_OF_BYTES_USED
     *
     * @mbg.generated
     */
    private Long highNumberOfBytesUsed;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column memory_summary_by_host_by_event_name.HOST
     *
     * @return the value of memory_summary_by_host_by_event_name.HOST
     *
     * @mbg.generated
     */
    public String getHost() {
        return host;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column memory_summary_by_host_by_event_name.HOST
     *
     * @param host the value for memory_summary_by_host_by_event_name.HOST
     *
     * @mbg.generated
     */
    public void setHost(String host) {
        this.host = host == null ? null : host.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column memory_summary_by_host_by_event_name.EVENT_NAME
     *
     * @return the value of memory_summary_by_host_by_event_name.EVENT_NAME
     *
     * @mbg.generated
     */
    public String getEventName() {
        return eventName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column memory_summary_by_host_by_event_name.EVENT_NAME
     *
     * @param eventName the value for memory_summary_by_host_by_event_name.EVENT_NAME
     *
     * @mbg.generated
     */
    public void setEventName(String eventName) {
        this.eventName = eventName == null ? null : eventName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column memory_summary_by_host_by_event_name.COUNT_ALLOC
     *
     * @return the value of memory_summary_by_host_by_event_name.COUNT_ALLOC
     *
     * @mbg.generated
     */
    public Long getCountAlloc() {
        return countAlloc;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column memory_summary_by_host_by_event_name.COUNT_ALLOC
     *
     * @param countAlloc the value for memory_summary_by_host_by_event_name.COUNT_ALLOC
     *
     * @mbg.generated
     */
    public void setCountAlloc(Long countAlloc) {
        this.countAlloc = countAlloc;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column memory_summary_by_host_by_event_name.COUNT_FREE
     *
     * @return the value of memory_summary_by_host_by_event_name.COUNT_FREE
     *
     * @mbg.generated
     */
    public Long getCountFree() {
        return countFree;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column memory_summary_by_host_by_event_name.COUNT_FREE
     *
     * @param countFree the value for memory_summary_by_host_by_event_name.COUNT_FREE
     *
     * @mbg.generated
     */
    public void setCountFree(Long countFree) {
        this.countFree = countFree;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column memory_summary_by_host_by_event_name.SUM_NUMBER_OF_BYTES_ALLOC
     *
     * @return the value of memory_summary_by_host_by_event_name.SUM_NUMBER_OF_BYTES_ALLOC
     *
     * @mbg.generated
     */
    public Long getSumNumberOfBytesAlloc() {
        return sumNumberOfBytesAlloc;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column memory_summary_by_host_by_event_name.SUM_NUMBER_OF_BYTES_ALLOC
     *
     * @param sumNumberOfBytesAlloc the value for memory_summary_by_host_by_event_name.SUM_NUMBER_OF_BYTES_ALLOC
     *
     * @mbg.generated
     */
    public void setSumNumberOfBytesAlloc(Long sumNumberOfBytesAlloc) {
        this.sumNumberOfBytesAlloc = sumNumberOfBytesAlloc;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column memory_summary_by_host_by_event_name.SUM_NUMBER_OF_BYTES_FREE
     *
     * @return the value of memory_summary_by_host_by_event_name.SUM_NUMBER_OF_BYTES_FREE
     *
     * @mbg.generated
     */
    public Long getSumNumberOfBytesFree() {
        return sumNumberOfBytesFree;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column memory_summary_by_host_by_event_name.SUM_NUMBER_OF_BYTES_FREE
     *
     * @param sumNumberOfBytesFree the value for memory_summary_by_host_by_event_name.SUM_NUMBER_OF_BYTES_FREE
     *
     * @mbg.generated
     */
    public void setSumNumberOfBytesFree(Long sumNumberOfBytesFree) {
        this.sumNumberOfBytesFree = sumNumberOfBytesFree;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column memory_summary_by_host_by_event_name.LOW_COUNT_USED
     *
     * @return the value of memory_summary_by_host_by_event_name.LOW_COUNT_USED
     *
     * @mbg.generated
     */
    public Long getLowCountUsed() {
        return lowCountUsed;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column memory_summary_by_host_by_event_name.LOW_COUNT_USED
     *
     * @param lowCountUsed the value for memory_summary_by_host_by_event_name.LOW_COUNT_USED
     *
     * @mbg.generated
     */
    public void setLowCountUsed(Long lowCountUsed) {
        this.lowCountUsed = lowCountUsed;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column memory_summary_by_host_by_event_name.CURRENT_COUNT_USED
     *
     * @return the value of memory_summary_by_host_by_event_name.CURRENT_COUNT_USED
     *
     * @mbg.generated
     */
    public Long getCurrentCountUsed() {
        return currentCountUsed;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column memory_summary_by_host_by_event_name.CURRENT_COUNT_USED
     *
     * @param currentCountUsed the value for memory_summary_by_host_by_event_name.CURRENT_COUNT_USED
     *
     * @mbg.generated
     */
    public void setCurrentCountUsed(Long currentCountUsed) {
        this.currentCountUsed = currentCountUsed;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column memory_summary_by_host_by_event_name.HIGH_COUNT_USED
     *
     * @return the value of memory_summary_by_host_by_event_name.HIGH_COUNT_USED
     *
     * @mbg.generated
     */
    public Long getHighCountUsed() {
        return highCountUsed;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column memory_summary_by_host_by_event_name.HIGH_COUNT_USED
     *
     * @param highCountUsed the value for memory_summary_by_host_by_event_name.HIGH_COUNT_USED
     *
     * @mbg.generated
     */
    public void setHighCountUsed(Long highCountUsed) {
        this.highCountUsed = highCountUsed;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column memory_summary_by_host_by_event_name.LOW_NUMBER_OF_BYTES_USED
     *
     * @return the value of memory_summary_by_host_by_event_name.LOW_NUMBER_OF_BYTES_USED
     *
     * @mbg.generated
     */
    public Long getLowNumberOfBytesUsed() {
        return lowNumberOfBytesUsed;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column memory_summary_by_host_by_event_name.LOW_NUMBER_OF_BYTES_USED
     *
     * @param lowNumberOfBytesUsed the value for memory_summary_by_host_by_event_name.LOW_NUMBER_OF_BYTES_USED
     *
     * @mbg.generated
     */
    public void setLowNumberOfBytesUsed(Long lowNumberOfBytesUsed) {
        this.lowNumberOfBytesUsed = lowNumberOfBytesUsed;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column memory_summary_by_host_by_event_name.CURRENT_NUMBER_OF_BYTES_USED
     *
     * @return the value of memory_summary_by_host_by_event_name.CURRENT_NUMBER_OF_BYTES_USED
     *
     * @mbg.generated
     */
    public Long getCurrentNumberOfBytesUsed() {
        return currentNumberOfBytesUsed;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column memory_summary_by_host_by_event_name.CURRENT_NUMBER_OF_BYTES_USED
     *
     * @param currentNumberOfBytesUsed the value for memory_summary_by_host_by_event_name.CURRENT_NUMBER_OF_BYTES_USED
     *
     * @mbg.generated
     */
    public void setCurrentNumberOfBytesUsed(Long currentNumberOfBytesUsed) {
        this.currentNumberOfBytesUsed = currentNumberOfBytesUsed;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column memory_summary_by_host_by_event_name.HIGH_NUMBER_OF_BYTES_USED
     *
     * @return the value of memory_summary_by_host_by_event_name.HIGH_NUMBER_OF_BYTES_USED
     *
     * @mbg.generated
     */
    public Long getHighNumberOfBytesUsed() {
        return highNumberOfBytesUsed;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column memory_summary_by_host_by_event_name.HIGH_NUMBER_OF_BYTES_USED
     *
     * @param highNumberOfBytesUsed the value for memory_summary_by_host_by_event_name.HIGH_NUMBER_OF_BYTES_USED
     *
     * @mbg.generated
     */
    public void setHighNumberOfBytesUsed(Long highNumberOfBytesUsed) {
        this.highNumberOfBytesUsed = highNumberOfBytesUsed;
    }
}