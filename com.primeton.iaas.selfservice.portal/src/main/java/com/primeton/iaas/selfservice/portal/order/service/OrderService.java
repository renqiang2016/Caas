/**
 * 
 */
package com.primeton.iaas.selfservice.portal.order.service;

import java.util.List;

import com.primeton.iaas.selfservice.portal.order.vo.OrderItemVO;
import com.primeton.iaas.selfservice.portal.order.vo.OrderVO;

/**
 * @author Administrator
 *
 */
public interface OrderService {
	void addOrder(OrderVO order);
	
	void addOrderItem(OrderItemVO orderItem);
	
	void deleteOrder(String orderId);
	
	void deleteOrderItem(String orderId);
	
	void updateOrder(OrderVO order);
	
	void updateOrderItem(OrderItemVO orderItem);
	
	List<OrderVO> queryAllOrders();
	
	List<OrderVO> queryUserOrders(String userId);
	
	OrderVO queryOneOrder(String orderId);
	
	OrderItemVO queryOrderItem(String orderId);
	
	
}
