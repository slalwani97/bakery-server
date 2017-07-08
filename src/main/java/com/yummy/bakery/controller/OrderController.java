package com.yummy.bakery.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.yummy.bakery.model.entity.Order;
import com.yummy.bakery.model.entity.Product;
import com.yummy.bakery.service.OrderService;
import com.yummy.bakery.service.ProductService;

@RestController
public class OrderController {
	
	@Autowired
	private OrderService orderService;
	
	@Autowired
	private ProductService productService;
	
	@RequestMapping(value = "/orders/{userId}", method = RequestMethod.GET)
    public ResponseEntity<?> getUser(@PathVariable("userId") String userId) {
		System.out.println("Order Called.. ");
		List<Order> orders = orderService.getOrders(userId);
		if (orders.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
        
        return new ResponseEntity<List<Order>>(orders, HttpStatus.OK);
    }
	
	@CrossOrigin
    @RequestMapping(value = "/checkout", method = RequestMethod.POST)
	public ResponseEntity<?> saveOrder(@RequestBody Order order) {
    	
    	if(orderService.checkOrder(order)) {
    		order = orderService.saveOrder(order);
    		
    		//Order savedOrder = orderService.getOrderById(order.getId());
    		return new ResponseEntity<Order>(order, HttpStatus.CREATED);
    	}
    	List<Product> products = productService.getProducts();
    	return new ResponseEntity<List<Product>>(products, HttpStatus.BAD_REQUEST);
	}

}
