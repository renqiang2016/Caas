/**
 * 
 */
package com.primeton.iaas.selfservice.portal.permission.role.controller;

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
import com.primeton.iaas.selfservice.portal.permission.role.service.RoleService;
import com.primeton.iaas.selfservice.portal.permission.vo.FunctionVO;
import com.primeton.iaas.selfservice.portal.permission.vo.RoleFuncVO;
import com.primeton.iaas.selfservice.portal.permission.vo.RoleVO;
import com.primeton.iaas.selfservice.portal.utils.SpringBeanUtils;

/**
 * @author Administrator
 *
 */

@Path("/permission/role")
public class RoleController {
	private RoleService service = SpringBeanUtils.getBean("permissionRoleService");
	
	private static final Logger logger = LoggerService.getTraceLogger(RoleController.class);
	
	@GET
	@Path("/list")
	@Produces(MediaType.APPLICATION_JSON)
	public Map<String, Object> listRoles(){
		List<RoleVO> roles = new ArrayList<RoleVO>();
		roles = service.listAllRoles();
		Map<String, Object> result = new HashMap<String, Object>();
		result.put("data", roles);
		return result;
		
	}

	@POST
	@Path("/add")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public void createRole(@JSONParam("role") RoleVO role){
		service.addRole(role);
	}
	
	@POST
	@Path("/update")
	@Consumes(MediaType.APPLICATION_JSON)
	public void updateRole(@JSONParam("role") RoleVO role){
		service.updateRole(role);
	}
	
	@DELETE
	@Path("/delete/{roleId}")
	@Consumes(MediaType.APPLICATION_JSON)
	public void deleteRole(@PathParam("roleId") String roleId,
			@JSONParam("onlyMarked") String onlyMarked){
		boolean isOnlyMarked = !"false".equalsIgnoreCase(onlyMarked);
		service.deleteRole(roleId, isOnlyMarked);
		service.deleteAuthUser(roleId);
		service.deleteRoleFunc(roleId);
	}
	
	
	@GET
	@Path("/list/{roleId}/AuthFunc")
	@Produces(MediaType.APPLICATION_JSON)
	public Map<String, Object> listAuthFuncs(@PathParam("roleId") String roleId){
		List<FunctionVO> functions = new ArrayList<FunctionVO>();
		functions = service.listAuthFuncs(roleId);
		Map<String, Object> result = new HashMap<String, Object>();
		result.put("data", functions);
		return result;
		
	}
	
	@GET
	@Path("/list/{roleId}/NoAuthFunc")
	@Produces(MediaType.APPLICATION_JSON)
	public Map<String, Object> listNoAuthFuncs(@PathParam("roleId") String roleId){
		List<FunctionVO> functions = new ArrayList<FunctionVO>();
		functions = service.listNoAuthFuncs(roleId);
		Map<String, Object> result = new HashMap<String, Object>();
		result.put("data", functions);
		return result;
		
	}
	
	@POST
	@Path("/function/add")
	@Consumes(MediaType.APPLICATION_JSON)
	public void addFunc(@JSONParam("functionIds") String functionIds[],@JSONParam("roleId") String roleId){
		service.deleteRoleFunc(roleId);
		for (String functionId : functionIds) {
			service.addRoleFunc(new RoleFuncVO(roleId,functionId));
		}
		
	}
	
	@POST
	@Path("/function/update")
	@Consumes(MediaType.APPLICATION_JSON)
	public void updateFunc(@JSONParam("roleFunc") RoleFuncVO roleFunc){
		service.updateRoleFunc(roleFunc);
	}
	
	@DELETE
	@Path("/function/delete/{roleId}")
	@Consumes(MediaType.APPLICATION_JSON)
	public void deleteFunc(@PathParam("roleId") String roleId){
		service.deleteRoleFunc(roleId);
	}
	
	
}
