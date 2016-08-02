/**
 * 
 */
package com.primeton.iaas.selfservice.portal.caas.namespaces.service;

import java.util.List;

import com.primeton.iaas.selfservice.portal.caas.vo.NamespaceVO;

/**
 * @author RenQiang
 *
 */
public interface NamespaceService {
	
	List<NamespaceVO> listAllNamespaces();
	
	List<NamespaceVO> listUserNamespaces(String userId);
	
	void addNamespace(NamespaceVO namespaceVO);
	
	void updateNamespace(NamespaceVO namespaceVO);
	
	void deleteNamespace(String namespaceId);
}
