package tk.mybatis.simple.mapper;

import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.junit.Assert;
import org.junit.Test;

import tk.mybatis.simple.model.SysRole;
import tk.mybatis.simple.model.SysUser;

public class UserMapperTest extends BaseMapperTest{

	@Test
	public void testSelectById() {
		SqlSession sqlSession = getSqlSession();
		
		try {
			UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
		
			SysUser sysUser = userMapper.selectById(1l);
		
			Assert.assertNotNull(sysUser);
			Assert.assertEquals("admin", sysUser.getUserName());
		}finally {
			sqlSession.close();
		}
	}
	
	@Test
	public void testSelectAll() {
		SqlSession sqlSession = getSqlSession();
		
		try {
			UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
		
			List<SysUser> users = userMapper.selectAll();
		
			Assert.assertNotNull(users);
			Assert.assertTrue(users.size()>0);
		}finally {
			sqlSession.close();
		}
	}
	
	@Test
	public void testSelectRolesByUserId() {
		SqlSession sqlSession = getSqlSession();
		
		try {
			UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
		
			List<SysRole> roles = userMapper.selectRolesByUserId(1l);
		
			Assert.assertNotNull(roles);
			Assert.assertTrue(roles.size()>0);
		}finally {
			sqlSession.close();
		}
	}
	
	@Test
	public void testInsert() {
		SqlSession sqlSession = getSqlSession();
		
		try {
			UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
			
			SysUser user = new SysUser();
			user.setUserName("test1");
			user.setUserPassword("123");
			user.setUserEmail("test@qq.com");
			user.setUserInfo("test user1");
			user.setCreateTime(new Date());
			user.setHeadImg(new byte[] {1,2,3});
			
			int n = userMapper.insert(user);
		
			Assert.assertEquals(1, n);
			Assert.assertNull(user.getId());
		}finally {
			sqlSession.rollback();
			sqlSession.close();
		}
	}
	
	@Test
	public void testInsert2() {
		SqlSession sqlSession = getSqlSession();
		
		try {
			UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
			
			SysUser user = new SysUser();
			user.setUserName("test1");
			user.setUserPassword("123");
			user.setUserEmail("test@qq.com");
			user.setUserInfo("test user1");
			user.setCreateTime(new Date());
			user.setHeadImg(new byte[] {1,2,3});
			
			int n = userMapper.insert2(user);
		
			Assert.assertEquals(1, n);
			Assert.assertNotNull(user.getId());
		}finally {
			sqlSession.rollback();
			sqlSession.close();
		}
	}
	
	@Test
	public void testInsert3() {
		SqlSession sqlSession = getSqlSession();
		
		try {
			UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
			
			SysUser user = new SysUser();
			user.setUserName("test1");
			user.setUserPassword("123");
			user.setUserEmail("test@qq.com");
			user.setUserInfo("test user1");
			user.setCreateTime(new Date());
			user.setHeadImg(new byte[] {1,2,3});
			
			int n = userMapper.insert3(user);
		
			Assert.assertEquals(1, n);
			Assert.assertNotNull(user.getId());
		}finally {
			sqlSession.rollback();
			sqlSession.close();
		}
	}
	
	@Test
	public void testUpdateById() {
		SqlSession sqlSession = getSqlSession();
		
		try {
			UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
			
			SysUser sysUser = userMapper.selectById(1l);
			sysUser.setUserName("admin_test");
			sysUser.setUserEmail("test@163.com");
			
			int n = userMapper.updateById(sysUser);
		
			SysUser newUser = userMapper.selectById(1l);
			
			Assert.assertEquals(1, n);
			Assert.assertEquals("admin_test", newUser.getUserName());
		}finally {
			sqlSession.rollback();
			sqlSession.close();
		}
	}
	
	@Test
	public void testDeleteById() {
		SqlSession sqlSession = getSqlSession();
		
		try {
			UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
			
			SysUser user = userMapper.selectById(1l);
			
			Assert.assertNotNull(user);
			
			int n = userMapper.deleteById(1l);
		
			user = userMapper.selectById(1l);
			
			Assert.assertEquals(1, n);
			Assert.assertNull(user);
		}finally {
			sqlSession.rollback();
			sqlSession.close();
		}
	}
	
