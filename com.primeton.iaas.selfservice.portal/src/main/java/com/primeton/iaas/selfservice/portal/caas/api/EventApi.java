/**
 * 
 */
package com.primeton.iaas.selfservice.portal.caas.api;

import java.util.ArrayList;
import java.util.List;

import com.primeton.iaas.selfservice.portal.caas.vo.EventVO;

import io.fabric8.kubernetes.api.model.Event;
import io.fabric8.kubernetes.client.Config;
import io.fabric8.kubernetes.client.DefaultKubernetesClient;
import io.fabric8.kubernetes.client.KubernetesClient;

/**
 * @author RenQiang
 *
 */
public class EventApi {
	public List<EventVO> listEvents() {
		List<EventVO> result = new ArrayList<EventVO>();
		Config config = new Config();
		KubernetesClient kubernetesClient = new DefaultKubernetesClient("192.168.71.136:8080");
		for (Event event : kubernetesClient.events().list().getItems()) {
			EventVO eventVO = new EventVO();
			eventVO.setName(event.getMetadata().getName());
			eventVO.setNamespace(event.getMetadata().getNamespace());
			eventVO.setCreateTime(event.getMetadata().getCreationTimestamp());
			eventVO.setDeletionTime(event.getMetadata().getDeletionTimestamp());
			eventVO.setReason(event.getReason());
			eventVO.setMessage(event.getMessage());
			eventVO.setFirstTime(event.getFirstTimestamp());
			eventVO.setLastTime(event.getLastTimestamp());
			result.add(eventVO);
		}
		return result;
	}
}
