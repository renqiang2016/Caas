/**
 * 
 */
package com.primeton.iaas.selfservice.portal.caas.services.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

import com.primeton.iaas.selfservice.portal.caas.api.ServiceApi;
import com.primeton.iaas.selfservice.portal.caas.namespaces.service.NamespaceService;
import com.primeton.iaas.selfservice.portal.caas.vo.NamespaceVO;
import com.primeton.iaas.selfservice.portal.caas.vo.ServiceVO;
import com.primeton.iaas.selfservice.portal.utils.SpringBeanUtils;

/**
 * @author RenQiang
 *
 */
@Path("/caas/services")
public class ServiceController {

	private NamespaceService namespaceService = SpringBeanUtils.getBean("caasNamespaceService");
	
	@GET
	@Path("/list")
	@Produces(MediaType.APPLICATION_JSON)
	public Map<String, Object> listServices(){
		List<ServiceVO> serviceVOs = new ArrayList<ServiceVO>();
		ServiceApi serviceApi = new ServiceApi();
		serviceVOs = serviceApi.listServices();
		Map<String, Object> result = new HashMap<String, Object>();
		result.put("data", serviceVOs);
		return result;
	}
	
	@GET
	@Path("/lists")
	@Produces(MediaType.APPLICATION_JSON)
	public Map<String, Object> listsServices(@Context HttpServletRequest request){
		List<NamespaceVO> namespaces = new ArrayList<NamespaceVO>();
		List<ServiceVO> serviceVOs = new ArrayList<ServiceVO>();
		ServiceApi serviceApi = new ServiceApi();
		namespaces = namespaceService.listUserNamespaces((String) request.getSession().getAttribute("userId"));
		for (NamespaceVO namespaceVO : namespaces) {
			serviceVOs.addAll(serviceApi.listServices(namespaceVO.getName()));
		}
		Map<String, Object> result = new HashMap<String, Object>();
		result.put("data", serviceVOs);
		return result;
	}
}
