package com.app.sevice.impl;

import com.app.dto.ClientDto;
import com.app.entity.Client;
import com.app.mapper.ClientMapper;
import com.app.repository.ClientRepo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Service;

import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Slf4j
@Transactional(readOnly = true)
@RequiredArgsConstructor
@Service
public class ClientService extends BaseService<Client, ClientDto> {
    private final ClientRepo clientRepository;
    private final ClientMapper clientMapper = Mappers.getMapper(ClientMapper.class);

    public List<ClientDto> getAllClient(){
        return clientMapper.toDto(clientRepository.findAll());
    }

    public ClientDto getClientById(Long id){
        return clientMapper.toDto(clientRepository.findById(id));
    }

}
