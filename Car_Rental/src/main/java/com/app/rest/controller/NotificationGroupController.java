package com.app.rest.controller;

import com.app.dto.NotificationGroupeDto;
import com.app.entity.NotificationGroup;
import com.app.rest.api.NotificationGroupApi;
import com.app.sevice.IBaseService;
import com.app.sevice.impl.NotificationGroupService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class NotificationGroupController extends BaseController<NotificationGroup, NotificationGroupeDto> implements NotificationGroupApi {
    private final NotificationGroupService notificationGroupService;

    @Override
    public NotificationGroupeDto getById(@PathVariable("id") Long id) {
        return notificationGroupService.getNotificationGroupById(id);
    }

    @Override
    public Page<NotificationGroupeDto> search(String query, Integer page, Integer size, String order, String sort) {
        return notificationGroupService.rsqlQuery(query, page, size, order, sort);
    }

    @Override
    public List<NotificationGroupeDto> getAll() {
        return notificationGroupService.getAllNotificationGroup();
    }

    @Override
    public IBaseService<NotificationGroup, NotificationGroupeDto> getService() {
        return notificationGroupService;
    }
}
