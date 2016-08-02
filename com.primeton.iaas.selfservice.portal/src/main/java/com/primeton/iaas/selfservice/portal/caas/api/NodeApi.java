/**
 * 
 */
package com.primeton.iaas.selfservice.portal.caas.api;

import java.util.ArrayList;
import java.util.List;

import com.primeton.iaas.selfservice.portal.caas.vo.NodeVO;

import io.fabric8.kubernetes.api.model.Node;
import io.fabric8.kubernetes.client.Config;
import io.fabric8.kubernetes.client.DefaultKubernetesClient;
import io.fabric8.kubernetes.client.KubernetesClient;

/**
 * @author RenQiang
 *
 */
public class NodeApi {
	
	public List<NodeVO> listNodes() {
		List<NodeVO> result = new ArrayList<NodeVO>();
		Config config = new Config();
		KubernetesClient kubernetesClient = new DefaultKubernetesClient("192.168.71.136:8080");
		for (Node node : kubernetesClient.nodes().list().getItems()) {
//			System.out.println(node.toString());
			NodeVO nodeVO = new NodeVO();
			nodeVO.setName(node.getMetadata().getName());
			nodeVO.setIp(node.getStatus().getAddresses().toString().split(",")[0].substring(21));
			nodeVO.setCpu(node.getStatus().getAllocatable().toString().split(",")[0].substring(21));
			nodeVO.setMemory(node.getStatus().getAllocatable().toString().split(",")[3].substring(24));
			nodeVO.setCreateTime(node.getMetadata().getCreationTimestamp());
			nodeVO.setStatus(node.getStatus().getConditions().toString().split(",")[12].substring(6));
			result.add(nodeVO);
		}
		return result;
		
	}
	
	public void createNode(Node node){
		
	}
	
	public void deleteNode(String nodeName) {
		
	}
	
	public Node getNode(String nodeName){
		return null;
		
	}
	
	public void updatePart() {
		
	}
	
	public void updateAll() {
		
	}
}
