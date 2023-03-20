package com.app.sevice.impl;

import com.app.dto.NotificationGroupeDto;
import com.app.entity.NotificationGroup;
import com.app.mapper.NotificationGroupMapper;
import com.app.repository.NotificationGroupRepo;
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
public class NotificationGroupService extends BaseService<NotificationGroup, NotificationGroupeDto> {
    private final NotificationGroupRepo notificationGroupRepository;
    private final NotificationGroupMapper notificationGroupMapper = Mappers.getMapper(NotificationGroupMapper.class);

    public List<NotificationGroupeDto> getAllNotificationGroup(){
        return notificationGroupMapper.toDto(notificationGroupRepository.findAll());
    }

    public NotificationGroupeDto getNotificationGroupById(Long id){
        return notificationGroupMapper.toDto(notificationGroupRepository.findById(id));
    }

}
