/**
 * 
 */
package com.primeton.iaas.selfservice.portal.permission.menu.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.primeton.iaas.selfservice.portal.permission.menu.dao.MenuDao;
import com.primeton.iaas.selfservice.portal.permission.role.dao.RoleDao;
import com.primeton.iaas.selfservice.portal.permission.vo.FunctionVO;
import com.primeton.iaas.selfservice.portal.permission.vo.MenuVO;

/**
 * @author Administrator
 *
 */
@Service("permissionMenuService")
public class MenuServiceImpl implements MenuService{
	@Autowired
	private MenuDao menuDao;
	@Autowired
	private RoleDao roleDao;


	@Override
	public MenuVO getMenuByFuncId(String funcId) {
		return menuDao.queryOneMenuByFuncId(funcId);
	}

	@Override
	public List<MenuVO> listUserMenu(String roleId) {
		List<MenuVO> menus = new ArrayList<MenuVO>();
		List<MenuVO> menuTree = new ArrayList<MenuVO>();
		List<FunctionVO> functions=roleDao.queryAuthFuncs(roleId);
		
		for (FunctionVO function : functions) {
			if (function.getType().equals("menu")) {
				MenuVO menu = menuDao.queryOneMenuByFuncId(function.getId());
				menu.setFuncAction(function.getAction());
				menus.add(menu);
			}
		}
		
		for (MenuVO menu : menus) {
			if (menu.getIs_leaf() == '0') {
				List<MenuVO> myChildrens = new ArrayList<MenuVO>();
				for (MenuVO m : menus) {
					if (menu.getId().equals(m.getParent_id())) {
						myChildrens.add(m);
					}
				}
				//大的上浮，
				
				Collections.sort(myChildrens, new Comparator<MenuVO>() {
					public int compare(MenuVO m0, MenuVO m1){
						return m0.getDisplayorder() - (m1.getDisplayorder());
					}
				});
				
				//Arrays.sort(new int[]{176, 67, 5, 765, 77});
				
				menu.setChildrens(myChildrens);
				menuTree.add(menu);
			}
		}
		Collections.sort(menuTree, new Comparator<MenuVO>() {
			public int compare(MenuVO m3, MenuVO m4){
				return m3.getDisplayorder() - (m4.getDisplayorder());
			}
		});
		
		return menuTree;
	}

}
