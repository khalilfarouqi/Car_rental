package com.app.sevice.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.entity.User;
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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteById(Long id) {
		this.userRepo.deleteById(id);
	}

}
