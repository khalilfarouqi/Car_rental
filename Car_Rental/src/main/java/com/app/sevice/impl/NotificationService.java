package com.app.sevice.impl;

import com.app.dto.NotificationDto;
import com.app.entity.Notification;
import com.app.mapper.NotificationMapper;
import com.app.repository.NotificationRepo;
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
public class NotificationService extends BaseService<Notification, NotificationDto> {
    private final NotificationRepo notificationRepository;
    private final NotificationMapper notificationMapper = Mappers.getMapper(NotificationMapper.class);

    public List<NotificationDto> getAllNotification(){
        return notificationMapper.toDto(notificationRepository.findAll());
    }

    public NotificationDto getNotificationById(Long id){
        return notificationMapper.toDto(notificationRepository.findById(id));
    }

}
