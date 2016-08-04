/**
 * 
 */
package com.primeton.iaas.selfservice.portal.caas.api;

import java.util.ArrayList;
import java.util.List;

import com.primeton.iaas.selfservice.portal.caas.vo.PodVO;

import io.fabric8.kubernetes.api.model.Pod;
import io.fabric8.kubernetes.client.Config;
import io.fabric8.kubernetes.client.DefaultKubernetesClient;
import io.fabric8.kubernetes.client.KubernetesClient;

/**
 * @author RenQiang
 *
 */
public class PodApi {
	public List<PodVO> listPods() {
		List<PodVO> result = new ArrayList<PodVO>();
		Config config = new Config();
		KubernetesClient kubernetesClient = new DefaultKubernetesClient("192.168.71.136:8080");
		for (Pod pod : kubernetesClient.pods().list().getItems()) {
			PodVO podVO = new PodVO();
			podVO.setName(pod.getMetadata().getName());
			podVO.setNamespace(pod.getMetadata().getNamespace());
			//System.out.println(pod.getMetadata().getLabels().toString());
			//System.out.println(pod.getSpec().getVolumes().toString());
			if (pod.getMetadata().getLabels() != null) {
				podVO.setLabels(pod.getMetadata().getLabels().toString().split("=")[1].split("}")[0]);
			}
			if (pod.getSpec().getVolumes() != null) {
				podVO.setSecret(pod.getSpec().getVolumes().toString().split(",")[16].substring(6));
			}
			
			podVO.setContainerNum(pod.getSpec().getContainers().size());
			podVO.setNode(pod.getSpec().getNodeName());
			podVO.setStatus(pod.getStatus().getPhase());
			podVO.setPodIp(pod.getStatus().getPodIP());
			podVO.setStartTime(pod.getStatus().getStartTime());
			result.add(podVO);
		}
		return result;
	}
	
	public List<PodVO> listPods(String namespace) {
		List<PodVO> result = new ArrayList<PodVO>();
		Config config = new Config();
		KubernetesClient kubernetesClient = new DefaultKubernetesClient("192.168.71.136:8080");
		for (Pod pod : kubernetesClient.pods().inNamespace(namespace).list().getItems()) {
			PodVO podVO = new PodVO();
			podVO.setName(pod.getMetadata().getName());
			podVO.setNamespace(pod.getMetadata().getNamespace());
			//System.out.println(pod.getMetadata().getLabels().toString());
			//System.out.println(pod.getSpec().getVolumes().toString());
			if (pod.getMetadata().getLabels() != null) {
				podVO.setLabels(pod.getMetadata().getLabels().toString().split("=")[1].split("}")[0]);
			}
			if (pod.getSpec().getVolumes() != null) {
				podVO.setSecret(pod.getSpec().getVolumes().toString().split(",")[16].substring(6));
			}
			
			podVO.setContainerNum(pod.getSpec().getContainers().size());
			podVO.setNode(pod.getSpec().getNodeName());
			podVO.setStatus(pod.getStatus().getPhase());
			podVO.setPodIp(pod.getStatus().getPodIP());
			podVO.setStartTime(pod.getStatus().getStartTime());
			result.add(podVO);
		}
		return result;
	}
}
