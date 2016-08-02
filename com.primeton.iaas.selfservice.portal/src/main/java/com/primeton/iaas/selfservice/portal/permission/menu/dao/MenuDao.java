/**
 * 
 */
package com.primeton.iaas.selfservice.portal.permission.menu.dao;

import com.primeton.iaas.selfservice.portal.mybatis.IMarkerInterface;
import com.primeton.iaas.selfservice.portal.permission.vo.MenuVO;

/**
 * @author Administrator
 *
 */
public interface MenuDao extends IMarkerInterface {
	MenuVO queryOneMenuByFuncId(String funcId);
}
