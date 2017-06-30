package com.yummy.bakery.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.yummy.bakery.model.entity.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

}
