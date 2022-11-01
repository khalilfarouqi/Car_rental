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
		
		existingClient.setAdress(client.getAdress());
		existingClient.setAge(client.getAge());
		existingClient.setCantry(client.getCantry());
		existingClient.setCIN(client.getCIN());
		existingClient.setCity(client.getCity());
		existingClient.setDate_Creation(client.getDate_Creation());
		existingClient.setDate_Licence(client.getDate_Licence());
		existingClient.setEmail(client.getEmail());
		existingClient.setFirst_Name(client.getFirst_Name());
		existingClient.setGender(client.getGender());
		existingClient.setLast_CheckIn(client.getLast_CheckIn());
		existingClient.setLast_Name(client.getLast_Name());
		existingClient.setLicence(client.getLicence());
		existingClient.setPassWord(client.getPassWord());
		existingClient.setTel(client.getTel());
		existingClient.setUserName(client.getUserName());
		existingClient.setVol_Numbre(client.getVol_Numbre());
		
		clientRepo.save(existingClient);

		return existingClient;
	}

	@Override
	public void deleteById(Long id) {
		this.clientRepo.deleteById(id);
	}

}
