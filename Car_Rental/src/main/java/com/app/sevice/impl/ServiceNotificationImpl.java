package com.app.sevice.impl;

import com.app.dto.NotificationDto;
import com.app.entity.Notification;
import com.app.repository.NotificationRepo;
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
public class ServiceNotificationImpl {
    @Autowired
    private NotificationRepo notificationRepository;
    @Autowired
    private ModelMapper modelMapper;

    public List<NotificationDto> getAllNotification(){
        return notificationRepository.findAll()
                .stream()
                .map(this::convertEntityToDto)
                .collect(Collectors.toList());
    }
    private NotificationDto convertEntityToDto(Notification notification){
        modelMapper.getConfiguration()
                .setMatchingStrategy(MatchingStrategies.LOOSE);
        return modelMapper.map(notification, NotificationDto.class);
    }

    private Notification convertDtoToEntity(NotificationDto notificationDto){
        modelMapper.getConfiguration()
                .setMatchingStrategy(MatchingStrategies.LOOSE);
        return modelMapper.map(notificationDto, Notification.class);
    }
}
