/**
 * 
 */
package com.primeton.iaas.selfservice.portal.permission.function.service;

import java.util.List;

import com.primeton.iaas.selfservice.portal.permission.vo.FunctionVO;

/**
 * @author Administrator
 *
 */
public interface FunctionService {
	
	List<FunctionVO> listAllFunctions();
	
	void addFunction(FunctionVO function);
	
	void updateFunction(FunctionVO function);
	
	void deleteFunction(String functionId);
	
	FunctionVO getFunction(String functionId);
}
