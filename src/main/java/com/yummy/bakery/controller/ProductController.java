package com.yummy.bakery.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.yummy.bakery.model.entity.Product;
import com.yummy.bakery.service.ProductService;

@RestController
public class ProductController {
	
	@Autowired
	private ProductService productService;
	
	@CrossOrigin
	@RequestMapping(value = "/products", method = RequestMethod.GET)
	public ResponseEntity<?> getProducts() {
		List<Product> products = productService.getProducts();
		if (products.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
		
        return new ResponseEntity<List<Product>>(products, HttpStatus.OK);
		
		
	}
    

}
