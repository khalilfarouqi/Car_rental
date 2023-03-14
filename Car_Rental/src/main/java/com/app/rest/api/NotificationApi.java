package com.app.rest.api;

import com.app.dto.NotificationDto;
import com.app.entity.Notification;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;

@CrossOrigin
@Tag(name = "Notification", description = "REST API for Notification information")
@RequestMapping("/v1/notification")
public interface NotificationApi extends BaseApi<Notification, NotificationDto> {

}
