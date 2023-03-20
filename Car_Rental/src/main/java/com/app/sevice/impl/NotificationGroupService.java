package com.app.sevice.impl;

import com.app.dto.NotificationGroupeDto;
import com.app.entity.NotificationGroup;
import com.app.repository.NotificationGroupRepo;
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
public class NotificationGroupService extends BaseService<NotificationGroup, NotificationGroupeDto> {
    @Autowired
    private final NotificationGroupRepo notificationGroupRepository;
    @Autowired
    private final ModelMapper modelMapper;

    public List<NotificationGroupeDto> getAllNotificationGroup(){
        List<NotificationGroupeDto> notificationGroupDtoList = new ArrayList<>();
        notificationGroupRepository.findAll().forEach(element -> notificationGroupDtoList.add(modelMapper.map(element, NotificationGroupeDto.class)));
        return notificationGroupDtoList;
    }

    public NotificationGroupeDto getNotificationGroupById(Long id){
        return modelMapper.map(notificationGroupRepository.findById(id), NotificationGroupeDto.class);
    }

}
