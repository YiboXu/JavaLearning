package test.model;

import java.util.Date;

/**
 * Database Table Remarks:
 *   Column privileges
 *
 * This class was generated by MyBatis Generator.
 * This class corresponds to the database table columns_priv
 */
public class ColumnsPriv {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column columns_priv.Host
     *
     * @mbg.generated
     */
    private String host;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column columns_priv.Db
     *
     * @mbg.generated
     */
    private String db;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column columns_priv.User
     *
     * @mbg.generated
     */
    private String user;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column columns_priv.Table_name
     *
     * @mbg.generated
     */
    private String tableName;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column columns_priv.Column_name
     *
     * @mbg.generated
     */
    private String columnName;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column columns_priv.Timestamp
     *
     * @mbg.generated
     */
    private Date timestamp;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column columns_priv.Column_priv
     *
     * @mbg.generated
     */
    private String columnPriv;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column columns_priv.Host
     *
     * @return the value of columns_priv.Host
     *
     * @mbg.generated
     */
    public String getHost() {
        return host;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column columns_priv.Host
     *
     * @param host the value for columns_priv.Host
     *
     * @mbg.generated
     */
    public void setHost(String host) {
        this.host = host == null ? null : host.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column columns_priv.Db
     *
     * @return the value of columns_priv.Db
     *
     * @mbg.generated
     */
    public String getDb() {
        return db;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column columns_priv.Db
     *
     * @param db the value for columns_priv.Db
     *
     * @mbg.generated
     */
    public void setDb(String db) {
        this.db = db == null ? null : db.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column columns_priv.User
     *
     * @return the value of columns_priv.User
     *
     * @mbg.generated
     */
    public String getUser() {
        return user;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column columns_priv.User
     *
     * @param user the value for columns_priv.User
     *
     * @mbg.generated
     */
    public void setUser(String user) {
        this.user = user == null ? null : user.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column columns_priv.Table_name
     *
     * @return the value of columns_priv.Table_name
     *
     * @mbg.generated
     */
    public String getTableName() {
        return tableName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column columns_priv.Table_name
     *
     * @param tableName the value for columns_priv.Table_name
     *
     * @mbg.generated
     */
    public void setTableName(String tableName) {
        this.tableName = tableName == null ? null : tableName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column columns_priv.Column_name
     *
     * @return the value of columns_priv.Column_name
     *
     * @mbg.generated
     */
    public String getColumnName() {
        return columnName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column columns_priv.Column_name
     *
     * @param columnName the value for columns_priv.Column_name
     *
     * @mbg.generated
     */
    public void setColumnName(String columnName) {
        this.columnName = columnName == null ? null : columnName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column columns_priv.Timestamp
     *
     * @return the value of columns_priv.Timestamp
     *
     * @mbg.generated
     */
    public Date getTimestamp() {
        return timestamp;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column columns_priv.Timestamp
     *
     * @param timestamp the value for columns_priv.Timestamp
     *
     * @mbg.generated
     */
    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column columns_priv.Column_priv
     *
     * @return the value of columns_priv.Column_priv
     *
     * @mbg.generated
     */
    public String getColumnPriv() {
        return columnPriv;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column columns_priv.Column_priv
     *
     * @param columnPriv the value for columns_priv.Column_priv
     *
     * @mbg.generated
     */
    public void setColumnPriv(String columnPriv) {
        this.columnPriv = columnPriv == null ? null : columnPriv.trim();
    }
}