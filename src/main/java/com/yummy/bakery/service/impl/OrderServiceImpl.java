package com.yummy.bakery.service.impl;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.yummy.bakery.model.entity.Order;
import com.yummy.bakery.model.entity.OrderDetails;
import com.yummy.bakery.repository.OrderRepository;
import com.yummy.bakery.service.OrderService;

@Service
@Transactional
public class OrderServiceImpl implements OrderService {
	
	@Autowired
	EntityManager em;
	
	@Autowired
	private OrderRepository orderRepo;
	
	public void saveOrder(Order order) {
		order = orderRepo.saveAndFlush(order);
		
		Set<OrderDetails> details = new HashSet<>(order.getOrderDetails()); 
    	for(OrderDetails detail : details) {
    		em.merge(detail.getProduct());
    	}
		
	}


}
