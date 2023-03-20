package com.app.mapper;

import com.app.dto.NotificationGroupeDto;
import com.app.entity.NotificationGroup;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface NotificationGroupMapper extends GenericModelMapper<NotificationGroup, NotificationGroupeDto>{
}
