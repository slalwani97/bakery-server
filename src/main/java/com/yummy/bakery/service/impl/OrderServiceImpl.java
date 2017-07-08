package com.yummy.bakery.service.impl;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.yummy.bakery.model.entity.Order;
import com.yummy.bakery.model.entity.OrderDetails;
import com.yummy.bakery.model.entity.Product;
import com.yummy.bakery.repository.OrderRepository;
import com.yummy.bakery.service.OrderService;
import com.yummy.bakery.service.ProductService;

@Service
@Transactional
public class OrderServiceImpl implements OrderService {
	
	@Autowired
	EntityManager em;
	
	@Autowired
	private OrderRepository orderRepo;
	
	@Autowired
	private ProductService productService;
	
	@Override
	public Order saveOrder(Order order) {
		order = orderRepo.saveAndFlush(order);
		
		Set<OrderDetails> details = new HashSet<>(order.getOrderDetails()); 
    	for(OrderDetails detail : details) {
    		em.merge(detail.getProduct());
    	}

    	return order;
		
	}
	
	@Override
	public boolean checkOrder(Order order) {
		boolean flag = false;
		Set<OrderDetails> details = new HashSet<>(order.getOrderDetails());
		for(OrderDetails detail : details) {
			long id = detail.getProduct().getId();
			Product product = productService.getProductById(id);
			if(product.getQuantity() < detail.getQuantityRequired()) {
				flag = true;
				break;
			}
		}
		if(flag) {
			return false;
		}
		return true;
	}
	
	@Override
	public List<Order> getOrders(String userId) {
		 TypedQuery<Order> q2 =
			      em.createQuery("Select a from Order a where a.userId=:userId", Order.class);
		q2.setParameter("userId", userId);
		List<Order> orders = q2.getResultList();
		return orders;
	}

	@Override
	public Order getOrderById(long id) {
		return orderRepo.getOne(id);
	}


}
