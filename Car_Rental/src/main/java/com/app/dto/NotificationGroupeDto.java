package com.app.dto;

import com.app.entity.enem.NotificationType;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

import java.util.Date;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class NotificationGroupeDto {
    private Long ID;
    private String object;
    private String body;
    private NotificationType notificationType;
    private Boolean notificationWeb;
    private Date dateEnvoi;
}
