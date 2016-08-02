/**
 * 
 */
package com.primeton.iaas.selfservice.portal.permission.role.service;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.primeton.iaas.selfservice.portal.permission.role.dao.RoleDao;
import com.primeton.iaas.selfservice.portal.permission.vo.FunctionVO;
import com.primeton.iaas.selfservice.portal.permission.vo.RoleFuncVO;
import com.primeton.iaas.selfservice.portal.permission.vo.RoleVO;
import com.primeton.iaas.selfservice.portal.vo.AbstractVO.RecordStatus;

/**
 * @author Administrator
 *
 */

@Service("permissionRoleService")
public class RoleServiceImpl implements RoleService{

	@Autowired
	private RoleDao roleDao;
	
	public List<RoleVO> listAllRoles() {
		return roleDao.queryAllRoles();
	}

	public void addRole(RoleVO role) {
		if (role.getId() == null || role.getId().trim().length() == 0) {
			role.setId(UUID.randomUUID().toString());
		}
		Date date = new Date();
		role.setCreateTime(date);
		role.setModifiedTime(date);
		roleDao.insertRole(role);
	}

	public void updateRole(RoleVO role) {
		Date date = new Date();
		role.setModifiedTime(date);
		roleDao.updateRole(role);
		
	}

	public void deleteRole(String roleId, boolean onlyMarked) {
		roleDao.deleteRole(roleId);
		
	}

	public RoleVO getRole(String roleId) {
		return roleDao.queryOneRole(roleId);
	}

	public List<FunctionVO> listAuthFuncs(String roleId) {
		return roleDao.queryAuthFuncs(roleId);
	}

	public List<FunctionVO> listNoAuthFuncs(String roleId) {
		return roleDao.queryNoAuthFuncs(roleId);
	}

	public void addRoleFunc(RoleFuncVO roleFunc) {
		Date date = new Date();
		roleFunc.setCreateTime(date);
		roleFunc.setUpdateTime(date);
		roleDao.insertRoleFunc(roleFunc);
		
	}

	public void updateRoleFunc(RoleFuncVO roleFunc) {
		Date date = new Date();
		roleFunc.setUpdateTime(date);
		roleDao.updateRoleFunc(roleFunc);
		
	}

	public void deleteRoleFunc(String roleId) {
		
		roleDao.deleteRoleFunc(roleId);		
	}
	
	public RoleFuncVO getRoleFunc(String roleId) {
		return roleDao.queryOneRoleFunc(roleId);
	}

	public void deleteAuthUser(String roleId) {
		roleDao.deleteAuthUser(roleId);
		
	}

	@Override
	public List<RoleFuncVO> queryAllRoleFuncs() {
		return roleDao.queryAllRoleFuncs();
	}
	
}
