package com.app.rest.api;

import com.app.dto.NotificationGroupeDto;
import com.app.entity.NotificationGroupe;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;

@CrossOrigin
@Tag(name = "NotificationGroupe", description = "REST API for NotificationGroupe information")
@RequestMapping("/v1/notificationGroupe")
public interface NotificationGroupeApi extends BaseApi<NotificationGroupe, NotificationGroupeDto> {

}
