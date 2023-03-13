package com.app.mapper;

import com.app.dto.NotificationGroupeDto;
import com.app.entity.NotificationGroupe;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface NotificationGroupeMapper extends GenericModelMapper<NotificationGroupe, NotificationGroupeDto> {
}
