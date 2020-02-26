package tk.mybatis.simple.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import tk.mybatis.simple.model.SysRole;
import tk.mybatis.simple.model.SysUser;

public interface UserMapper {

	/**
	 * Find User through ID
	 * 
	 * @param id
	 * @return
	 */
	SysUser selectById(Long id);
	
	/**
	 * Find all Users
	 * 
	 * @return
	 */
	List<SysUser> selectAll();
	
	/**
	 * Fetch Role token by a user
	 * 
	 * @param ID
	 * @return
	 */
	List<SysRole> selectRolesByUserId(Long ID);
	
	/**
	 * Insert new user 
	 * 
	 * @param sysUser
	 * @return
	 */
	int insert(SysUser sysUser);
	
	/**
	 * Insert new user with DB supporting auto increase key
	 * 
	 * @param sysUser
	 * @return
	 */
	int insert2(SysUser sysUser);
	
	/**
	 * Insert new user with DB not supporting auto increase key
	 * it can also be used with DB supporting auto increase key
	 * 
	 * @param sysUser
	 * @return
	 */
	int insert3(SysUser sysUser);
	
	/**
	 * Update User by ID
	 * 
	 * @param sysUser
	 * @return
	 */
	int updateById(SysUser sysUser);
	
	/**
	 * Delete User by ID
	 * 
	 * @param id
	 * @return
	 */
	int deleteById(Long id);
	
	/**
	 * Select user roles using user id and role enabled
	 * 
	 * @param userId
	 * @param enabled
	 * @return
	 */
	List<SysRole> selectRolesByUserIdAndRoleEnabled(
			@Param("userId") Long userId, @Param("enabled") Integer enabled);
	
	/**
	 * Select user roles using user bean and role bean
	 * 
	 * @param sysUser
	 * @param sysRole
	 * @return
	 */
	List<SysRole> selectRolesByUserBeanAndRoleBean(
			@Param("sysUser") SysUser sysUser, @Param("sysRole")SysRole sysRole);
	
	/**
	 * Select user by dynamic condition
	 * 
	 * @param sysUser
	 * @return
	 */
	List<SysUser> selectByUser(SysUser sysUser);
	
	/**
	 * Update user by dynamic condition
	 * 
	 * @param sysUser
	 * @return
	 */
	int updateByIdSelective(SysUser sysUser);
	
	
	/**
	 * Select user by ID or username
	 * 
	 * @param sysUser
	 * @return
	 */
	SysUser selectByIdOrUserName(SysUser sysUser);
	
	/**
	 * 
	 * Selese SysUser by a list of ID
	 * 
	 * @param idList
	 * @return
	 */
	List<SysUser> selectByIdList(List<Long> idList);
	
	/**
	 * Select SysUser by a group of parameter 
	 * 
	 * @param id
	 * @return
	 */
	List<SysUser> selectByIdList1(@Param("ids") long... id);
	
	/**
	 * Select SysUser by a map
	 * 
	 * @param ids
	 * @return
	 */
	List<SysUser> selectByIdList2(Map<String, Long[]> ids);
	
	/**
	 * Insert SysUser by list
	 * 
	 * @param userList
	 * @return
	 */
	int insertByList(List<SysUser> userList);
	
	/**
	 * 
	 * Update SysUser by map
	 * 
	 * @param user
	 * @return
	 */
	int updateByMap(Map<String,Object> user);
	
	/**
	 * Select user and role by id
	 * 
	 * @param id
	 * @return
	 */
	SysUser selectUserAndRoldById(Long id);
	
	/**
	 * Select user and role by id
	 * 
	 * @param id
	 * @return
	 */
	SysUser selectUserAndRoldById2(Long id);
	
	/**
	 * Select user and role by id
	 * 
	 * @param id
	 * @return
	 */
	SysUser selectUserAndRoleByidSelect(Long id);
}
