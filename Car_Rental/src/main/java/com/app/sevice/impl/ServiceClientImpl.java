package com.app.sevice.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.entity.Client;
import com.app.repository.ClientRepo;
import com.app.sevice.IService;

@Service
public class ServiceClientImpl implements IService<Client> {

	private static final long serialVersionUID = 1L;
	
	@Autowired
	private ClientRepo clientRepo;
	
	@Override
	public List<Client> getAll() {
		return clientRepo.findAll();
	}

	@Override
	public Client save(Client client) {
		return clientRepo.save(client);
	}

	@Override
	public Client getById(Long id) {
		return clientRepo.findById(id).get();
	}

	@Override
	public Client update(Client client, Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteById(Long id) {
		this.clientRepo.deleteById(id);
	}

}
