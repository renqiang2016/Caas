/**
 * 
 */
package com.primeton.iaas.selfservice.portal.caas.namespaces.dao;

import java.util.List;

import com.primeton.iaas.selfservice.portal.caas.vo.NamespaceVO;
import com.primeton.iaas.selfservice.portal.mybatis.IMarkerInterface;

/**
 * @author RenQiang
 *
 */
public interface NamespaceDao extends IMarkerInterface{
	
	List<NamespaceVO> listAllNamespaces();
	
	void addNamespace(NamespaceVO namespaceVO);
	
	void updateNamespace(NamespaceVO namespaceVO);
	
	void deleteNamespace(String namespaceId);
}
