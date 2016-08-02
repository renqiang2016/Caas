/**
 * 
 */
package com.primeton.iaas.selfservice.portal.caas.api;

import java.util.ArrayList;
import java.util.List;

import com.primeton.iaas.selfservice.portal.caas.vo.SecretVO;

import io.fabric8.kubernetes.api.model.Secret;
import io.fabric8.kubernetes.client.Config;
import io.fabric8.kubernetes.client.DefaultKubernetesClient;
import io.fabric8.kubernetes.client.KubernetesClient;

/**
 * @author RenQiang
 *
 */
public class SecretApi {
	public List<SecretVO> listSecrets() {
		List<SecretVO> result = new ArrayList<SecretVO>();
		Config config = new Config();
		KubernetesClient kubernetesClient = new DefaultKubernetesClient("192.168.71.136:8080");
		for (Secret secret: kubernetesClient.secrets().list().getItems()) {
			SecretVO secretVO = new SecretVO();
			secretVO.setName(secret.getMetadata().getName());
			secretVO.setNamespace(secret.getMetadata().getNamespace());
			secretVO.setCreateTime(secret.getMetadata().getCreationTimestamp());
			secretVO.setCertificate(secret.getData().toString());
			secretVO.setToken(secret.getData().toString());
			result.add(secretVO);
		}
		return result;
	}
}
