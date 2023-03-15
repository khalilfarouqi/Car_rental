package com.app.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class NotificationDto implements Serializable {
    private Long id;
    private String object;
    private String body;
    private Boolean isRead;
    private Boolean notificationWeb;
    private UserDto userDto;
    private NotificationGroupeDto notificationGroupeDto;
}
