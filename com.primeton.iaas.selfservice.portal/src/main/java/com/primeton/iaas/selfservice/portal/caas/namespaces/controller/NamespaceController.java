/**
 * 
 */
package com.primeton.iaas.selfservice.portal.caas.namespaces.controller;

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

import org.yaml.snakeyaml.Yaml;

import com.primeton.components.rest.annotation.JSONParam;
import com.primeton.iaas.selfservice.portal.caas.api.NamespaceApi;
import com.primeton.iaas.selfservice.portal.caas.api.NodeApi;
import com.primeton.iaas.selfservice.portal.caas.namespaces.service.NamespaceService;
import com.primeton.iaas.selfservice.portal.caas.vo.NamespaceVO;
import com.primeton.iaas.selfservice.portal.caas.vo.NodeVO;
import com.primeton.iaas.selfservice.portal.order.service.OrderService;
import com.primeton.iaas.selfservice.portal.order.vo.OrderItemVO;
import com.primeton.iaas.selfservice.portal.order.vo.OrderVO;
import com.primeton.iaas.selfservice.portal.utils.SpringBeanUtils;

import io.fabric8.kubernetes.client.DefaultKubernetesClient;
import io.fabric8.kubernetes.client.KubernetesClient;

/**
 * @author RenQiang
 *
 */
@Path("/caas/namespaces")
public class NamespaceController {
	
	private NamespaceService namespaceService = SpringBeanUtils.getBean("caasNamespaceService");
	private OrderService orderService = SpringBeanUtils.getBean("orderService");
	/*@GET
	@Path("/list")
	@Produces(MediaType.APPLICATION_JSON)
	public Map<String, Object> listNamespaces(){
		List<NamespaceVO> namespaceVOs = new ArrayList<NamespaceVO>();
		NamespaceApi namespaceApi = new NamespaceApi();
		namespaceVOs = namespaceApi.listNamespaces();
		Map<String, Object> result = new HashMap<String, Object>();
		result.put("data", namespaceVOs);
		return result;
		
	}*/
	
	@GET
	@Path("/list")
	@Produces(MediaType.APPLICATION_JSON)
	public Map<String, Object> listNamespaces(){
		List<NamespaceVO> namespaceVOs = new ArrayList<NamespaceVO>();
		namespaceVOs = namespaceService.listAllNamespaces();
		Map<String, Object> result = new HashMap<String, Object>();
		result.put("data", namespaceVOs);
		return result;
		
	}
	
	
	@POST
	@Path("/add")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public void createNamespace(@Context HttpServletRequest request,@JSONParam("order") OrderVO orderVO){
		OrderItemVO orderItemVO = orderService.queryOrderItem(orderVO.getId());
		
		NamespaceApi namespaceApi = new NamespaceApi();
		namespaceApi.createNamespace(orderItemVO.getName());
		//资源配额
		namespaceApi.createResourceQuota(orderItemVO.getName(), orderItemVO.getCpu(), orderItemVO.getMemory(), orderItemVO.getPods());
		
		NamespaceVO namespaceVO = new NamespaceVO();
		namespaceVO.setName(orderItemVO.getName());		
		namespaceVO.setUserId((String) request.getSession().getAttribute("userId"));
		namespaceVO.setCpu(orderItemVO.getCpu());
		namespaceVO.setMemory(orderItemVO.getMemory());
		namespaceVO.setPods(orderItemVO.getPods());;
		namespaceVO.setStatus(namespaceApi.getStatus(orderItemVO.getName()));
		
		namespaceService.addNamespace(namespaceVO);
	}
	
	@POST
	@Path("/update")
	@Consumes(MediaType.APPLICATION_JSON)
	public void updateNamespace(@JSONParam("name") String name){
		NamespaceApi namespaceApi = new NamespaceApi();
		//
		//namespaceApi.createNamespace(name);
	}
	
	@DELETE
	@Path("/delete/{namespaceId}")
	@Consumes(MediaType.APPLICATION_JSON)
	public void deleteNamespace(@PathParam("namespaceId") String namespaceId){
		NamespaceApi namespaceApi = new NamespaceApi();
		namespaceApi.deleteNamespace(namespaceId);
		namespaceService.deleteNamespace(namespaceId);
	}
}

