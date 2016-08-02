/**
 * 
 */
package com.primeton.iaas.selfservice.portal.permission.function.service;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.primeton.iaas.selfservice.portal.permission.function.dao.FunctionDao;
import com.primeton.iaas.selfservice.portal.permission.vo.FunctionVO;
import com.primeton.iaas.selfservice.portal.vo.AbstractVO.RecordStatus;

/**
 * @author Administrator
 *
 */
@Service("permissionFunctionService")
public class FunctionServiceImpl implements FunctionService {
	@Autowired
	private FunctionDao functionDao;
	
	@Override
	public List<FunctionVO> listAllFunctions() {
		return functionDao.queryAllFunctions();
	}

	@Override
	public void addFunction(FunctionVO function) {
		if (function.getId() == null || function.getId().trim().length() == 0) {
			function.setId(UUID.randomUUID().toString());
		}
		Date date = new Date();
		function.setCreateTime(date);
		function.setModifiedTime(date);
		functionDao.insertFunction(function);
		
	}

	@Override
	public void updateFunction(FunctionVO function) {
		Date date = new Date();
		function.setModifiedTime(date);
		functionDao.updateFunction(function);
	}

	@Override
	public void deleteFunction(String functionId) {
		functionDao.deleteFunction(functionId);
		
	}

	@Override
	public FunctionVO getFunction(String functionId) {
		
		return functionDao.queryOneFunction(functionId);
	}

}
