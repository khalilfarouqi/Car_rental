package com.app.sevice.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.entity.Client;
import com.app.exception.ResourceNotFoundException;
import com.app.repository.ClientRepo;
import com.app.sevice.IService;

@Service
public class ServiceClientImpl implements IService<Client> {
	
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
		Client existingClient = clientRepo.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("clientRepository", "Id", id));
		
		existingClient.setAdress(existingClient.getAdress());
		existingClient.setAge(existingClient.getAge());
		existingClient.setCantry(existingClient.getCantry());
		existingClient.setCIN(existingClient.getCIN());
		existingClient.setCity(existingClient.getCity());
		existingClient.setDate_Creation(existingClient.getDate_Creation());
		existingClient.setDate_Licence(existingClient.getDate_Licence());
		existingClient.setEmail(existingClient.getEmail());
		existingClient.setFirst_Name(existingClient.getFirst_Name());
		existingClient.setGender(existingClient.getGender());
		existingClient.setLast_CheckIn(existingClient.getLast_CheckIn());
		existingClient.setLast_Name(existingClient.getLast_Name());
		existingClient.setLicence(existingClient.getLicence());
		existingClient.setPassWord(existingClient.getPassWord());
		existingClient.setTel(existingClient.getTel());
		existingClient.setUserName(existingClient.getUserName());
		existingClient.setVol_Numbre(existingClient.getVol_Numbre());
		
		clientRepo.save(existingClient);

		return existingClient;
	}

	@Override
	public void deleteById(Long id) {
		this.clientRepo.deleteById(id);
	}

}
