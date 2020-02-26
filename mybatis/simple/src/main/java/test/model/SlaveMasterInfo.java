package test.model;

/**
 * Database Table Remarks:
 *   Master Information
 *
 * This class was generated by MyBatis Generator.
 * This class corresponds to the database table slave_master_info
 */
public class SlaveMasterInfo {
    /**
     * Database Column Remarks:
     *   The channel on which the slave is connected to a source. Used in Multisource Replication
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column slave_master_info.Channel_name
     *
     * @mbg.generated
     */
    private String channelName;

    /**
     * Database Column Remarks:
     *   Number of lines in the file.
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column slave_master_info.Number_of_lines
     *
     * @mbg.generated
     */
    private Integer numberOfLines;

    /**
     * Database Column Remarks:
     *   The master log position of the last read event.
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column slave_master_info.Master_log_pos
     *
     * @mbg.generated
     */
    private Long masterLogPos;

    /**
     * Database Column Remarks:
     *   The host name of the master.
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column slave_master_info.Host
     *
     * @mbg.generated
     */
    private String host;

    /**
     * Database Column Remarks:
     *   The network port used to connect to the master.
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column slave_master_info.Port
     *
     * @mbg.generated
     */
    private Integer port;

    /**
     * Database Column Remarks:
     *   The period (in seconds) that the slave will wait before trying to reconnect to the master.
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column slave_master_info.Connect_retry
     *
     * @mbg.generated
     */
    private Integer connectRetry;

    /**
     * Database Column Remarks:
     *   Indicates whether the server supports SSL connections.
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column slave_master_info.Enabled_ssl
     *
     * @mbg.generated
     */
    private Boolean enabledSsl;

    /**
     * Database Column Remarks:
     *   Whether to verify the server certificate.
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column slave_master_info.Ssl_verify_server_cert
     *
     * @mbg.generated
     */
    private Boolean sslVerifyServerCert;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column slave_master_info.Heartbeat
     *
     * @mbg.generated
     */
    private Float heartbeat;

    /**
     * Database Column Remarks:
     *   Number of reconnect attempts, to the master, before giving up.
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column slave_master_info.Retry_count
     *
     * @mbg.generated
     */
    private Long retryCount;

    /**
     * Database Column Remarks:
     *   Indicates whether GTIDs will be used to retrieve events from the master.
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column slave_master_info.Enabled_auto_position
     *
     * @mbg.generated
     */
    private Boolean enabledAutoPosition;

    /**
     * Database Column Remarks:
     *   Preference to get public key from master.
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column slave_master_info.Get_public_key
     *
     * @mbg.generated
     */
    private Boolean getPublicKey;

    /**
     * Database Column Remarks:
     *   Compression algorithm supported for data transfer between master and slave.
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column slave_master_info.Master_compression_algorithm
     *
     * @mbg.generated
     */
    private String masterCompressionAlgorithm;

    /**
     * Database Column Remarks:
     *   Compression level associated with zstd compression algorithm.
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column slave_master_info.Master_zstd_compression_level
     *
     * @mbg.generated
     */
    private Integer masterZstdCompressionLevel;

    /**
     * Database Column Remarks:
     *   The name of the master binary log currently being read from the master.
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column slave_master_info.Master_log_name
     *
     * @mbg.generated
     */
    private String masterLogName;

    /**
     * Database Column Remarks:
     *   The user name used to connect to the master.
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column slave_master_info.User_name
     *
     * @mbg.generated
     */
    private String userName;

    /**
     * Database Column Remarks:
     *   The password used to connect to the master.
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column slave_master_info.User_password
     *
     * @mbg.generated
     */
    private String userPassword;

    /**
     * Database Column Remarks:
     *   The file used for the Certificate Authority (CA) certificate.
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column slave_master_info.Ssl_ca
     *
     * @mbg.generated
     */
    private String sslCa;

    /**
     * Database Column Remarks:
     *   The path to the Certificate Authority (CA) certificates.
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column slave_master_info.Ssl_capath
     *
     * @mbg.generated
     */
    private String sslCapath;

