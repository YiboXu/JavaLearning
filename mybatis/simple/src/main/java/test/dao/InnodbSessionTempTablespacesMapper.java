package test.dao;

import java.util.List;
import test.model.InnodbSessionTempTablespaces;

public interface InnodbSessionTempTablespacesMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table INNODB_SESSION_TEMP_TABLESPACES
     *
     * @mbg.generated
     */
    int insert(InnodbSessionTempTablespaces record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table INNODB_SESSION_TEMP_TABLESPACES
     *
     * @mbg.generated
     */
    List<InnodbSessionTempTablespaces> selectAll();
}