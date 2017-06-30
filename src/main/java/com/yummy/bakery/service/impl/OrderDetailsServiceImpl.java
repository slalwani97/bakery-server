package com.yummy.bakery.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.yummy.bakery.model.entity.OrderDetails;
import com.yummy.bakery.repository.OrderDetailsRepository;
import com.yummy.bakery.service.OrderDetailsService;

@Service
@Transactional
public class OrderDetailsServiceImpl implements OrderDetailsService {

	@Autowired
	OrderDetailsRepository orderDetailsRepository;
	
	public void saveOrder(OrderDetails order) {
		orderDetailsRepository.save(order);
	}
}
