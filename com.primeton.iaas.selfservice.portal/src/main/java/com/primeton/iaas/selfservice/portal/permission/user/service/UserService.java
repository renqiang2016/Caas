/**
 * 
 */
package com.primeton.iaas.selfservice.portal.permission.user.service;

import java.util.List;

import com.primeton.iaas.selfservice.portal.permission.vo.FunctionVO;
import com.primeton.iaas.selfservice.portal.permission.vo.RoleVO;
import com.primeton.iaas.selfservice.portal.permission.vo.UserRoleVO;
import com.primeton.iaas.selfservice.portal.permission.vo.UserVO;

/**
 * @author Administrator
 *
 */
public interface UserService {
	
	List<UserVO> listAllUsers();
	
	void addUser(UserVO user);
	
	void addDefaultRole(UserVO user);
	
	void updateUser(UserVO user);
	
	void deleteUser(String userId);
	
	UserVO checkUser(UserVO user);
	
	UserVO getUser(String userId);
	
	List<RoleVO> listAuthRoles(String userId);
	
	List<RoleVO> listNoAuthRoles(String userId);
	
	void deleteUserRole(String userId);
	
	void addUserRole(UserRoleVO userRole);
}
