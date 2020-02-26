package test.model;

import java.math.BigDecimal;

/**
 * Database Table Remarks:
 *   VIEW
 *
 * This class was generated by MyBatis Generator.
 * This class corresponds to the database table innodb_buffer_stats_by_table
 */
public class InnodbBufferStatsByTable {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column innodb_buffer_stats_by_table.pages
     *
     * @mbg.generated
     */
    private Long pages;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column innodb_buffer_stats_by_table.pages_hashed
     *
     * @mbg.generated
     */
    private Long pagesHashed;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column innodb_buffer_stats_by_table.pages_old
     *
     * @mbg.generated
     */
    private Long pagesOld;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column innodb_buffer_stats_by_table.rows_cached
     *
     * @mbg.generated
     */
    private BigDecimal rowsCached;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column innodb_buffer_stats_by_table.object_schema
     *
     * @mbg.generated
     */
    private String objectSchema;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column innodb_buffer_stats_by_table.object_name
     *
     * @mbg.generated
     */
    private String objectName;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column innodb_buffer_stats_by_table.allocated
     *
     * @mbg.generated
     */
    private String allocated;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column innodb_buffer_stats_by_table.data
     *
     * @mbg.generated
     */
    private String data;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column innodb_buffer_stats_by_table.pages
     *
     * @return the value of innodb_buffer_stats_by_table.pages
     *
     * @mbg.generated
     */
    public Long getPages() {
        return pages;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column innodb_buffer_stats_by_table.pages
     *
     * @param pages the value for innodb_buffer_stats_by_table.pages
     *
     * @mbg.generated
     */
    public void setPages(Long pages) {
        this.pages = pages;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column innodb_buffer_stats_by_table.pages_hashed
     *
     * @return the value of innodb_buffer_stats_by_table.pages_hashed
     *
     * @mbg.generated
     */
    public Long getPagesHashed() {
        return pagesHashed;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column innodb_buffer_stats_by_table.pages_hashed
     *
     * @param pagesHashed the value for innodb_buffer_stats_by_table.pages_hashed
     *
     * @mbg.generated
     */
    public void setPagesHashed(Long pagesHashed) {
        this.pagesHashed = pagesHashed;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column innodb_buffer_stats_by_table.pages_old
     *
     * @return the value of innodb_buffer_stats_by_table.pages_old
     *
     * @mbg.generated
     */
    public Long getPagesOld() {
        return pagesOld;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column innodb_buffer_stats_by_table.pages_old
     *
     * @param pagesOld the value for innodb_buffer_stats_by_table.pages_old
     *
     * @mbg.generated
     */
    public void setPagesOld(Long pagesOld) {
        this.pagesOld = pagesOld;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column innodb_buffer_stats_by_table.rows_cached
     *
     * @return the value of innodb_buffer_stats_by_table.rows_cached
     *
     * @mbg.generated
     */
    public BigDecimal getRowsCached() {
        return rowsCached;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column innodb_buffer_stats_by_table.rows_cached
     *
     * @param rowsCached the value for innodb_buffer_stats_by_table.rows_cached
     *
     * @mbg.generated
     */
    public void setRowsCached(BigDecimal rowsCached) {
        this.rowsCached = rowsCached;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column innodb_buffer_stats_by_table.object_schema
     *
     * @return the value of innodb_buffer_stats_by_table.object_schema
     *
     * @mbg.generated
     */
    public String getObjectSchema() {
        return objectSchema;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column innodb_buffer_stats_by_table.object_schema
     *
     * @param objectSchema the value for innodb_buffer_stats_by_table.object_schema
     *
     * @mbg.generated
     */
    public void setObjectSchema(String objectSchema) {
        this.objectSchema = objectSchema == null ? null : objectSchema.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column innodb_buffer_stats_by_table.object_name
     *
     * @return the value of innodb_buffer_stats_by_table.object_name
     *
     * @mbg.generated
     */
    public String getObjectName() {
        return objectName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column innodb_buffer_stats_by_table.object_name
     *
     * @param objectName the value for innodb_buffer_stats_by_table.object_name
     *
     * @mbg.generated
     */
    public void setObjectName(String objectName) {
        this.objectName = objectName == null ? null : objectName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column innodb_buffer_stats_by_table.allocated
     *
     * @return the value of innodb_buffer_stats_by_table.allocated
     *
     * @mbg.generated
     */
    public String getAllocated() {
        return allocated;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column innodb_buffer_stats_by_table.allocated
     *
     * @param allocated the value for innodb_buffer_stats_by_table.allocated
     *
     * @mbg.generated
     */
    public void setAllocated(String allocated) {
        this.allocated = allocated == null ? null : allocated.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column innodb_buffer_stats_by_table.data
     *
     * @return the value of innodb_buffer_stats_by_table.data
     *
     * @mbg.generated
     */
    public String getData() {
        return data;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column innodb_buffer_stats_by_table.data
     *
     * @param data the value for innodb_buffer_stats_by_table.data
     *
     * @mbg.generated
     */
    public void setData(String data) {
        this.data = data == null ? null : data.trim();
    }
}