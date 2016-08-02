/**
 * 
 */
package com.primeton.iaas.selfservice.portal.caas.api;

import java.util.ArrayList;
import java.util.List;

import com.primeton.iaas.selfservice.portal.caas.vo.ServiceAccountVO;

import io.fabric8.kubernetes.api.model.ServiceAccount;
import io.fabric8.kubernetes.client.Config;
import io.fabric8.kubernetes.client.DefaultKubernetesClient;
import io.fabric8.kubernetes.client.KubernetesClient;

/**
 * @author RenQiang
 *
 */
public class ServiceAccountApi {
	public List<ServiceAccountVO> listServiceAccounts() {
		List<ServiceAccountVO> result = new ArrayList<ServiceAccountVO>();
		Config config = new Config();
		KubernetesClient kubernetesClient = new DefaultKubernetesClient("192.168.71.136:8080");
		for (ServiceAccount serviceAccount : kubernetesClient.serviceAccounts().list().getItems()) {
			ServiceAccountVO serviceAccountVO = new ServiceAccountVO();
			serviceAccountVO.setName(serviceAccount.getMetadata().getName());
			serviceAccountVO.setNamespace(serviceAccount.getMetadata().getNamespace());
			serviceAccountVO.setSecret(serviceAccount.getSecrets().toString().split(",")[3].substring(6));
			serviceAccountVO.setCreateTime(serviceAccount.getMetadata().getCreationTimestamp());
			result.add(serviceAccountVO);
		}
		return result;
	}
	
}
