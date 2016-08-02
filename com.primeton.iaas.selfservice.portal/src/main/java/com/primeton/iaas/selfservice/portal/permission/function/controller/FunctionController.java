/**
 * 
 */
package com.primeton.iaas.selfservice.portal.permission.function.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.slf4j.Logger;

import com.primeton.components.rest.annotation.JSONParam;
import com.primeton.iaas.selfservice.portal.log.LoggerService;
import com.primeton.iaas.selfservice.portal.permission.function.service.FunctionService;
import com.primeton.iaas.selfservice.portal.permission.vo.FunctionVO;
import com.primeton.iaas.selfservice.portal.utils.SpringBeanUtils;

/**
 * @author Administrator
 *
 */
@Path("/permission/function")
public class FunctionController {
	private FunctionService service=SpringBeanUtils.getBean("permissionFunctionService");
	private static final Logger logger = LoggerService.getTraceLogger(FunctionController.class);
	
	@GET
	@Path("/list")
	@Produces(MediaType.APPLICATION_JSON)
	public Map<String, Object> listFunctions(){
		List<FunctionVO> functions=new ArrayList<FunctionVO>();
		functions=service.listAllFunctions();
		Map<String, Object> result = new HashMap<String, Object>();
		result.put("data", functions);
		return result;
		
	}
	
	@POST
	@Path("/add")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public void createFunction(@JSONParam("function") FunctionVO function){
		service.addFunction(function);
	}
	
	@POST
	@Path("/update")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public void updateFunction(@JSONParam("function") FunctionVO function){
		service.updateFunction(function);
	}
	
	@DELETE
	@Path("/delete/{roleId}")
	@Consumes(MediaType.APPLICATION_JSON)
	public void deleteFunction(@PathParam("functionId") String functionId){
		service.deleteFunction(functionId);
	}
	
	
	
	
	
	
	
	
}
