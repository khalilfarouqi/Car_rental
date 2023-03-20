package com.app.sevice.impl;

import com.app.dto.NotificationDto;
import com.app.entity.Notification;
import com.app.repository.NotificationRepo;
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
public class NotificationService extends BaseService<Notification, NotificationDto> {
    @Autowired
    private final NotificationRepo notificationRepository;
    @Autowired
    private final ModelMapper modelMapper;

    public List<NotificationDto> getAllNotification(){
        List<NotificationDto> notificationDtoList = new ArrayList<>();
        notificationRepository.findAll().forEach(element -> notificationDtoList.add(modelMapper.map(element, NotificationDto.class)));
        return notificationDtoList;
    }

    public NotificationDto getNotificationById(Long id){
        return modelMapper.map(notificationRepository.findById(id), NotificationDto.class);
    }

}