	@Test
	public void testSelectRolesByUserIdAndRoleEnabled() {
		SqlSession sqlSession = getSqlSession();
		
		try {
			UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
			
			List<SysRole> roles = userMapper.selectRolesByUserIdAndRoleEnabled(1l, 1);
			
			Assert.assertNotNull(roles);
			Assert.assertTrue(roles.size() > 0);
		}finally {
			sqlSession.close();
		}
	}
	
	@Test
	public void testSelectRolesByUserBeanAndRoleBean() {
		SqlSession sqlSession = getSqlSession();
		
		try {
			UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
			
			SysUser sysUser = userMapper.selectById(1l);
			SysRole sysRole = new SysRole();
			sysRole.setEnabled(1);
			
			List<SysRole> roles = userMapper.selectRolesByUserBeanAndRoleBean(sysUser, sysRole);
			
			Assert.assertNotNull(roles);
			Assert.assertTrue(roles.size() > 0);
		}finally {
			sqlSession.close();
		}
	}
	
	@Test
	public void testSelectByUser() {
		SqlSession sqlSession = getSqlSession();
		
		try {
			UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
			SysUser user = new SysUser();
			user.setUserName("ad");
			
			List<SysUser> userList = userMapper.selectByUser(user);
			
			Assert.assertTrue(userList.size() > 0);
			
			user = new SysUser();
			user.setUserEmail("test@mybatis.tk");
			userList = userMapper.selectByUser(user);
			
			Assert.assertTrue(userList.size() > 0);
			
			user.setUserName("ad");
			user.setUserEmail("test@mybatis.tk");
			
			userList = userMapper.selectByUser(user);
			
			Assert.assertTrue(userList.size() == 0);
		}finally {
			sqlSession.close();
		}
	}
	
	@Test
	public void testUpdateByIdSelective() {
		SqlSession sqlSession = getSqlSession();
		
		try {
			UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
			SysUser user = new SysUser();
			user.setId(1l);
			user.setUserName("admin1");
			
			user.setUserEmail("admin1@mybatis.tk");
			
			int n = userMapper.updateByIdSelective(user);
			
			Assert.assertEquals(1,n);
			
			user = userMapper.selectById(1l);
			Assert.assertEquals("admin1",user.getUserName());
			Assert.assertEquals("admin1@mybatis.tk",user.getUserEmail());
		}finally {
			sqlSession.rollback();
			sqlSession.close();
		}
	}
	
	@Test
	public void testInsert2Selective() {
		SqlSession sqlSession = getSqlSession();
		
		try {
			UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
			
			SysUser user = new SysUser();
			user.setUserName("test1");
			user.setUserPassword("123");
			user.setUserInfo("test user1");
			user.setCreateTime(new Date());
			user.setHeadImg(new byte[] {1,2,3});
			
			int n = userMapper.insert2(user);
		
			Assert.assertEquals(1, n);
			Assert.assertNotNull(user.getId());
			user = userMapper.selectById(user.getId());
			Assert.assertEquals("dummy@mybatis.tk", user.getUserEmail());
		}finally {
			sqlSession.rollback();
			sqlSession.close();
		}
	}
	
	@Test
	public void testSelectByIdOrUserName() {
		SqlSession sqlSession = getSqlSession();
		
		try {
			UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
			
			//test select by id
			SysUser user = new SysUser();
			user.setId(1l);
			
			user = userMapper.selectByIdOrUserName(user);
			
			Assert.assertNotNull(user);
			Assert.assertEquals((Long)1l, user.getId());
			Assert.assertEquals("admin", user.getUserName());
			
			//test select by username
			user = new SysUser();
			user.setUserName("admin");
			
			user = userMapper.selectByIdOrUserName(user);
			
			Assert.assertNotNull(user);
			Assert.assertEquals((Long)1l, user.getId());
			Assert.assertEquals("admin", user.getUserName());
		}finally {
			sqlSession.close();
		}
	}
	
