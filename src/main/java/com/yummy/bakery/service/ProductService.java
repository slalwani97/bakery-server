package com.yummy.bakery.service;

import java.util.List;

import com.yummy.bakery.model.entity.Product;

public interface ProductService {
	
	public List<Product> getProducts();
	
	public Product getProductById(long id);

}
