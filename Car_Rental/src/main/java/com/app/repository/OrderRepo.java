package com.app.repository;

import org.springframework.stereotype.Repository;

import com.app.entity.Order;

@Repository
public interface OrderRepo extends BaseJpaRepository<Order> {

}
