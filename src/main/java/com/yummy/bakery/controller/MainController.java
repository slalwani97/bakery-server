package com.yummy.bakery.controller;



import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.yummy.bakery.model.entity.Order;
import com.yummy.bakery.model.entity.OrderDetails;
import com.yummy.bakery.service.OrderService;


@RestController
public class MainController {
	
	@Autowired
	private OrderService orderService;
	
	/*@Autowired
	private SaveOrderService saveOrderService;*/

    @CrossOrigin
    @RequestMapping(value = "/checkout", method = RequestMethod.POST)
	public ResponseEntity<?> uploadCheckout(@RequestBody Order order ) {
    	Set<OrderDetails> details = new HashSet<>(order.getOrderDetails()); 
    	for(OrderDetails detail : details) {
    		System.out.println(detail.getProduct().getQuantity());
    	}
        orderService.saveOrder(order);
    	return new ResponseEntity<>(order , HttpStatus.CREATED);
    	
    	/*saveOrderService.saveOrder();
    	return new ResponseEntity<>(HttpStatus.OK);*/
		
	}
    
}