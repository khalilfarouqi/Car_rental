package com.app.rest.controller;

import com.app.dto.NotificationDto;
import com.app.entity.Notification;
import com.app.rest.api.NotificationApi;
import com.app.sevice.IBaseService;
import com.app.sevice.impl.NotificationService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class NotificationController extends BaseController<Notification, NotificationDto> implements NotificationApi {

    private final NotificationService notificationService;

    @Override
    public NotificationDto getById(@PathVariable("id") Long id) {
        return notificationService.getNotificationById(id);
    }

    @Override
    public Page<NotificationDto> search(String query, Integer page, Integer size, String order, String sort) {
        return notificationService.rsqlQuery(query, page, size, order, sort);
    }

    @Override
    public List<NotificationDto> getAll() {
        return notificationService.getAllNotification();
    }

    @Override
    public IBaseService<Notification, NotificationDto> getService() {
        return notificationService;
    }
}
