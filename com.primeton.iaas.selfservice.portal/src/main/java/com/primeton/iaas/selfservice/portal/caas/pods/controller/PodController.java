/**
 * 
 */
package com.primeton.iaas.selfservice.portal.caas.pods.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.omg.CosNaming.NamingContextExtPackage.StringNameHelper;

import com.primeton.iaas.selfservice.portal.caas.api.PodApi;
import com.primeton.iaas.selfservice.portal.caas.vo.PodVO;

/**
 * @author RenQiang
 *
 */
@Path("/caas/pods")
public class PodController {
	
	@GET
	@Path("/list")
	@Produces(MediaType.APPLICATION_JSON)
	public Map<String, Object> listPods(){
		List<PodVO> pods = new ArrayList<PodVO>();
		PodApi podApi = new PodApi();
		pods = podApi.listPods();
		Map<String, Object> result = new HashMap<String, Object>();
		result.put("data", pods);
		return result;
	}
}
