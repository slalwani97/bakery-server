package com.yummy.bakery.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.yummy.bakery.model.entity.Product;
import com.yummy.bakery.repository.ProductRepository;
import com.yummy.bakery.service.ProductService;

@Service
@Transactional
public class ProductServiceImpl implements ProductService {
	
	@Autowired
	private ProductRepository productRepo;
	
	public List<Product> getProducts() {
		return productRepo.findAll();
		
	}
	
	public Product getProductById(long id) {
		return productRepo.getOne(id);
	}

}
