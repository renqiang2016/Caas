/**
 * 
 */
package com.primeton.iaas.selfservice.portal.caas.vo;

/**
 * @author RenQiang
 *
 */
public class ReplicationControllerVO {
	String id;//name
	String namespace;
	String createTime;
	String labels;
	String selector;
	int replicas;
	String image;
	String restartPolicy;
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
	 * @return the replicas
	 */
	public int getReplicas() {
		return replicas;
	}
	/**
	 * @param replicas the replicas to set
	 */
	public void setReplicas(int replicas) {
		this.replicas = replicas;
	}
	/**
	 * @return the image
	 */
	public String getImage() {
		return image;
	}
	/**
	 * @param image the image to set
	 */
	public void setImage(String image) {
		this.image = image;
	}
	/**
	 * @return the restartPolicy
	 */
	public String getRestartPolicy() {
		return restartPolicy;
	}
	/**
	 * @param restartPolicy the restartPolicy to set
	 */
	public void setRestartPolicy(String restartPolicy) {
		this.restartPolicy = restartPolicy;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "ReplicationControllerVO [id=" + id + ", namespace=" + namespace + ", createTime=" + createTime
				+ ", labels=" + labels + ", selector=" + selector + ", replicas=" + replicas + ", image=" + image
				+ ", restartPolicy=" + restartPolicy + "]";
	}
	
	
}
