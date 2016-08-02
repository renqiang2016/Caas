/**
 * 
 */
package com.primeton.iaas.selfservice.portal.permission.user.service;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.primeton.iaas.selfservice.portal.permission.user.dao.UserDao;
import com.primeton.iaas.selfservice.portal.permission.vo.RoleVO;
import com.primeton.iaas.selfservice.portal.permission.vo.UserRoleVO;
import com.primeton.iaas.selfservice.portal.permission.vo.UserVO;
import com.primeton.iaas.selfservice.portal.vo.AbstractVO.RecordStatus;

/**
 * @author Administrator
 *
 */

@Service("permissionUserService")
public class UserServiceImpl implements UserService{

	@Autowired
	private UserDao userDao;
	
	public List<UserVO> listAllUsers() {
		return userDao.queryAllUsers();
	}

	public void addUser(UserVO user) {
		if (user.getId() == null || user.getId().trim().length() == 0) {
			user.setId(UUID.randomUUID().toString());
		}
		Date date = new Date();
		user.setCreateTime(date);
		user.setModifiedTime(date);
		userDao.insertUser(user);
	}

	public void updateUser(UserVO user) {
		Date date = new Date();
		user.setModifiedTime(date);
		userDao.updateUser(user);
		
	}

	public void deleteUser(String userId) {
		userDao.deleteUser(userId);
		
	}

	public UserVO getUser(String userId) {
		return userDao.queryOneUser(userId);
	}

	public List<RoleVO> listAuthRoles(String userId) {
		return userDao.queryAuthRoles(userId);
	}

	public List<RoleVO> listNoAuthRoles(String userId) {
		return userDao.queryNoAuthRoles(userId);
	}

	public UserVO checkUser(UserVO user) {
		return userDao.checkUser(user);
	}

	public void addDefaultRole(UserVO user) {
		userDao.addDefaultRole(user);
		
	}

	public void deleteUserRole(String userId) {
		userDao.deleteAuthRole(userId);
		
	}

	public void addUserRole(UserRoleVO userRole) {
		Date date = new Date();
		userRole.setCreateTime(date);
		userRole.setModifiedTime(date);
		userDao.addAuthRole(userRole);
		
	}
	
}
