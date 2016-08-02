/*******************************************************************************
 * $Header$
 * $Revision$
 * $Date$
 *
 *==============================================================================
 *
 * Copyright (c) 2001-2012 Primeton Technologies, Ltd.
 * All rights reserved.
 * 
 * Created on Dec 18, 2015
 *******************************************************************************/

package com.primeton.iaas.selfservice.portal.vo;

import java.util.Date;

/**
 * TODO 此处填写 class 信息
 *
 * @author wangwb (mailto:wangwb@primeton.com)
 */

public class AbstractVO {
	public static enum RecordStatus {
		Deleted, Normal
	}
	
	private String createUser;
	private Date createTime;
	private Date updateTime;
	private RecordStatus recordStatus = RecordStatus.Normal;

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	public int getRecordStatus() {
		return recordStatus.ordinal();
	}

	public RecordStatus getRecordStatusEnum() {
		return recordStatus;
	}

	public void setRecordStatus(int recordStatus) {
		this.recordStatus = RecordStatus.values()[recordStatus];
	}

	public void setRecordStatusEnum(RecordStatus recordStatus) {
		this.recordStatus = recordStatus;
	}

	public boolean isMarkDeleted() {
		return recordStatus == RecordStatus.Deleted;
	}

	/**
	 * @return the createUser
	 */
	public String getCreateUser() {
		return createUser;
	}

	/**
	 * @param createUser the createUser to set
	 */
	public void setCreateUser(String createUser) {
		this.createUser = createUser;
	}
	
	
}
