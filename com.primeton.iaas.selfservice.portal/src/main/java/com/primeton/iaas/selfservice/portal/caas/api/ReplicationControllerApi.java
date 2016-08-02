/**
 * 
 */
package com.primeton.iaas.selfservice.portal.caas.api;

import java.util.ArrayList;
import java.util.List;

import org.yaml.snakeyaml.Yaml;

import com.primeton.iaas.selfservice.portal.caas.vo.ReplicationControllerVO;

import io.fabric8.kubernetes.api.model.ReplicationController;
import io.fabric8.kubernetes.api.model.ReplicationControllerBuilder;
import io.fabric8.kubernetes.client.Config;
import io.fabric8.kubernetes.client.DefaultKubernetesClient;
import io.fabric8.kubernetes.client.KubernetesClient;

/**
 * @author RenQiang
 *
 */
public class ReplicationControllerApi {
	public List<ReplicationControllerVO> listReplicationControllers() {
		List<ReplicationControllerVO> result = new ArrayList<ReplicationControllerVO>();
		Config config = new Config();
		Yaml yaml = new Yaml();
		KubernetesClient kubernetesClient = new DefaultKubernetesClient("192.168.71.136:8080");
		for (ReplicationController replicationController : kubernetesClient.replicationControllers().list().getItems()) {
			ReplicationControllerVO replicationControllerVO = new ReplicationControllerVO();
			replicationControllerVO.setId(replicationController.getMetadata().getName());
			replicationControllerVO.setNamespace(replicationController.getMetadata().getNamespace());
			replicationControllerVO.setCreateTime(replicationController.getMetadata().getCreationTimestamp());
			replicationControllerVO.setLabels(replicationController.getMetadata().getLabels().toString().split("=")[1].split("}")[0]);
			replicationControllerVO.setSelector(replicationController.getSpec().getSelector().toString().split("=")[1].split("}")[0]);
			replicationControllerVO.setReplicas(replicationController.getSpec().getReplicas());
			String temp = replicationController.getSpec().getTemplate().getSpec().getContainers().toString();
			replicationControllerVO.setImage(temp.substring(temp.indexOf("image")+6, temp.indexOf("imagePullPolicy")-2));
			replicationControllerVO.setRestartPolicy(replicationController.getSpec().getTemplate().getSpec().getRestartPolicy());
			
			
			//System.out.println(yaml.dump(replicationController));
			
			result.add(replicationControllerVO);
		}
		return result;
	}
	
	public void createReplicationController(ReplicationControllerVO replicationControllerVO) {
		
		KubernetesClient kubernetesClient = new DefaultKubernetesClient("192.168.71.136:8080");
		ReplicationController rc = new ReplicationControllerBuilder()
                .withNewMetadata().withName("nginx-controller").withNamespace("namespace").addToLabels("server", "nginx").endMetadata()
                .withNewSpec().withReplicas(1).addToSelector("", "")
                .withNewTemplate()
                .withNewMetadata().addToLabels("server", "nginx").endMetadata()
                .withNewSpec()
                .addNewContainer().withName("nginx").withImage("nginx")
                .addNewPort().withContainerPort(80).endPort()
                .endContainer()
                .endSpec()
                .endTemplate()
                .endSpec().build();
		kubernetesClient.replicationControllers().inNamespace("test").create(rc);
	}
	
	public void updateReplicationController(ReplicationControllerVO replicationControllerVO) {
		
	}
	
	public void deleteReplicationController(ReplicationControllerVO replicationControllerVO) {
		
	}
}
