/*******************************************************************************
 * $Header$
 * $Revision$
 * $Date$
 *
 *==============================================================================
 *
 * Copyright (c) 2001-2016 Primeton Technologies, Ltd.
 * All rights reserved.
 * 
 * Created on 2015年12月16日
 *******************************************************************************/


package com.primeton.iaas.selfservice.portal.permission.vo;

import java.util.Date;

import com.primeton.iaas.selfservice.portal.vo.AbstractVO;

/**
 * 
 * TODO 此处填写 class 信息
 *
 * @author tianxh (mailto:tianxh@primeton.com)
 */
public class FunctionVO{
	private String id;
	private String name;
	private String type;
	private String action;
	private Date createTime;
	private Date modifiedTime;
	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the type
	 */
	public String getType() {
		return type;
	}
	/**
	 * @param type the type to set
	 */
	public void setType(String type) {
		this.type = type;
	}
	/**
	 * @return the action
	 */
	public String getAction() {
		return action;
	}
	/**
	 * @param action the action to set
	 */
	public void setAction(String action) {
		this.action = action;
	}
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
	
	
	
}

/*
 * 修改历史
 * $Log$ 
 */