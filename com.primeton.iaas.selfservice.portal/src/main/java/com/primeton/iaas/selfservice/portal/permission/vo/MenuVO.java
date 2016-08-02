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
import java.util.List;

import com.primeton.iaas.selfservice.portal.vo.AbstractVO;

/**
 * 
 * TODO 此处填写 class 信息
 *
 * @author tianxh (mailto:tianxh@primeton.com)
 */
public class MenuVO{
	
	private String id;
	private String name;
	private String func_id;
	private int displayorder;
	private char is_leaf;
	private String parent_id;
	private Date createTime;
	private Date modifiedTime;
	private List<MenuVO> childrens;
	private String funcAction;
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
	 * @return the func_id
	 */
	public String getFunc_id() {
		return func_id;
	}
	/**
	 * @param func_id the func_id to set
	 */
	public void setFunc_id(String func_id) {
		this.func_id = func_id;
	}
	/**
	 * @return the displayorder
	 */
	public int getDisplayorder() {
		return displayorder;
	}
	/**
	 * @param displayorder the displayorder to set
	 */
	public void setDisplayorder(int displayorder) {
		this.displayorder = displayorder;
	}
	/**
	 * @return the is_leaf
	 */
	public char getIs_leaf() {
		return is_leaf;
	}
	/**
	 * @param is_leaf the is_leaf to set
	 */
	public void setIs_leaf(char is_leaf) {
		this.is_leaf = is_leaf;
	}
	/**
	 * @return the parent_id
	 */
	public String getParent_id() {
		return parent_id;
	}
	/**
	 * @param parent_id the parent_id to set
	 */
	public void setParent_id(String parent_id) {
		this.parent_id = parent_id;
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
	/**
	 * @return the childrens
	 */
	public List<MenuVO> getChildrens() {
		return childrens;
	}
	/**
	 * @param childrens the childrens to set
	 */
	public void setChildrens(List<MenuVO> childrens) {
		this.childrens = childrens;
	}
	/**
	 * @return the funcAction
	 */
	public String getFuncAction() {
		return funcAction;
	}
	/**
	 * @param funcAction the funcAction to set
	 */
	public void setFuncAction(String funcAction) {
		this.funcAction = funcAction;
	}
	
	
	
}

/*
 * 修改历史
 * $Log$ 
 */