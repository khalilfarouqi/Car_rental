package com.app.sevice.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.entity.Order;
import com.app.repository.OrderRepo;
import com.app.sevice.IService;

@Service
public class ServiceOrderImpl implements IService<Order> {
	
	@Autowired
	private OrderRepo orderRepo;
	
	@Override
	public List<Order> getAll() {
		return orderRepo.findAll();
	}

	@Override
	public Order save(Order order) {
		return orderRepo.save(order);
	}

	@Override
	public Order getById(Long id) {
		return orderRepo.findById(id).get();
	}

	@Override
	public Order update(Order order, Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteById(Long id) {
		this.orderRepo.deleteById(id);
	}

}
