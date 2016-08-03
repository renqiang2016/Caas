/**
 * 
 */
package com.primeton.iaas.selfservice.portal.caas.api;

import java.util.ArrayList;
import java.util.List;

import com.primeton.iaas.selfservice.portal.caas.vo.EndPointVO;

import io.fabric8.kubernetes.api.model.Endpoints;
import io.fabric8.kubernetes.client.Config;
import io.fabric8.kubernetes.client.DefaultKubernetesClient;
import io.fabric8.kubernetes.client.KubernetesClient;

/**
 * @author RenQiang
 *
 */
public class EndpointApi {
	public List<EndPointVO> listEndpoints() {
		List<EndPointVO> result = new ArrayList<EndPointVO>();
		Config config = new Config();
		KubernetesClient kubernetesClient = new DefaultKubernetesClient("192.168.71.136:8080");
		for (Endpoints endpoint : kubernetesClient.endpoints().list().getItems()) {
			EndPointVO endPointVO = new EndPointVO();
			endPointVO.setName(endpoint.getMetadata().getName());
			endPointVO.setNamespace(endpoint.getMetadata().getNamespace());
			if (endpoint.getMetadata().getLabels() == null) {
				endPointVO.setLabels(null);
			} else {
				endPointVO.setLabels(endpoint.getMetadata().getLabels().toString().split("=")[1].split("}")[0]);
			}
			if (endpoint.getSubsets().toString() == "[]") {
				endPointVO.setIp(null);
			} else {
				System.out.println(endpoint.getSubsets().toString());
				System.out.println(endpoint.getSubsets().toString().split(",")[0].substring(46));
				System.out.println(endpoint.getSubsets().toString().split(",")[5].substring(6));
				endPointVO.setIp(endpoint.getSubsets().toString().split(",")[0].substring(46));
				endPointVO.setPort(endpoint.getSubsets().toString().split(",")[5].substring(6));
			}
			
			endPointVO.setCreateTime(endpoint.getMetadata().getCreationTimestamp());
			result.add(endPointVO);
		}
		return result;
	}
}
