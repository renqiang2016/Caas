/**
 * 
 */
package com.primeton.iaas.selfservice.portal.permission.user.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

import org.slf4j.Logger;

import com.primeton.components.rest.annotation.JSONParam;
import com.primeton.iaas.selfservice.portal.log.LoggerService;
import com.primeton.iaas.selfservice.portal.loginmanager.filter.SessionFilter;
import com.primeton.iaas.selfservice.portal.permission.user.service.UserService;
import com.primeton.iaas.selfservice.portal.permission.vo.RoleVO;
import com.primeton.iaas.selfservice.portal.permission.vo.UserRoleVO;
import com.primeton.iaas.selfservice.portal.permission.vo.UserVO;
import com.primeton.iaas.selfservice.portal.utils.SpringBeanUtils;

/**
 * @author Administrator
 *
 */

@Path("/permission/user")
public class UserController {
	private UserService service = SpringBeanUtils.getBean("permissionUserService");
	
	private static final Logger logger = LoggerService.getTraceLogger(UserController.class);
	
	@GET
	@Path("/list")
	@Produces(MediaType.APPLICATION_JSON)
	public Map<String, Object> listUsers(){
		List<UserVO> users = new ArrayList<UserVO>();
		users = service.listAllUsers();
		Map<String, Object> result = new HashMap<String, Object>();
		result.put("data", users);
		return result;
		
	}
	
	@GET
	@Path("/list/{userId}/AuthRole")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Map<String, Object> listAuthRoles(@PathParam("userId") String userId){
		List<RoleVO> roles=new ArrayList<RoleVO>();
		roles=service.listAuthRoles(userId);
		Map<String, Object> result = new HashMap<String, Object>();
		result.put("data", roles);
		return result;
		
	}
	
	@GET
	@Path("/list/{userId}/NoAuthRole")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Map<String, Object> listNoAuthRoles(@PathParam("userId") String userId){
		List<RoleVO> roles=new ArrayList<RoleVO>();
		roles=service.listNoAuthRoles(userId);
		Map<String, Object> result = new HashMap<String, Object>();
		result.put("data", roles);
		return result;
		
	}
	
	@POST
	@Path("/add")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public void createUser(@JSONParam("user") UserVO user){
		service.addUser(user);
		//service.addDefaultRole(user);
	}
	
	@POST
	@Path("/add/AuthRole")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public void addAuthRole(@JSONParam("userRole") UserRoleVO userRole){
		service.deleteUserRole(userRole.getUserId());
		service.addUserRole(userRole);
	}
	
	@DELETE
	@Path("/delete/{userId}/AuthRole")
	@Consumes(MediaType.APPLICATION_JSON)
	public void deleteAuthRole(@PathParam("userId") String userId){
		service.deleteUserRole(userId);
	}
	
	@POST
	@Path("/update")
	@Consumes(MediaType.APPLICATION_JSON)
	public void updateUser(@JSONParam("user") UserVO user){
		service.updateUser(user);
	}
	
	@DELETE
	@Path("/delete/{userId}")
	@Consumes(MediaType.APPLICATION_JSON)
	public void deleteUser(@PathParam("userId") String userId){
		service.deleteUser(userId);
		service.deleteUserRole(userId);
	}
	
	@POST
	@Path("/check")
	@Consumes(MediaType.APPLICATION_JSON)
	public Map<String, Object> checkUser(@Context HttpServletRequest request,@JSONParam("user") UserVO user) {
		UserVO usercheck = service.checkUser(user);
		if(usercheck != null){
			request.getSession().setAttribute(SessionFilter.SESSION_USER, usercheck);
			request.getSession().setAttribute("userId", usercheck.getId());
		}
		Map<String, Object> result = new HashMap<String, Object>();
		result.put("data", usercheck);
		return result;
	}
	
	
	
	
	
	
}
