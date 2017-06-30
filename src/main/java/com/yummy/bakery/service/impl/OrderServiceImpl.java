package com.yummy.bakery.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.yummy.bakery.model.entity.Order;
import com.yummy.bakery.repository.OrderRepository;
import com.yummy.bakery.service.OrderService;

@Service
@Transactional
public class OrderServiceImpl implements OrderService {
	
	@Autowired
	private OrderRepository orderRepo;
	
	public void saveOrder(Order order) {
		orderRepo.saveAndFlush(order);
	}


}