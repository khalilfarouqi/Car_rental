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
		
		existingOrder.setBooking_City(existingOrder.getBooking_City());
		existingOrder.setCar(existingOrder.getCar());
		existingOrder.setClient_Age(existingOrder.getClient_Age());
		existingOrder.setContry(existingOrder.getContry());
		existingOrder.setEnd_Date(existingOrder.getEnd_Date());
		existingOrder.setOrder_Status(existingOrder.getOrder_Status());
		existingOrder.setReturn_City(existingOrder.getReturn_City());
		existingOrder.setStart_Date(existingOrder.getStart_Date());
		existingOrder.setType_Insurance(existingOrder.getType_Insurance());
		existingOrder.setUser(existingOrder.getUser());
		
		orderRepo.save(existingOrder);
		
		return existingOrder;
	}

	@Override
	public void deleteById(Long id) {
		this.orderRepo.deleteById(id);
	}

}