	@Test
	public void testSelectByIdList() {
		SqlSession sqlSession = getSqlSession();
		
		try {
			UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
			
			List<Long> idList = Arrays.asList(1l,1001l);
			
			List<SysUser> userList = userMapper.selectByIdList(idList);
			
			Assert.assertTrue(userList.size() > 1);
		}finally {
			sqlSession.close();
		}
	}
	
	@Test
	public void testSelectByIdList1() {
		SqlSession sqlSession = getSqlSession();
		
		try {
			UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
			
			List<SysUser> userList = userMapper.selectByIdList1(1l,1001l);
			
			Assert.assertTrue(userList.size() > 1);
		}finally {
			sqlSession.close();
		}
	}
	
	@Test
	public void testSelectByIdList2() {
		SqlSession sqlSession = getSqlSession();
		
		try {
			UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
			
			Long[] ids = new Long[] {1l,1001l};
			Map<String, Long[]> map = new HashMap<String, Long[]>();
			map.put("ids", ids);
			
			List<SysUser> userList = userMapper.selectByIdList2(map);
			
			Assert.assertTrue(userList.size() > 1);
		}finally {
			sqlSession.close();
		}
	}
	
	@Test
	public void testInsertByList() {
		SqlSession sqlSession = getSqlSession();
		
		try {
			UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
			List<SysUser> userList = userMapper.selectByIdList1(1l,1001l);
			
			userList.get(0).setId(null);
			userList.get(1).setId(null);
			
			int n = userMapper.insertByList(userList);
			
			Assert.assertEquals(2, n);
			//System.out.println(userList.get(0).getId());
			//System.out.println(userList.get(1).getId());
			Assert.assertNotNull(userList.get(0));
			Assert.assertNotNull(userList.get(1));
		}finally {
			sqlSession.rollback();
			sqlSession.close();
		}
	}
	
	@Test
	public void testUpdateByMap() {
		SqlSession sqlSession = getSqlSession();
		
		try {
			UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
			SysUser user = userMapper.selectById(1l);
			
			Map<String,Object> map = new HashMap<String, Object>();
			map.put("id",(Long)1l);
			map.put("user_email", "xx@163.com");
			
			userMapper.updateByMap(map);
			
			user = userMapper.selectById(1l);
			
			Assert.assertNotNull(user);
			Assert.assertEquals("xx@163.com",user.getUserEmail());
		}finally {
			sqlSession.rollback();
			sqlSession.close();
		}
	}
	
	@Test
	public void testSelectUserAndRoldById() {
		SqlSession sqlSession = getSqlSession();
		
		try {
			UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
			SysUser user = userMapper.selectUserAndRoldById(1001l);
			
			Assert.assertNotNull(user);
			Assert.assertEquals("test", user.getUserName());
			Assert.assertEquals("user", user.getRole().getRoleName());
		}finally {
			sqlSession.close();
		}
	}
	
	@Test
	public void testSelectUserAndRoldById2() {
		SqlSession sqlSession = getSqlSession();
		
		try {
			UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
			SysUser user = userMapper.selectUserAndRoldById2(1001l);
			
			Assert.assertNotNull(user);
			Assert.assertEquals("test", user.getUserName());
			Assert.assertEquals("user", user.getRole().getRoleName());
		}finally {
			sqlSession.close();
		}
	}
	
	@Test
	public void testSelectUserAndRoleByidSelect() {
		System.out.println("testSelectUserAndRoleByidSelect");
		SqlSession sqlSession = getSqlSession();
		
		try {
			UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
			SysUser user = userMapper.selectUserAndRoleByidSelect(1001l);
			
			Assert.assertNotNull(user);
			Assert.assertEquals("test", user.getUserName());
			Assert.assertEquals("user", user.getRole().getRoleName());
		}finally {
			sqlSession.close();
		}
	}
}
