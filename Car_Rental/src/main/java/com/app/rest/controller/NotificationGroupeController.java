package com.app.rest.controller;

import com.app.dto.NotificationGroupeDto;
import com.app.entity.NotificationGroupe;
import com.app.rest.api.NotificationApi;
import com.app.rest.api.NotificationGroupeApi;
import com.app.sevice.IBaseService;
import com.app.sevice.impl.ServiceNotificationGroupeImpl;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RequiredArgsConstructor
@RestController
public class NotificationGroupeController extends BaseController<NotificationGroupe, NotificationGroupeDto> implements NotificationGroupeApi {

    private final ServiceNotificationGroupeImpl serviceNotificationGroupe;
    @Override
    public IBaseService<NotificationGroupe, NotificationGroupeDto> getService() {
        return serviceNotificationGroupe;
    }
}
