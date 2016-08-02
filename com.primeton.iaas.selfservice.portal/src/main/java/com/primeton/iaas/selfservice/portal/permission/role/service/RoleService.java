/**
 * 
 */
package com.primeton.iaas.selfservice.portal.permission.role.service;

import java.util.List;

import com.primeton.iaas.selfservice.portal.permission.vo.FunctionVO;
import com.primeton.iaas.selfservice.portal.permission.vo.RoleFuncVO;
import com.primeton.iaas.selfservice.portal.permission.vo.RoleVO;


/**
 * @author Administrator
 *
 */
public interface RoleService {
	
	List<RoleVO> listAllRoles();
	
	List<RoleFuncVO> queryAllRoleFuncs();
	
	void addRole(RoleVO role);
	
	void updateRole(RoleVO role);
	
	void deleteRole(String roleId,boolean onlyMarked);
	
	void deleteAuthUser(String roleId);
	
	RoleVO getRole(String roleId);
	
	List<FunctionVO> listAuthFuncs(String roleId);
	
	List<FunctionVO> listNoAuthFuncs(String roleId);
	
	void addRoleFunc(RoleFuncVO roleFunc);
	
	void updateRoleFunc(RoleFuncVO roleFunc);
	
	void deleteRoleFunc(String roleId);
	
	RoleFuncVO getRoleFunc(String roleId);
}
