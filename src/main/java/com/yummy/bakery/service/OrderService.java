package com.yummy.bakery.service;

import java.util.List;

import com.yummy.bakery.model.entity.Order;

public interface OrderService {
	
	public Order saveOrder(Order order);
	
	public List<Order> getOrders(String userId);
	
	public boolean checkOrder(Order order);

	public Order getOrderById(long id);

}
