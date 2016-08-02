/**
 * 
 */
package com.primeton.iaas.selfservice.portal.order.service;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.primeton.iaas.selfservice.portal.order.dao.OrderDao;
import com.primeton.iaas.selfservice.portal.order.vo.OrderItemVO;
import com.primeton.iaas.selfservice.portal.order.vo.OrderVO;

/**
 * @author Administrator
 *
 */
@Service("orderService")
public class OrderServiceImpl implements OrderService {

	@Autowired
	private OrderDao orderDao;
	
	@Override
	public void addOrder(OrderVO order) {
		Date date = new Date();
		order.setCreateTime(date);
		order.setModifiedTime(date);
		order.setStatus(0);
//		order.setUserId("test");
		orderDao.addOrder(order);
		
	}

	@Override
	public void deleteOrder(String orderId) {
		orderDao.deleteOrder(orderId);
		
	}

	@Override
	public void updateOrder(OrderVO order) {
		Date date = new Date();
		order.setModifiedTime(date);
		orderDao.updateOrder(order);
		
	}

	@Override
	public List<OrderVO> queryAllOrders() {
		return orderDao.queryAllOrders();
	}
	
	@Override
	public List<OrderVO> queryUserOrders(String userId) {
		return orderDao.queryUserOrders(userId);
	}

	@Override
	public OrderVO queryOneOrder(String orderId) {
		return orderDao.queryOneOrder(orderId);
	}

	public OrderItemVO queryOrderItem(String orderId) {
		return orderDao.queryOrderItem(orderId);
	}

	public void updateOrderItem(OrderItemVO orderItem) {
		orderDao.updateOrderItem(orderItem);
		
	}

	public void deleteOrderItem(String orderId) {
		orderDao.deleteOrderItem(orderId);
		
	}

	public void addOrderItem(OrderItemVO orderItem) {
		if (orderItem.getId() == null || orderItem.getId().trim().length() == 0) {
			orderItem.setId(UUID.randomUUID().toString());
		}
		orderDao.addOrderItem(orderItem);
		
	}

	

}
