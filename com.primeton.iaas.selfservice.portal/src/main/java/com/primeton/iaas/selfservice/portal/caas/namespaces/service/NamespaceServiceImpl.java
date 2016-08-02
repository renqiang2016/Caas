/**
 * 
 */
package com.primeton.iaas.selfservice.portal.caas.namespaces.service;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.primeton.iaas.selfservice.portal.caas.namespaces.dao.NamespaceDao;
import com.primeton.iaas.selfservice.portal.caas.vo.NamespaceVO;

/**
 * @author RenQiang
 *
 */

@Service("caasNamespaceService")
public class NamespaceServiceImpl implements NamespaceService{
	
	@Autowired
	private NamespaceDao namespaceDao;

	/* (non-Javadoc)
	 * @see com.primeton.iaas.selfservice.portal.caas.namespaces.service.NamespaceService#listAllNamespaces()
	 */
	@Override
	public List<NamespaceVO> listAllNamespaces() {
		// TODO Auto-generated method stub
		return namespaceDao.listAllNamespaces();
	}

	/* (non-Javadoc)
	 * @see com.primeton.iaas.selfservice.portal.caas.namespaces.service.NamespaceService#addNamespace(com.primeton.iaas.selfservice.portal.caas.vo.NamespaceVO)
	 */
	@Override
	public void addNamespace(NamespaceVO namespaceVO) {
		if (namespaceVO.getId() == null || namespaceVO.getId().trim().length() == 0) {
			namespaceVO.setId(UUID.randomUUID().toString());
		}
		Date date = new Date();
		namespaceVO.setCreateTime(date);
		namespaceVO.setModifiedTime(date);
		namespaceDao.addNamespace(namespaceVO);
	}

	/* (non-Javadoc)
	 * @see com.primeton.iaas.selfservice.portal.caas.namespaces.service.NamespaceService#updateNamespace(com.primeton.iaas.selfservice.portal.caas.vo.NamespaceVO)
	 */
	@Override
	public void updateNamespace(NamespaceVO namespaceVO) {
		// TODO Auto-generated method stub
		namespaceDao.updateNamespace(namespaceVO);
	}

	/* (non-Javadoc)
	 * @see com.primeton.iaas.selfservice.portal.caas.namespaces.service.NamespaceService#deleteNamespace(java.lang.String)
	 */
	@Override
	public void deleteNamespace(String namespaceId) {
		// TODO Auto-generated method stub
		namespaceDao.deleteNamespace(namespaceId);
	}

	/* (non-Javadoc)
	 * @see com.primeton.iaas.selfservice.portal.caas.namespaces.service.NamespaceService#listUserNamespaces(java.lang.String)
	 */
	@Override
	public List<NamespaceVO> listUserNamespaces(String userId) {
		// TODO Auto-generated method stub
		return namespaceDao.listUserNamespaces(userId);
	}

}
