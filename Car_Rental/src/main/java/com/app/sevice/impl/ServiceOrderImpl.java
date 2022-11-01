package com.app.sevice.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.entity.Order;
import com.app.exception.ResourceNotFoundException;
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
		Order existingOrder = orderRepo.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("orderRepository", "Id", id));
		
		existingOrder.setBooking_City(order.getBooking_City());
		existingOrder.setCar(order.getCar());
		existingOrder.setClient_Age(order.getClient_Age());
		existingOrder.setContry(order.getContry());
		existingOrder.setEnd_Date(order.getEnd_Date());
		existingOrder.setOrder_Status(order.getOrder_Status());
		existingOrder.setReturn_City(order.getReturn_City());
		existingOrder.setStart_Date(order.getStart_Date());
		existingOrder.setType_Insurance(order.getType_Insurance());
		existingOrder.setUser(order.getUser());
		
		orderRepo.save(existingOrder);
		
		return existingOrder;
	}

	@Override
	public void deleteById(Long id) {
		this.orderRepo.deleteById(id);
	}

}
