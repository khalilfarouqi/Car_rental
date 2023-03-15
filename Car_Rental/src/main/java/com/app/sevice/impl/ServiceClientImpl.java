package com.app.sevice.impl;

import com.app.dto.ClientDto;
import com.app.repository.ClientRepo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.entity.Client;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Transactional(readOnly = true)
@RequiredArgsConstructor
@Service
public class ServiceClientImpl {
    @Autowired
    private ClientRepo clientRepository;
    @Autowired
    private ModelMapper modelMapper;

    public List<ClientDto> getAllClient(){
        return clientRepository.findAll()
                .stream()
                .map(this::convertEntityToDto)
                .collect(Collectors.toList());
    }
    private ClientDto convertEntityToDto(Client client){
        modelMapper.getConfiguration()
                .setMatchingStrategy(MatchingStrategies.LOOSE);
        return modelMapper.map(client, ClientDto.class);
    }

    private Client convertDtoToEntity(ClientDto clientDto){
        modelMapper.getConfiguration()
                .setMatchingStrategy(MatchingStrategies.LOOSE);
        return modelMapper.map(clientDto, Client.class);
    }
}