    /**
     * Database Column Remarks:
     *   The name of the SSL certificate file.
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column slave_master_info.Ssl_cert
     *
     * @mbg.generated
     */
    private String sslCert;

    /**
     * Database Column Remarks:
     *   The name of the cipher in use for the SSL connection.
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column slave_master_info.Ssl_cipher
     *
     * @mbg.generated
     */
    private String sslCipher;

    /**
     * Database Column Remarks:
     *   The name of the SSL key file.
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column slave_master_info.Ssl_key
     *
     * @mbg.generated
     */
    private String sslKey;

    /**
     * Database Column Remarks:
     *   Displays which interface is employed when connecting to the MySQL server
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column slave_master_info.Bind
     *
     * @mbg.generated
     */
    private String bind;

    /**
     * Database Column Remarks:
     *   The number of server IDs to be ignored, followed by the actual server IDs
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column slave_master_info.Ignored_server_ids
     *
     * @mbg.generated
     */
    private String ignoredServerIds;

    /**
     * Database Column Remarks:
     *   The master server uuid.
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column slave_master_info.Uuid
     *
     * @mbg.generated
     */
    private String uuid;

    /**
     * Database Column Remarks:
     *   The file used for the Certificate Revocation List (CRL)
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column slave_master_info.Ssl_crl
     *
     * @mbg.generated
     */
    private String sslCrl;

    /**
     * Database Column Remarks:
     *   The path used for Certificate Revocation List (CRL) files
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column slave_master_info.Ssl_crlpath
     *
     * @mbg.generated
     */
    private String sslCrlpath;

    /**
     * Database Column Remarks:
     *   Tls version
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column slave_master_info.Tls_version
     *
     * @mbg.generated
     */
    private String tlsVersion;

    /**
     * Database Column Remarks:
     *   The file containing public key of master server.
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column slave_master_info.Public_key_path
     *
     * @mbg.generated
     */
    private String publicKeyPath;

