package com.app.rest.api;

import com.app.dto.NotificationDto;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@Tag(name = "Notification", description = "REST API for Notification information")
@RequestMapping("/v1/notification")
public interface NotificationApi {
    @GetMapping
    List<NotificationDto> getAllNotification();

    @GetMapping(value = "/{id}")
    NotificationDto getNotificationById(@PathVariable Long id);

    @PostMapping
    void saveNotification(@RequestBody NotificationDto notificationDto);

    @PutMapping(value = "/updateNotification")
    void updateNotification(@RequestBody NotificationDto notificationDto);

    @DeleteMapping(value = "/{id}")
    void deleteNotification(@PathVariable Long id);
}
