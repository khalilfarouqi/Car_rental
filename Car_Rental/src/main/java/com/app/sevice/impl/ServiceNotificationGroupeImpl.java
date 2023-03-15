package com.app.sevice.impl;

import com.app.dto.NotificationGroupeDto;
import com.app.entity.NotificationGroupe;
import com.app.repository.NotificationGroupeRepo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Transactional(readOnly = true)
@RequiredArgsConstructor
@Service
public class ServiceNotificationGroupeImpl {
    @Autowired
    private NotificationGroupeRepo notificationGroupeRepository;
    @Autowired
    private ModelMapper modelMapper;

    public List<NotificationGroupeDto> getAllNotificationGroupe(){
        return notificationGroupeRepository.findAll()
                .stream()
                .map(this::convertEntityToDto)
                .collect(Collectors.toList());
    }
    private NotificationGroupeDto convertEntityToDto(NotificationGroupe notificationGroupe){
        modelMapper.getConfiguration()
                .setMatchingStrategy(MatchingStrategies.LOOSE);
        return modelMapper.map(notificationGroupe, NotificationGroupeDto.class);
    }

    private NotificationGroupe convertDtoToEntity(NotificationGroupeDto notificationGroupeDto){
        modelMapper.getConfiguration()
                .setMatchingStrategy(MatchingStrategies.LOOSE);
        return modelMapper.map(notificationGroupeDto, NotificationGroupe.class);
    }
}
