package com.app.sevice.impl;

import com.app.dto.ClientDto;
import com.app.entity.Client;
import com.app.repository.ClientRepo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Transactional(readOnly = true)
@RequiredArgsConstructor
@Service
public class ClientService extends BaseService<Client, ClientDto> {
    @Autowired
    private final ClientRepo clientRepository;
    @Autowired
    private final ModelMapper modelMapper;

    public List<ClientDto> getAllClient(){
        List<ClientDto> clientDtoList = new ArrayList<>();
        clientRepository.findAll().forEach(element -> clientDtoList.add(modelMapper.map(element, ClientDto.class)));
        return clientDtoList;
    }

    public ClientDto getClientById(Long id){
        return modelMapper.map(clientRepository.findById(id), ClientDto.class);
    }

}
