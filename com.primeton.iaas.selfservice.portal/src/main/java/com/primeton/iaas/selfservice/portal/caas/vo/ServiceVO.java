/**
 * 
 */
package com.primeton.iaas.selfservice.portal.caas.vo;

import java.util.List;

/**
 * @author RenQiang
 *
 */
public class ServiceVO {
	String id;
	String name;
	String namespace;
	String labels;
	String selector;	
	String createTime;
	String port;
	String targetPort;
	String nodePort;
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
	 * @return the selector
	 */
	public String getSelector() {
		return selector;
	}
	/**
	 * @param selector the selector to set
	 */
	public void setSelector(String selector) {
		this.selector = selector;
	}
	/**
	 * @return the createTime
	 */
	public String getCreateTime() {
		return createTime;
	}
	/**
	 * @param createTime the createTime to set
	 */
	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}
	/**
	 * @return the port
	 */
	public String getPort() {
		return port;
	}
	/**
	 * @param port the port to set
	 */
	public void setPort(String port) {
		this.port = port;
	}
	/**
	 * @return the targetPort
	 */
	public String getTargetPort() {
		return targetPort;
	}
	/**
	 * @param targetPort the targetPort to set
	 */
	public void setTargetPort(String targetPort) {
		this.targetPort = targetPort;
	}
	/**
	 * @return the nodePort
	 */
	public String getNodePort() {
		return nodePort;
	}
	/**
	 * @param nodePort the nodePort to set
	 */
	public void setNodePort(String nodePort) {
		this.nodePort = nodePort;
	}
	
	
}
