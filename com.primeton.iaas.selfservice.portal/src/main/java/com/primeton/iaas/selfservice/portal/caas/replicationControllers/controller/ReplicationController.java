/**
 * 
 */
package com.primeton.iaas.selfservice.portal.caas.replicationControllers.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

import com.primeton.components.rest.annotation.JSONParam;
import com.primeton.iaas.selfservice.portal.caas.api.NamespaceApi;
import com.primeton.iaas.selfservice.portal.caas.api.ReplicationControllerApi;
import com.primeton.iaas.selfservice.portal.caas.namespaces.service.NamespaceService;
import com.primeton.iaas.selfservice.portal.caas.vo.NamespaceVO;
import com.primeton.iaas.selfservice.portal.caas.vo.ReplicationControllerVO;
import com.primeton.iaas.selfservice.portal.utils.SpringBeanUtils;

/**
 * @author RenQiang
 *
 */
@Path("/caas/replicationcontrollers")
public class ReplicationController {
	
	private NamespaceService namespaceService = SpringBeanUtils.getBean("caasNamespaceService");
	
	@GET
	@Path("/list")
	@Produces(MediaType.APPLICATION_JSON)
	public Map<String, Object> listReplicationControllers(){
		List<ReplicationControllerVO> replicationControllerVOs = new ArrayList<ReplicationControllerVO>();
		ReplicationControllerApi replicationControllerApi = new ReplicationControllerApi();
		replicationControllerVOs = replicationControllerApi.listReplicationControllers();
		Map<String, Object> result = new HashMap<String, Object>();
		result.put("data", replicationControllerVOs);
		return result;
	}
	
	@GET
	@Path("/lists")
	@Produces(MediaType.APPLICATION_JSON)
	public Map<String, Object> listsReplicationControllers(@Context HttpServletRequest request){
		List<NamespaceVO> namespaces = new ArrayList<NamespaceVO>();
		List<ReplicationControllerVO> replicationControllerVOs = new ArrayList<ReplicationControllerVO>();
		ReplicationControllerApi replicationControllerApi = new ReplicationControllerApi();
		namespaces = namespaceService.listUserNamespaces((String) request.getSession().getAttribute("userId"));
		for (NamespaceVO namespaceVO : namespaces) {
			replicationControllerVOs.addAll(replicationControllerApi.listReplicationControllers(namespaceVO.getName()));
		}
		
		Map<String, Object> result = new HashMap<String, Object>();
		result.put("data", replicationControllerVOs);
		return result;
	}
	
	@POST
	@Path("/add")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public void createReplicationController(@JSONParam("replicationController") ReplicationControllerVO replicationControllerVO){
		ReplicationControllerApi replicationControllerApi = new ReplicationControllerApi();
		replicationControllerApi.createReplicationController(replicationControllerVO);
	}
	
	@POST
	@Path("/update")
	@Consumes(MediaType.APPLICATION_JSON)
	public void updateReplicationController(@JSONParam("id") String id){
		NamespaceApi namespaceApi = new NamespaceApi();
		//namespaceApi.createNamespace(id);
	}
	
	@DELETE
	@Path("/delete/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	public void deleteReplicationController(@PathParam("id") String id){
		NamespaceApi namespaceApi = new NamespaceApi();
		namespaceApi.deleteNamespace(id);
	}
}
