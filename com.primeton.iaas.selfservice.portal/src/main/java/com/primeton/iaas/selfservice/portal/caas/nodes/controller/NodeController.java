/**
 * 
 */
package com.primeton.iaas.selfservice.portal.caas.nodes.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.slf4j.Logger;

import com.primeton.components.rest.annotation.JSONParam;
import com.primeton.iaas.selfservice.portal.caas.api.NodeApi;
import com.primeton.iaas.selfservice.portal.caas.vo.NodeVO;
import com.primeton.iaas.selfservice.portal.log.LoggerService;
import com.primeton.iaas.selfservice.portal.utils.SpringBeanUtils;

import io.fabric8.kubernetes.api.model.Node;

/**
 * @author Administrator
 *
 */

@Path("/caas/nodes")
public class NodeController {
	
	@GET
	@Path("/list")
	@Produces(MediaType.APPLICATION_JSON)
	public Map<String, Object> listNodes(){
		List<NodeVO> Nodes = new ArrayList<NodeVO>();
		NodeApi nodeApi = new NodeApi();
		Nodes = nodeApi.listNodes();
		Map<String, Object> result = new HashMap<String, Object>();
		result.put("data", Nodes);
		return result;
		
	}

	/*@POST
	@Path("/add")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public void createNode(@JSONParam("Node") NodeVO Node){
		service.addNode(Node);
	}
	
	@POST
	@Path("/update")
	@Consumes(MediaType.APPLICATION_JSON)
	public void updateNode(@JSONParam("Node") NodeVO Node){
		service.updateNode(Node);
	}
	
	@DELETE
	@Path("/delete/{NodeId}")
	@Consumes(MediaType.APPLICATION_JSON)
	public void deleteNode(@PathParam("NodeId") String NodeId,
			@JSONParam("onlyMarked") String onlyMarked){
		boolean isOnlyMarked = !"false".equalsIgnoreCase(onlyMarked);
		service.deleteNode(NodeId, isOnlyMarked);
		service.deleteAuthUser(NodeId);
		service.deleteNodeFunc(NodeId);
	}
	
	
	@GET
	@Path("/list/{NodeId}/AuthFunc")
	@Produces(MediaType.APPLICATION_JSON)
	public Map<String, Object> listAuthFuncs(@PathParam("NodeId") String NodeId){
		List<FunctionVO> functions = new ArrayList<FunctionVO>();
		functions = service.listAuthFuncs(NodeId);
		Map<String, Object> result = new HashMap<String, Object>();
		result.put("data", functions);
		return result;
		
	}
	
	@GET
	@Path("/list/{NodeId}/NoAuthFunc")
	@Produces(MediaType.APPLICATION_JSON)
	public Map<String, Object> listNoAuthFuncs(@PathParam("NodeId") String NodeId){
		List<FunctionVO> functions = new ArrayList<FunctionVO>();
		functions = service.listNoAuthFuncs(NodeId);
		Map<String, Object> result = new HashMap<String, Object>();
		result.put("data", functions);
		return result;
		
	}
	
	@POST
	@Path("/function/add")
	@Consumes(MediaType.APPLICATION_JSON)
	public void addFunc(@JSONParam("functionIds") String functionIds[],@JSONParam("NodeId") String NodeId){
		service.deleteNodeFunc(NodeId);
		for (String functionId : functionIds) {
			service.addNodeFunc(new NodeFuncVO(NodeId,functionId));
		}
		
	}
	
	@POST
	@Path("/function/update")
	@Consumes(MediaType.APPLICATION_JSON)
	public void updateFunc(@JSONParam("NodeFunc") NodeFuncVO NodeFunc){
		service.updateNodeFunc(NodeFunc);
	}
	
	@DELETE
	@Path("/function/delete/{NodeId}")
	@Consumes(MediaType.APPLICATION_JSON)
	public void deleteFunc(@PathParam("NodeId") String NodeId){
		service.deleteNodeFunc(NodeId);
	}
	*/
	
}
