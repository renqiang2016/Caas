/**
 * 
 */
package com.primeton.iaas.selfservice.portal.permission.user.dao;

import java.util.List;

import com.primeton.iaas.selfservice.portal.mybatis.IMarkerInterface;
import com.primeton.iaas.selfservice.portal.permission.vo.RoleVO;
import com.primeton.iaas.selfservice.portal.permission.vo.UserRoleVO;
import com.primeton.iaas.selfservice.portal.permission.vo.UserVO;

/**
 * @author Administrator
 *
 */
public interface UserDao extends IMarkerInterface{
	
	void insertUser(UserVO user);
	
	void addDefaultRole(UserVO user);
	
	void deleteUser(String userId);
	
	void updateUser(UserVO user);
	
	UserVO checkUser(UserVO user);
	
	List<UserVO> queryAllUsers();
	
	UserVO queryOneUser(String userId);
	
	List<RoleVO> queryAuthRoles(String userId);
	
	List<RoleVO> queryNoAuthRoles(String userId);
	
	void deleteAuthRole(String userId);
	
	void addAuthRole(UserRoleVO userRole);
	
	
		
}
