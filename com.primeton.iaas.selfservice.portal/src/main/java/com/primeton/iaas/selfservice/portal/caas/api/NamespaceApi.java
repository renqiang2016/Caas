/**
 * 
 */
package com.primeton.iaas.selfservice.portal.caas.api;

import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

import com.primeton.iaas.selfservice.portal.caas.vo.NamespaceVO;

import io.fabric8.kubernetes.api.model.Namespace;
import io.fabric8.kubernetes.api.model.NamespaceBuilder;
import io.fabric8.kubernetes.api.model.Quantity;
import io.fabric8.kubernetes.api.model.ResourceQuota;
import io.fabric8.kubernetes.api.model.ResourceQuotaBuilder;
import io.fabric8.kubernetes.client.Config;
import io.fabric8.kubernetes.client.DefaultKubernetesClient;
import io.fabric8.kubernetes.client.KubernetesClient;

/**
 * @author RenQiang
 *
 */
public class NamespaceApi {
	
	public List<NamespaceVO> listNamespaces() {
		List<NamespaceVO> result = new ArrayList<NamespaceVO>();
		Config config = new Config();
		KubernetesClient kubernetesClient = new DefaultKubernetesClient("192.168.71.136:8080");
		for (Namespace namespace : kubernetesClient.namespaces().list().getItems()) {
			NamespaceVO namespaceVO = new NamespaceVO();
			namespaceVO.setId(namespace.getMetadata().getUid());
			namespaceVO.setName(namespace.getMetadata().getName());
			//namespaceVO.setCreateTime(namespace.getMetadata().getCreationTimestamp());
			namespaceVO.setStatus(namespace.getStatus().getPhase());
			result.add(namespaceVO);
		}
		return result;
	}
	
	public void createNamespace(String name) {
		KubernetesClient kubernetesClient = new DefaultKubernetesClient("192.168.71.136:8080");
		Namespace namespace = new NamespaceBuilder().withNewMetadata().withName(name).endMetadata().build();
		kubernetesClient.namespaces().create(namespace);
	}
	
	public void createResourceQuota(String name,int cpu, int memory, int disk) {
		KubernetesClient kubernetesClient = new DefaultKubernetesClient("192.168.71.136:8080");
		ResourceQuota quota = new ResourceQuotaBuilder().withNewMetadata()
				.withName(name + "-quota")
				.withNamespace(name)
				.endMetadata()
				.withNewSpec()
				.addToHard("cpu", new Quantity(cpu + ""))
				.addToHard("memory", new Quantity(memory + "Mi"))
				.addToHard("disk", new Quantity(disk + "Mi"))
				.endSpec().build();
		kubernetesClient.resourceQuotas().inNamespace(name).create(quota);
	}
	
	public void updateNamespace(String name, NamespaceVO namespaceVO) {
		KubernetesClient kubernetesClient = new DefaultKubernetesClient("192.168.71.136:8080");
		//kubernetesClient.namespaces().withName(name).update(namespaceVO)
		
	}
	
	public void deleteNamespace(String name) {
		KubernetesClient kubernetesClient = new DefaultKubernetesClient("192.168.71.136:8080");
		kubernetesClient.namespaces().withName(name).delete();
	}
	
	public String getStatus(String name){
		String result = null;
		Config config = new Config();
		KubernetesClient kubernetesClient = new DefaultKubernetesClient("192.168.71.136:8080");
		for (Namespace namespace : kubernetesClient.namespaces().list().getItems()) {
			if (namespace.getMetadata().getName().equals(name)) {
				result = namespace.getStatus().getPhase();
			}
		}
		return result;
	}
}
