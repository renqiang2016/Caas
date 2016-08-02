/**
 * 
 */
package com.primeton.iaas.selfservice.portal.order.dao;

import java.util.List;

import com.primeton.iaas.selfservice.portal.mybatis.IMarkerInterface;
import com.primeton.iaas.selfservice.portal.order.vo.OrderItemVO;
import com.primeton.iaas.selfservice.portal.order.vo.OrderVO;

/**
 * @author Administrator
 *
 */
public interface OrderDao extends IMarkerInterface{
	
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
