/**
 * 
 */
package com.primeton.iaas.selfservice.portal.caas.events.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.primeton.iaas.selfservice.portal.caas.api.EndpointApi;
import com.primeton.iaas.selfservice.portal.caas.api.EventApi;
import com.primeton.iaas.selfservice.portal.caas.vo.EndPointVO;
import com.primeton.iaas.selfservice.portal.caas.vo.EventVO;

/**
 * @author RenQiang
 *
 */
@Path("/caas/events")
public class EventController {
	@GET
	@Path("/list")
	@Produces(MediaType.APPLICATION_JSON)
	public Map<String, Object> listEvents(){
		List<EventVO> eventVOs = new ArrayList<EventVO>();
		EventApi eventApi = new EventApi();
		eventVOs = eventApi.listEvents();
		Map<String, Object> result = new HashMap<String, Object>();
		result.put("data", eventVOs);
		return result;
	}
}
