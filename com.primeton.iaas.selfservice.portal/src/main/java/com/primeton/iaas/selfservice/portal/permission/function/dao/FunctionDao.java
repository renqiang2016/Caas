/**
 * 
 */
package com.primeton.iaas.selfservice.portal.permission.function.dao;

import java.util.List;

import com.primeton.iaas.selfservice.portal.mybatis.IMarkerInterface;
import com.primeton.iaas.selfservice.portal.permission.vo.FunctionVO;

/**
 * @author Administrator
 *
 */
public interface FunctionDao extends IMarkerInterface{
	
	void insertFunction(FunctionVO function);
	
	void deleteFunction(String functionId);
	
	void updateFunction(FunctionVO function);
	
	List<FunctionVO> queryAllFunctions();
	
	FunctionVO queryOneFunction(String functionId);
}
