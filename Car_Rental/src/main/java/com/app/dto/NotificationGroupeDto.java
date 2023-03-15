package com.app.dto;

import com.app.entity.enums.NotificationType;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

import java.io.Serializable;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class NotificationGroupeDto implements Serializable {
    private Long id;
    private String object;
    private String body;
    private NotificationType notificationType;
    private Boolean notificationWeb;
    private Date dateEnvoi;
}
