package test.model;

/**
 *
 * This class was generated by MyBatis Generator.
 * This class corresponds to the database table keyring_keys
 */
public class KeyringKeys {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column keyring_keys.KEY_ID
     *
     * @mbg.generated
     */
    private String keyId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column keyring_keys.KEY_OWNER
     *
     * @mbg.generated
     */
    private String keyOwner;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column keyring_keys.BACKEND_KEY_ID
     *
     * @mbg.generated
     */
    private String backendKeyId;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column keyring_keys.KEY_ID
     *
     * @return the value of keyring_keys.KEY_ID
     *
     * @mbg.generated
     */
    public String getKeyId() {
        return keyId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column keyring_keys.KEY_ID
     *
     * @param keyId the value for keyring_keys.KEY_ID
     *
     * @mbg.generated
     */
    public void setKeyId(String keyId) {
        this.keyId = keyId == null ? null : keyId.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column keyring_keys.KEY_OWNER
     *
     * @return the value of keyring_keys.KEY_OWNER
     *
     * @mbg.generated
     */
    public String getKeyOwner() {
        return keyOwner;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column keyring_keys.KEY_OWNER
     *
     * @param keyOwner the value for keyring_keys.KEY_OWNER
     *
     * @mbg.generated
     */
    public void setKeyOwner(String keyOwner) {
        this.keyOwner = keyOwner == null ? null : keyOwner.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column keyring_keys.BACKEND_KEY_ID
     *
     * @return the value of keyring_keys.BACKEND_KEY_ID
     *
     * @mbg.generated
     */
    public String getBackendKeyId() {
        return backendKeyId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column keyring_keys.BACKEND_KEY_ID
     *
     * @param backendKeyId the value for keyring_keys.BACKEND_KEY_ID
     *
     * @mbg.generated
     */
    public void setBackendKeyId(String backendKeyId) {
        this.backendKeyId = backendKeyId == null ? null : backendKeyId.trim();
    }
}