/**
 * 
 */
package com.primeton.iaas.selfservice.portal.caas.secrets.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.primeton.iaas.selfservice.portal.caas.api.SecretApi;
import com.primeton.iaas.selfservice.portal.caas.api.ServiceAccountApi;
import com.primeton.iaas.selfservice.portal.caas.vo.SecretVO;
import com.primeton.iaas.selfservice.portal.caas.vo.ServiceAccountVO;

/**
 * @author RenQiang
 *
 */
@Path("/caas/secrets")
public class SecretController {
	@GET
	@Path("/list")
	@Produces(MediaType.APPLICATION_JSON)
	public Map<String, Object> listSecrets(){
		List<SecretVO> secretVOs= new ArrayList<SecretVO>();
		SecretApi secretApi = new SecretApi();
		secretVOs = secretApi.listSecrets();
		Map<String, Object> result = new HashMap<String, Object>();
		result.put("data", secretVOs);
		return result;
	}
}