    /**
     * Database Column Remarks:
     *   Network namespace used for communication with the master server.
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column slave_master_info.Network_namespace
     *
     * @mbg.generated
     */
    private String networkNamespace;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column slave_master_info.Channel_name
     *
     * @return the value of slave_master_info.Channel_name
     *
     * @mbg.generated
     */
    public String getChannelName() {
        return channelName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column slave_master_info.Channel_name
     *
     * @param channelName the value for slave_master_info.Channel_name
     *
     * @mbg.generated
     */
    public void setChannelName(String channelName) {
        this.channelName = channelName == null ? null : channelName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column slave_master_info.Number_of_lines
     *
     * @return the value of slave_master_info.Number_of_lines
     *
     * @mbg.generated
     */
    public Integer getNumberOfLines() {
        return numberOfLines;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column slave_master_info.Number_of_lines
     *
     * @param numberOfLines the value for slave_master_info.Number_of_lines
     *
     * @mbg.generated
     */
    public void setNumberOfLines(Integer numberOfLines) {
        this.numberOfLines = numberOfLines;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column slave_master_info.Master_log_pos
     *
     * @return the value of slave_master_info.Master_log_pos
     *
     * @mbg.generated
     */
    public Long getMasterLogPos() {
        return masterLogPos;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column slave_master_info.Master_log_pos
     *
     * @param masterLogPos the value for slave_master_info.Master_log_pos
     *
     * @mbg.generated
     */
    public void setMasterLogPos(Long masterLogPos) {
        this.masterLogPos = masterLogPos;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column slave_master_info.Host
     *
     * @return the value of slave_master_info.Host
     *
     * @mbg.generated
     */
    public String getHost() {
        return host;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column slave_master_info.Host
     *
     * @param host the value for slave_master_info.Host
     *
     * @mbg.generated
     */
    public void setHost(String host) {
        this.host = host == null ? null : host.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column slave_master_info.Port
     *
     * @return the value of slave_master_info.Port
     *
     * @mbg.generated
     */
    public Integer getPort() {
        return port;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column slave_master_info.Port
     *
     * @param port the value for slave_master_info.Port
     *
     * @mbg.generated
     */
    public void setPort(Integer port) {
        this.port = port;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column slave_master_info.Connect_retry
     *
     * @return the value of slave_master_info.Connect_retry
     *
     * @mbg.generated
     */
    public Integer getConnectRetry() {
        return connectRetry;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column slave_master_info.Connect_retry
     *
     * @param connectRetry the value for slave_master_info.Connect_retry
     *
     * @mbg.generated
     */
    public void setConnectRetry(Integer connectRetry) {
        this.connectRetry = connectRetry;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column slave_master_info.Enabled_ssl
     *
     * @return the value of slave_master_info.Enabled_ssl
     *
     * @mbg.generated
     */
    public Boolean getEnabledSsl() {
        return enabledSsl;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column slave_master_info.Enabled_ssl
     *
     * @param enabledSsl the value for slave_master_info.Enabled_ssl
     *
     * @mbg.generated
     */
    public void setEnabledSsl(Boolean enabledSsl) {
        this.enabledSsl = enabledSsl;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column slave_master_info.Ssl_verify_server_cert
     *
     * @return the value of slave_master_info.Ssl_verify_server_cert
     *
     * @mbg.generated
     */
    public Boolean getSslVerifyServerCert() {
        return sslVerifyServerCert;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column slave_master_info.Ssl_verify_server_cert
     *
     * @param sslVerifyServerCert the value for slave_master_info.Ssl_verify_server_cert
     *
     * @mbg.generated
     */
    public void setSslVerifyServerCert(Boolean sslVerifyServerCert) {
        this.sslVerifyServerCert = sslVerifyServerCert;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column slave_master_info.Heartbeat
     *
     * @return the value of slave_master_info.Heartbeat
     *
     * @mbg.generated
     */
    public Float getHeartbeat() {
        return heartbeat;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column slave_master_info.Heartbeat
     *
     * @param heartbeat the value for slave_master_info.Heartbeat
     *
     * @mbg.generated
     */
    public void setHeartbeat(Float heartbeat) {
        this.heartbeat = heartbeat;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column slave_master_info.Retry_count
     *
     * @return the value of slave_master_info.Retry_count
     *
     * @mbg.generated
     */
    public Long getRetryCount() {
        return retryCount;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column slave_master_info.Retry_count
     *
     * @param retryCount the value for slave_master_info.Retry_count
     *
     * @mbg.generated
     */
    public void setRetryCount(Long retryCount) {
        this.retryCount = retryCount;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column slave_master_info.Enabled_auto_position
     *
     * @return the value of slave_master_info.Enabled_auto_position
     *
     * @mbg.generated
     */
    public Boolean getEnabledAutoPosition() {
        return enabledAutoPosition;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column slave_master_info.Enabled_auto_position
     *
     * @param enabledAutoPosition the value for slave_master_info.Enabled_auto_position
     *
     * @mbg.generated
     */
    public void setEnabledAutoPosition(Boolean enabledAutoPosition) {
        this.enabledAutoPosition = enabledAutoPosition;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column slave_master_info.Get_public_key
     *
     * @return the value of slave_master_info.Get_public_key
     *
     * @mbg.generated
     */
    public Boolean getGetPublicKey() {
        return getPublicKey;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column slave_master_info.Get_public_key
     *
     * @param getPublicKey the value for slave_master_info.Get_public_key
     *
     * @mbg.generated
     */
    public void setGetPublicKey(Boolean getPublicKey) {
        this.getPublicKey = getPublicKey;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column slave_master_info.Master_compression_algorithm
     *
     * @return the value of slave_master_info.Master_compression_algorithm
     *
     * @mbg.generated
     */
    public String getMasterCompressionAlgorithm() {
        return masterCompressionAlgorithm;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column slave_master_info.Master_compression_algorithm
     *
     * @param masterCompressionAlgorithm the value for slave_master_info.Master_compression_algorithm
     *
     * @mbg.generated
     */
    public void setMasterCompressionAlgorithm(String masterCompressionAlgorithm) {
        this.masterCompressionAlgorithm = masterCompressionAlgorithm == null ? null : masterCompressionAlgorithm.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column slave_master_info.Master_zstd_compression_level
     *
     * @return the value of slave_master_info.Master_zstd_compression_level
     *
     * @mbg.generated
     */
    public Integer getMasterZstdCompressionLevel() {
        return masterZstdCompressionLevel;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column slave_master_info.Master_zstd_compression_level
     *
     * @param masterZstdCompressionLevel the value for slave_master_info.Master_zstd_compression_level
     *
     * @mbg.generated
     */
    public void setMasterZstdCompressionLevel(Integer masterZstdCompressionLevel) {
        this.masterZstdCompressionLevel = masterZstdCompressionLevel;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column slave_master_info.Master_log_name
     *
     * @return the value of slave_master_info.Master_log_name
     *
     * @mbg.generated
     */
    public String getMasterLogName() {
        return masterLogName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column slave_master_info.Master_log_name
     *
     * @param masterLogName the value for slave_master_info.Master_log_name
     *
     * @mbg.generated
     */
    public void setMasterLogName(String masterLogName) {
        this.masterLogName = masterLogName == null ? null : masterLogName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column slave_master_info.User_name
     *
     * @return the value of slave_master_info.User_name
     *
     * @mbg.generated
     */
    public String getUserName() {
        return userName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column slave_master_info.User_name
     *
     * @param userName the value for slave_master_info.User_name
     *
     * @mbg.generated
     */
    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column slave_master_info.User_password
     *
     * @return the value of slave_master_info.User_password
     *
     * @mbg.generated
     */
    public String getUserPassword() {
        return userPassword;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column slave_master_info.User_password
     *
     * @param userPassword the value for slave_master_info.User_password
     *
     * @mbg.generated
     */
    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword == null ? null : userPassword.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column slave_master_info.Ssl_ca
     *
     * @return the value of slave_master_info.Ssl_ca
     *
     * @mbg.generated
     */
    public String getSslCa() {
        return sslCa;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column slave_master_info.Ssl_ca
     *
     * @param sslCa the value for slave_master_info.Ssl_ca
     *
     * @mbg.generated
     */
    public void setSslCa(String sslCa) {
        this.sslCa = sslCa == null ? null : sslCa.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column slave_master_info.Ssl_capath
     *
     * @return the value of slave_master_info.Ssl_capath
     *
     * @mbg.generated
     */
    public String getSslCapath() {
        return sslCapath;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column slave_master_info.Ssl_capath
     *
     * @param sslCapath the value for slave_master_info.Ssl_capath
     *
     * @mbg.generated
     */
    public void setSslCapath(String sslCapath) {
        this.sslCapath = sslCapath == null ? null : sslCapath.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column slave_master_info.Ssl_cert
     *
     * @return the value of slave_master_info.Ssl_cert
     *
     * @mbg.generated
     */
    public String getSslCert() {
        return sslCert;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column slave_master_info.Ssl_cert
     *
     * @param sslCert the value for slave_master_info.Ssl_cert
     *
     * @mbg.generated
     */
    public void setSslCert(String sslCert) {
        this.sslCert = sslCert == null ? null : sslCert.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column slave_master_info.Ssl_cipher
     *
     * @return the value of slave_master_info.Ssl_cipher
     *
     * @mbg.generated
     */
    public String getSslCipher() {
        return sslCipher;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column slave_master_info.Ssl_cipher
     *
     * @param sslCipher the value for slave_master_info.Ssl_cipher
     *
     * @mbg.generated
     */
    public void setSslCipher(String sslCipher) {
        this.sslCipher = sslCipher == null ? null : sslCipher.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column slave_master_info.Ssl_key
     *
     * @return the value of slave_master_info.Ssl_key
     *
     * @mbg.generated
     */
    public String getSslKey() {
        return sslKey;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column slave_master_info.Ssl_key
     *
     * @param sslKey the value for slave_master_info.Ssl_key
     *
     * @mbg.generated
     */
    public void setSslKey(String sslKey) {
        this.sslKey = sslKey == null ? null : sslKey.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column slave_master_info.Bind
     *
     * @return the value of slave_master_info.Bind
     *
     * @mbg.generated
     */
    public String getBind() {
        return bind;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column slave_master_info.Bind
     *
     * @param bind the value for slave_master_info.Bind
     *
     * @mbg.generated
     */
    public void setBind(String bind) {
        this.bind = bind == null ? null : bind.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column slave_master_info.Ignored_server_ids
     *
     * @return the value of slave_master_info.Ignored_server_ids
     *
     * @mbg.generated
     */
    public String getIgnoredServerIds() {
        return ignoredServerIds;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column slave_master_info.Ignored_server_ids
     *
     * @param ignoredServerIds the value for slave_master_info.Ignored_server_ids
     *
     * @mbg.generated
     */
    public void setIgnoredServerIds(String ignoredServerIds) {
        this.ignoredServerIds = ignoredServerIds == null ? null : ignoredServerIds.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column slave_master_info.Uuid
     *
     * @return the value of slave_master_info.Uuid
     *
     * @mbg.generated
     */
    public String getUuid() {
        return uuid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column slave_master_info.Uuid
     *
     * @param uuid the value for slave_master_info.Uuid
     *
     * @mbg.generated
     */
    public void setUuid(String uuid) {
        this.uuid = uuid == null ? null : uuid.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column slave_master_info.Ssl_crl
     *
     * @return the value of slave_master_info.Ssl_crl
     *
     * @mbg.generated
     */
    public String getSslCrl() {
        return sslCrl;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column slave_master_info.Ssl_crl
     *
     * @param sslCrl the value for slave_master_info.Ssl_crl
     *
     * @mbg.generated
     */
    public void setSslCrl(String sslCrl) {
        this.sslCrl = sslCrl == null ? null : sslCrl.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column slave_master_info.Ssl_crlpath
     *
     * @return the value of slave_master_info.Ssl_crlpath
     *
     * @mbg.generated
     */
    public String getSslCrlpath() {
        return sslCrlpath;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column slave_master_info.Ssl_crlpath
     *
     * @param sslCrlpath the value for slave_master_info.Ssl_crlpath
     *
     * @mbg.generated
     */
    public void setSslCrlpath(String sslCrlpath) {
        this.sslCrlpath = sslCrlpath == null ? null : sslCrlpath.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column slave_master_info.Tls_version
     *
     * @return the value of slave_master_info.Tls_version
     *
     * @mbg.generated
     */
    public String getTlsVersion() {
        return tlsVersion;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column slave_master_info.Tls_version
     *
     * @param tlsVersion the value for slave_master_info.Tls_version
     *
     * @mbg.generated
     */
    public void setTlsVersion(String tlsVersion) {
        this.tlsVersion = tlsVersion == null ? null : tlsVersion.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column slave_master_info.Public_key_path
     *
     * @return the value of slave_master_info.Public_key_path
     *
     * @mbg.generated
     */
    public String getPublicKeyPath() {
        return publicKeyPath;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column slave_master_info.Public_key_path
     *
     * @param publicKeyPath the value for slave_master_info.Public_key_path
     *
     * @mbg.generated
     */
    public void setPublicKeyPath(String publicKeyPath) {
        this.publicKeyPath = publicKeyPath == null ? null : publicKeyPath.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column slave_master_info.Network_namespace
     *
     * @return the value of slave_master_info.Network_namespace
     *
     * @mbg.generated
     */
    public String getNetworkNamespace() {
        return networkNamespace;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column slave_master_info.Network_namespace
     *
     * @param networkNamespace the value for slave_master_info.Network_namespace
     *
     * @mbg.generated
     */
    public void setNetworkNamespace(String networkNamespace) {
        this.networkNamespace = networkNamespace == null ? null : networkNamespace.trim();
    }
}