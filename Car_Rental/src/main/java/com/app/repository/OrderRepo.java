package com.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.entity.Order;

@Repository
public interface OrderRepo extends JpaRepository<Order, Long> {

}
