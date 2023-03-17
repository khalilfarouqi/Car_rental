package com.app.rest.controller;

import com.app.dto.NotificationDto;
import com.app.rest.api.NotificationApi;
import com.app.sevice.impl.ServiceNotificationImpl;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@RestController
public class NotificationController implements NotificationApi {

    private final ServiceNotificationImpl serviceNotification;

    @Override
    public List<NotificationDto> getAllNotification() {
        return serviceNotification.getAllNotification();
    }

    @Override
    public NotificationDto getNotificationById(Long id) {
        return serviceNotification.getNotificationById(id);
    }

    @Override
    public void saveNotification(NotificationDto notificationDto) {
        serviceNotification.saveNotification(notificationDto);
    }

    @Override
    public void updateNotification(NotificationDto notificationDto) {
        serviceNotification.updateNotification(notificationDto);
    }

    @Override
    public void deleteNotification(Long id) {
        serviceNotification.deleteNotification(id);
    }
}
