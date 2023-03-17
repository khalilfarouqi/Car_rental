package com.app.sevice.impl;

import com.app.dto.NotificationDto;
import com.app.entity.Notification;
import com.app.repository.NotificationRepo;
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
public class ServiceNotificationImpl {
    private final NotificationRepo notificationRepository;
    private final ModelMapper modelMapper;

    public List<NotificationDto> getAllNotification(){
        List<NotificationDto> notificationDtoList = new ArrayList<>();
        notificationRepository.findAll().forEach(element -> notificationDtoList.add(modelMapper.map(element, NotificationDto.class)));
        return notificationDtoList;
    }

    public NotificationDto getNotificationById(Long id){
        return modelMapper.map(notificationRepository.findById(id), NotificationDto.class);
    }

    public void saveNotification(NotificationDto notificationDto){
        notificationRepository.save(modelMapper.map(notificationDto, Notification.class));
    }

    public void updateNotification(NotificationDto notificationDto){
        notificationRepository.save(modelMapper.map(notificationDto, Notification.class));
    }

    public void deleteNotification(Long id){
        notificationRepository.deleteById(id);
    }
}
