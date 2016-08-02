/**
 * 
 */
package com.primeton.iaas.selfservice.portal.caas.serviceAccounts.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.primeton.iaas.selfservice.portal.caas.api.ServiceAccountApi;
import com.primeton.iaas.selfservice.portal.caas.vo.ServiceAccountVO;

/**
 * @author RenQiang
 *
 */
@Path("/caas/serviceaccounts")
public class ServiceAccountController {
	@GET
	@Path("/list")
	@Produces(MediaType.APPLICATION_JSON)
	public Map<String, Object> listServiceAccounts(){
		List<ServiceAccountVO> serviceAccountVOs= new ArrayList<ServiceAccountVO>();
		ServiceAccountApi serviceAccountApi = new ServiceAccountApi();
		serviceAccountVOs = serviceAccountApi.listServiceAccounts();
		Map<String, Object> result = new HashMap<String, Object>();
		result.put("data", serviceAccountVOs);
		return result;
	}
}
