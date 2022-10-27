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
		
		existingUser.setLast_CheckIn(existingUser.getLast_CheckIn());
		existingUser.setOrders(existingUser.getOrders());
		existingUser.setPassWord(existingUser.getPassWord());
		existingUser.setRole(existingUser.getRole());
		existingUser.setUserName(existingUser.getUserName());
		
		userRepo.save(existingUser);
		
		return existingUser;
	}

	@Override
	public void deleteById(Long id) {
		this.userRepo.deleteById(id);
	}

}
