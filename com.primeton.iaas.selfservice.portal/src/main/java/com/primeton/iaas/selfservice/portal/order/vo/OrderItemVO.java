/**
 * 
 */
package com.primeton.iaas.selfservice.portal.order.vo;

/**
 * @author Administrator
 *
 */
public class OrderItemVO {
	private String id;
	private String orderId;
	private String name;
	private int cpu;
	private int memory;
	private int pods;
	private String comments;
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
	 * @return the orderId
	 */
	public String getOrderId() {
		return orderId;
	}
	/**
	 * @param orderId the orderId to set
	 */
	public void setOrderId(String orderId) {
		this.orderId = orderId;
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
	 * @return the cpu
	 */
	public int getCpu() {
		return cpu;
	}
	/**
	 * @param cpu the cpu to set
	 */
	public void setCpu(int cpu) {
		this.cpu = cpu;
	}
	/**
	 * @return the memory
	 */
	public int getMemory() {
		return memory;
	}
	/**
	 * @param memory the memory to set
	 */
	public void setMemory(int memory) {
		this.memory = memory;
	}
	
	/**
	 * @return the pods
	 */
	public int getPods() {
		return pods;
	}
	/**
	 * @param pods the pods to set
	 */
	public void setPods(int pods) {
		this.pods = pods;
	}
	/**
	 * @return the comments
	 */
	public String getComments() {
		return comments;
	}
	/**
	 * @param comments the comments to set
	 */
	public void setComments(String comments) {
		this.comments = comments;
	}
	
	
}
