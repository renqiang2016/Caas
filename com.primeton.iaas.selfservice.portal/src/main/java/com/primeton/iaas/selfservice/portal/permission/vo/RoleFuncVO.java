/**
 * 
 */
package com.primeton.iaas.selfservice.portal.permission.vo;

import java.util.Date;

import com.primeton.iaas.selfservice.portal.vo.AbstractVO;

/**
 * @author Administrator
 *
 */
public class RoleFuncVO extends AbstractVO{
	private String roleId;
	private String functionId;
	private Date createTime;
	private Date modifiedTime;
	
	/**
	 * @return the createTime
	 */
	public Date getCreateTime() {
		return createTime;
	}
	/**
	 * @param createTime the createTime to set
	 */
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	/**
	 * @return the modifiedTime
	 */
	public Date getModifiedTime() {
		return modifiedTime;
	}
	/**
	 * @param modifiedTime the modifiedTime to set
	 */
	public void setModifiedTime(Date modifiedTime) {
		this.modifiedTime = modifiedTime;
	}
	/**
	 * @return the roleId
	 */
	public String getRoleId() {
		return roleId;
	}
	/**
	 * @param roleId the roleId to set
	 */
	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}
	/**
	 * @return the functionId
	 */
	public String getFunctionId() {
		return functionId;
	}
	/**
	 * @param functionId the functionId to set
	 */
	public void setFunctionId(String functionId) {
		this.functionId = functionId;
	}
	/**
	 * @param roleId
	 * @param functionId
	 */
	public RoleFuncVO(String roleId, String functionId) {
		super();
		this.roleId = roleId;
		this.functionId = functionId;
	}
	
	
}
