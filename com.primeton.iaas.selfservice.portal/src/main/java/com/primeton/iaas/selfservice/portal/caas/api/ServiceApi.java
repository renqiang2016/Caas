/**
 * 
 */
package com.primeton.iaas.selfservice.portal.caas.api;

import java.util.ArrayList;
import java.util.List;

import com.primeton.iaas.selfservice.portal.caas.vo.ServiceVO;

import io.fabric8.kubernetes.api.model.Service;
import io.fabric8.kubernetes.client.Config;
import io.fabric8.kubernetes.client.DefaultKubernetesClient;
import io.fabric8.kubernetes.client.KubernetesClient;

/**
 * @author RenQiang
 *
 */
public class ServiceApi {
	public List<ServiceVO> listServices() {
		List<ServiceVO> result = new ArrayList<ServiceVO>();
		Config config = new Config();
		KubernetesClient kubernetesClient = new DefaultKubernetesClient("192.168.71.136:8080");
		for (Service service : kubernetesClient.services().list().getItems()) {
			ServiceVO serviceVO = new ServiceVO();
			serviceVO.setName(service.getMetadata().getName());
			serviceVO.setNamespace(service.getMetadata().getNamespace());
			serviceVO.setLabels(service.getMetadata().getLabels().toString().split("=")[1].split("}")[0]);
			serviceVO.setCreateTime(service.getMetadata().getCreationTimestamp());
			if (service.getSpec().getSelector() == null) {
				serviceVO.setSelector(null);
			}else{
				serviceVO.setSelector(service.getSpec().getSelector().toString().split("=")[1].split("}")[0]);
			}
			System.out.println(service.getSpec().getPorts().toString());
			serviceVO.setPort(service.getSpec().getPorts().toString().split(",")[2].substring(6));
			serviceVO.setTargetPort(service.getSpec().getPorts().toString().split(",")[4].substring(31));
			
			serviceVO.setNodePort(service.getSpec().getPorts().toString().split(",")[1].substring(10));
			result.add(serviceVO);
		}
		return result;
	}
	
	public List<ServiceVO> listServices(String namespace) {
		List<ServiceVO> result = new ArrayList<ServiceVO>();
		Config config = new Config();
		KubernetesClient kubernetesClient = new DefaultKubernetesClient("192.168.71.136:8080");
		for (Service service : kubernetesClient.services().inNamespace(namespace).list().getItems()) {
			ServiceVO serviceVO = new ServiceVO();
			serviceVO.setName(service.getMetadata().getName());
			serviceVO.setNamespace(service.getMetadata().getNamespace());
			serviceVO.setLabels(service.getMetadata().getLabels().toString().split("=")[1].split("}")[0]);
			serviceVO.setCreateTime(service.getMetadata().getCreationTimestamp());
			if (service.getSpec().getSelector() == null) {
				serviceVO.setSelector(null);
			}else{
				serviceVO.setSelector(service.getSpec().getSelector().toString().split("=")[1].split("}")[0]);
			}
			System.out.println(service.getSpec().getPorts().toString());
			serviceVO.setPort(service.getSpec().getPorts().toString().split(",")[2].substring(6));
			serviceVO.setTargetPort(service.getSpec().getPorts().toString().split(",")[4].substring(31));
			
			serviceVO.setNodePort(service.getSpec().getPorts().toString().split(",")[1].substring(10));
			result.add(serviceVO);
		}
		return result;
	}
	
	
}
