package com.app.sevice.impl;

import com.app.dto.NotificationGroupeDto;
import com.app.entity.NotificationGroupe;
import com.app.sevice.BaseServiceImpl;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Transactional(readOnly = true)
@RequiredArgsConstructor
@Service
public class ServiceNotificationGroupeImpl extends BaseServiceImpl<NotificationGroupe, NotificationGroupeDto> {

    @Override
    public Page<NotificationGroupeDto> rsqlQuery(String query, Integer page, Integer size, String order, String sort) {
        return null;
    }
}
