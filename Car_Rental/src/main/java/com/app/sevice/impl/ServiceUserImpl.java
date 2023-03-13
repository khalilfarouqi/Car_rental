package com.app.sevice.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.entity.User;
import com.app.exception.ResourceNotFoundException;
import com.app.repository.UserRepo;
import com.app.sevice.IService;

@Service
public class ServiceUserImpl implements IService<User> {
	
	@Autowired
	private UserRepo userRepo;
	
	@Override
	public List<User> getAll() {
		return userRepo.findAll();
	}

	@Override
	public User save(User user) {
		return userRepo.save(user);
	}

	@Override
	public User getById(Long id) {
		return userRepo.findById(id).get();
	}

	@Override
	public User update(User user, Long id) {
		User existingUser = userRepo.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("userRepository", "Id", id));
		
		if (user.getLast_CheckIn() != null) existingUser.setLast_CheckIn(user.getLast_CheckIn());
		if (user.getOrders() != null) existingUser.setOrders(user.getOrders());
		if (user.getPassWord() != null) existingUser.setPassWord(user.getPassWord());
		if (user.getRoles() != null) existingUser.setRoles(user.getRoles());
		if (user.getUserName() != null) existingUser.setUserName(user.getUserName());
		
		userRepo.save(existingUser);
		
		return existingUser;
	}

	@Override
	public void deleteById(Long id) {
		this.userRepo.deleteById(id);
	}

}
