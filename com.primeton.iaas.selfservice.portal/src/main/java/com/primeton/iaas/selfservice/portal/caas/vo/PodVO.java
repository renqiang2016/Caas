/**
 * 
 */
package com.primeton.iaas.selfservice.portal.caas.vo;

import java.util.List;

/**
 * @author RenQiang
 *
 */
public class PodVO {
	String id;
	String name;
	String namespace;
	String labels;
	String secret;
	List<ContainerVO> containers;
	int containerNum;
	String node;
	String status;
	String podIp;
	String startTime;
	
	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}
	/**
	 * @return the containerNum
	 */
	public int getContainerNum() {
		return containerNum;
	}
	/**
	 * @param containerNum the containerNum to set
	 */
	public void setContainerNum(int containerNum) {
		this.containerNum = containerNum;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the namespace
	 */
	public String getNamespace() {
		return namespace;
	}
	/**
	 * @param namespace the namespace to set
	 */
	public void setNamespace(String namespace) {
		this.namespace = namespace;
	}
	/**
	 * @return the labels
	 */
	public String getLabels() {
		return labels;
	}
	/**
	 * @param labels the labels to set
	 */
	public void setLabels(String labels) {
		this.labels = labels;
	}
	/**
	 * @return the secret
	 */
	public String getSecret() {
		return secret;
	}
	/**
	 * @param secret the secret to set
	 */
	public void setSecret(String secret) {
		this.secret = secret;
	}
	/**
	 * @return the containers
	 */
	public List<ContainerVO> getContainers() {
		return containers;
	}
	/**
	 * @param containers the containers to set
	 */
	public void setContainers(List<ContainerVO> containers) {
		this.containers = containers;
	}
	/**
	 * @return the node
	 */
	public String getNode() {
		return node;
	}
	/**
	 * @param node the node to set
	 */
	public void setNode(String node) {
		this.node = node;
	}
	/**
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}
	/**
	 * @param status the status to set
	 */
	public void setStatus(String status) {
		this.status = status;
	}
	/**
	 * @return the podIp
	 */
	public String getPodIp() {
		return podIp;
	}
	/**
	 * @param podIp the podIp to set
	 */
	public void setPodIp(String podIp) {
		this.podIp = podIp;
	}
	/**
	 * @return the createTime
	 */
	public String getStartTime() {
		return startTime;
	}
	/**
	 * @param createTime the createTime to set
	 */
	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}
	
	
}
