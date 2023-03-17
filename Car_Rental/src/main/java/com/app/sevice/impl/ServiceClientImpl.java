package com.app.sevice.impl;

import com.app.dto.ClientDto;
import com.app.entity.Client;
import com.app.repository.ClientRepo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Transactional(readOnly = true)
@RequiredArgsConstructor
@Service
public class ServiceClientImpl {
    private final ClientRepo clientRepository;
    private final ModelMapper modelMapper;

    public List<ClientDto> getAllClient(){
        List<ClientDto> clientDtoList = new ArrayList<>();
        clientRepository.findAll().forEach(element -> clientDtoList.add(modelMapper.map(element, ClientDto.class)));
        return clientDtoList;
    }

    public ClientDto getClientById(Long id){
        return modelMapper.map(clientRepository.findById(id), ClientDto.class);
    }

    public void saveClient(ClientDto clientDto){
        clientRepository.save(modelMapper.map(clientDto, Client.class));
    }

    public void updateClient(ClientDto clientDto){
        clientRepository.save(modelMapper.map(clientDto, Client.class));
    }

    public void deleteClient(Long id){
        clientRepository.deleteById(id);
    }
}
