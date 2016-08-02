/**
 * 
 */
package com.primeton.iaas.selfservice.portal.caas.services.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.primeton.iaas.selfservice.portal.caas.api.ServiceApi;
import com.primeton.iaas.selfservice.portal.caas.vo.ServiceVO;

/**
 * @author RenQiang
 *
 */
@Path("/caas/services")
public class ServiceContrtoller {
	
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
}
