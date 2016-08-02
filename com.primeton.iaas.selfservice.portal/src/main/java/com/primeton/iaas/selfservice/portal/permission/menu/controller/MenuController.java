/**
 * 
 */
package com.primeton.iaas.selfservice.portal.permission.menu.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

import com.primeton.iaas.selfservice.portal.loginmanager.filter.SessionFilter;
import com.primeton.iaas.selfservice.portal.permission.menu.service.MenuService;
import com.primeton.iaas.selfservice.portal.permission.user.service.UserService;
import com.primeton.iaas.selfservice.portal.permission.vo.MenuVO;
import com.primeton.iaas.selfservice.portal.permission.vo.UserVO;
import com.primeton.iaas.selfservice.portal.utils.SpringBeanUtils;

/**
 * @author Administrator
 *
 */
@Path("/permission/menu")
public class MenuController {
	private MenuService menuService = SpringBeanUtils.getBean("permissionMenuService");
	private UserService service = SpringBeanUtils.getBean("permissionUserService");

	@GET
	@Path("/listUserMenu")
	@Produces(MediaType.APPLICATION_JSON)
	public Map<String, Object> getUserMenu(@Context HttpServletRequest request) {

		UserVO user = (UserVO) request.getSession().getAttribute(SessionFilter.SESSION_USER);
		List<MenuVO> menuTree;
		List<MenuVO> sessionMenuTree = (List<MenuVO>) request.getSession().getAttribute("menuTree");
		String roleId = null;
		if (user != null) {
			roleId = service.listAuthRoles(user.getId()).get(0).getId();
		}
		if (sessionMenuTree != null && sessionMenuTree.size() != 0) {
			menuTree = sessionMenuTree;
		} else {
			menuTree = menuService.listUserMenu(roleId);
		}
		Map<String, Object> result = new HashMap<String, Object>();
		result.put("data", menuTree);
		request.getSession().setAttribute("menuTree", menuTree);
		return result;
	}
}
