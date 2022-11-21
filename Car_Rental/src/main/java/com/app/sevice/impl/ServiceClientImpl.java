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
		
		if (client.getAdress() != null) existingClient.setAdress(client.getAdress());
		if (client.getAge() != 0) existingClient.setAge(client.getAge());
		if (client.getCantry() != null) existingClient.setCantry(client.getCantry());
		if (client.getCIN() != null) existingClient.setCIN(client.getCIN());
		if (client.getCity() != null) existingClient.setCity(client.getCity());
		if (client.getDate_Creation() != null) existingClient.setDate_Creation(client.getDate_Creation());
		if (client.getDate_Licence() != null) existingClient.setDate_Licence(client.getDate_Licence());
		if (client.getEmail() != null) existingClient.setEmail(client.getEmail());
		if (client.getFirst_Name() != null) existingClient.setFirst_Name(client.getFirst_Name());
		if (client.getGender() != null) existingClient.setGender(client.getGender());
		if (client.getLast_CheckIn() != null) existingClient.setLast_CheckIn(client.getLast_CheckIn());
		if (client.getLast_Name() != null) existingClient.setLast_Name(client.getLast_Name());
		if (client.getLicence() != null) existingClient.setLicence(client.getLicence());
		if (client.getPassWord() != null) existingClient.setPassWord(client.getPassWord());
		if (client.getTel() != null) existingClient.setTel(client.getTel());
		if (client.getUserName() != null) existingClient.setUserName(client.getUserName());
		if (client.getVol_Numbre() != 0) existingClient.setVol_Numbre(client.getVol_Numbre());
		
		clientRepo.save(existingClient);

		return existingClient;
	}

	@Override
	public void deleteById(Long id) {
		this.clientRepo.deleteById(id);
	}

}
