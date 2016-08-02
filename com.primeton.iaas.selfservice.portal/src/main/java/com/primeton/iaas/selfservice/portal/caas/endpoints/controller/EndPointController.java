/**
 * 
 */
package com.primeton.iaas.selfservice.portal.caas.endpoints.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.primeton.iaas.selfservice.portal.caas.api.EndpointApi;
import com.primeton.iaas.selfservice.portal.caas.vo.EndPointVO;

/**
 * @author RenQiang
 *
 */
@Path("/caas/endpoints")
public class EndPointController {
	@GET
	@Path("/list")
	@Produces(MediaType.APPLICATION_JSON)
	public Map<String, Object> listServices(){
		List<EndPointVO> endPointVOs = new ArrayList<EndPointVO>();
		EndpointApi endpointApi = new EndpointApi();
		endPointVOs = endpointApi.listEndpoints();
		Map<String, Object> result = new HashMap<String, Object>();
		result.put("data", endPointVOs);
		return result;
	}
}
