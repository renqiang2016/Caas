/**
 * 
 */
package com.primeton.iaas.selfservice.portal.order.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import com.primeton.components.rest.annotation.JSONParam;
import com.primeton.iaas.selfservice.portal.log.LoggerService;
import com.primeton.iaas.selfservice.portal.order.service.OrderService;
import com.primeton.iaas.selfservice.portal.order.vo.OrderItemVO;
import com.primeton.iaas.selfservice.portal.order.vo.OrderMapVO;
import com.primeton.iaas.selfservice.portal.order.vo.OrderVO;
import com.primeton.iaas.selfservice.portal.utils.SpringBeanUtils;

/**
 * @author Administrator
 *
 */

@Path("/order")
public class OrderController {
	private OrderService service = SpringBeanUtils.getBean("orderService");
	private static final Logger logger = LoggerService.getTraceLogger(OrderController.class);
	
	@GET
	@Path("/list")
	@Produces(MediaType.APPLICATION_JSON)
	public Map<String, Object> listOrders(){
		List<OrderVO> orders = new ArrayList<OrderVO>();
		orders = service.queryAllOrders();
		Map<String, Object> result = new HashMap<String, Object>();
		result.put("data", orders);
		return result;
	}
	
	@GET
	@Path("/listUserOrders/{userId}")
	@Produces(MediaType.APPLICATION_JSON)
	public Map<String, Object> listUserOrders(@PathParam("userId") String userId){
		List<OrderVO> orders = new ArrayList<OrderVO>();
		orders = service.queryUserOrders(userId);
		Map<String, Object> result = new HashMap<String, Object>();
		result.put("data", orders);
		return result;
	}
	
	
	@GET
	@Path("/listApproval")
	@Produces(MediaType.APPLICATION_JSON)
	public Map<String, Object> listApprovalOrders(){
		List<OrderVO> orders = new ArrayList<OrderVO>();
		for (OrderVO order : service.queryAllOrders()) {
			if (order.getStatus()>2) {
				orders.add(order);
			}
		}
		Map<String, Object> result = new HashMap<String, Object>();
		result.put("data", orders);
		return result;
	}
	
	@GET
	@Path("/listDeal")
	@Produces(MediaType.APPLICATION_JSON)
	public Map<String, Object> listDealOrders(){
		List<OrderVO> orders = new ArrayList<OrderVO>();
		for (OrderVO order : service.queryAllOrders()) {
			if (order.getStatus()>=4) {
				orders.add(order);
			}
		}
		Map<String, Object> result = new HashMap<String, Object>();
		result.put("data", orders);
		return result;
	}
	
	@GET
	@Path("/list/{orderId}/item")
	@Produces(MediaType.APPLICATION_JSON)
	public Map<String, Object> listOrderItem(@PathParam("orderId") String orderId){
		List<OrderItemVO> orderItems = new ArrayList<OrderItemVO>();
		orderItems.add(service.queryOrderItem(orderId));
		Map<String, Object> result = new HashMap<String, Object>();
		result.put("data", orderItems);
		return result;
	}
	
	@POST
	@Path("/add")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public void addOrder(@Context HttpServletRequest request,@JSONParam("orderItem") OrderItemVO orderItem){
		OrderVO order = new OrderVO();
		order.setId(orderItem.getOrderId());
		order.setUserId((String) request.getSession().getAttribute("userId"));
		service.addOrder(order);
		service.addOrderItem(orderItem);
	}
	
	@POST
	@Path("/update/item")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public void updateOrderItem(@JSONParam("orderItem") OrderItemVO orderItem){
		service.updateOrderItem(orderItem);
	}
	
	@POST
	@Path("/update")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public void updateOrder(@JSONParam("order") OrderVO order){
		service.updateOrder(order);
	}
	
	@DELETE
	@Path("/delete/{orderId}")
	@Consumes(MediaType.APPLICATION_JSON)
	public void deleteOrder(@PathParam("orderId") String orderId){
		service.deleteOrderItem(orderId);
		service.deleteOrder(orderId);
		
	}
	
	@GET
	@Path("/isExist/{orderId}")
	@Produces(MediaType.APPLICATION_JSON)
	public Map<String, Object> isExist(@PathParam("orderId") String orderId){
		OrderVO order = new OrderVO();
		order = service.queryOneOrder(orderId);
		Map<String, Object> result = new HashMap<String, Object>();
		result.put("data", order);
		return result;
	}
	
	
}
