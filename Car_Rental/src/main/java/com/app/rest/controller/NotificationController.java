package com.app.rest.controller;

import com.app.dto.NotificationDto;
import com.app.entity.Notification;
import com.app.rest.api.NotificationApi;
import com.app.sevice.IBaseService;
import com.app.sevice.impl.ServiceNotificationImpl;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RequiredArgsConstructor
@RestController
public class NotificationController extends BaseController<Notification, NotificationDto> implements NotificationApi {

    private final ServiceNotificationImpl serviceNotification;

    @Override
    public IBaseService<Notification, NotificationDto> getService() {
        return serviceNotification;
    }
}
