/**
 * 
 */
package com.primeton.iaas.selfservice.portal.caas.pods.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

import org.omg.CosNaming.NamingContextExtPackage.StringNameHelper;

import com.primeton.iaas.selfservice.portal.caas.api.PodApi;
import com.primeton.iaas.selfservice.portal.caas.namespaces.service.NamespaceService;
import com.primeton.iaas.selfservice.portal.caas.vo.NamespaceVO;
import com.primeton.iaas.selfservice.portal.caas.vo.PodVO;
import com.primeton.iaas.selfservice.portal.utils.SpringBeanUtils;

/**
 * @author RenQiang
 *
 */
@Path("/caas/pods")
public class PodController {
	
	private NamespaceService namespaceService = SpringBeanUtils.getBean("caasNamespaceService");
	
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
	
	@GET
	@Path("/lists")
	@Produces(MediaType.APPLICATION_JSON)
	public Map<String, Object> listsPods(@Context HttpServletRequest request){
		List<NamespaceVO> namespaces = new ArrayList<NamespaceVO>();
		List<PodVO> pods = new ArrayList<PodVO>();
		namespaces = namespaceService.listUserNamespaces((String) request.getSession().getAttribute("userId"));
		PodApi podApi = new PodApi();
		for (NamespaceVO namespaceVO : namespaces) {
			pods.addAll(podApi.listPods(namespaceVO.getName()));
		}
		Map<String, Object> result = new HashMap<String, Object>();
		result.put("data", pods);
		return result;
	}
}
