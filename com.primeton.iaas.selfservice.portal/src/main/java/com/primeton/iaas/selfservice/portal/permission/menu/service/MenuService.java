/**
 * 
 */
package com.primeton.iaas.selfservice.portal.permission.menu.service;

import java.util.List;

import com.primeton.iaas.selfservice.portal.permission.vo.MenuVO;

/**
 * @author Administrator
 *
 */
public interface MenuService {
	MenuVO getMenuByFuncId(String funcId);
	
	List<MenuVO> listUserMenu(String roleId);
}
