/**
 * 
 */
package com.primeton.iaas.selfservice.portal.permission.role.dao;

import java.util.List;

import com.primeton.iaas.selfservice.portal.mybatis.IMarkerInterface;
import com.primeton.iaas.selfservice.portal.permission.vo.FunctionVO;
import com.primeton.iaas.selfservice.portal.permission.vo.RoleFuncVO;
import com.primeton.iaas.selfservice.portal.permission.vo.RoleVO;

/**
 * @author Administrator
 *
 */
public interface RoleDao extends IMarkerInterface{
	
	void insertRole(RoleVO role);
	
	void deleteRole(String roleId);
	
	void deleteAuthUser(String roleId);
	
	void updateRole(RoleVO role);
	
	List<RoleVO> queryAllRoles();
	
	List<RoleFuncVO> queryAllRoleFuncs();
	
	RoleVO queryOneRole(String roleId);
	
	List<FunctionVO> queryAuthFuncs(String roleId);
	
	List<FunctionVO> queryNoAuthFuncs(String roleId);
	
	void insertRoleFunc(RoleFuncVO roleFunc);
	
	void updateRoleFunc(RoleFuncVO roleFunc);
	
	void deleteRoleFunc(String roleId);
	
	RoleFuncVO queryOneRoleFunc(String roleId);
	
}
