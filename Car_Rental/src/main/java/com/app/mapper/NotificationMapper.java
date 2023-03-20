package com.app.mapper;

import com.app.dto.NotificationDto;
import com.app.entity.Notification;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface NotificationMapper extends GenericModelMapper<Notification, NotificationDto>{
}
