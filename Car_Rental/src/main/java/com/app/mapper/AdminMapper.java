package com.app.mapper;

import com.app.dto.AdminDto;
import com.app.entity.Admin;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AdminMapper extends GenericModelMapper<Admin, AdminDto> {
}
