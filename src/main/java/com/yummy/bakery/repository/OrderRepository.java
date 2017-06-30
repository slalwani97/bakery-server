package com.yummy.bakery.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.yummy.bakery.model.entity.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {

}
