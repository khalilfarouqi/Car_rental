package com.app.mapper;

import com.app.dto.UserDto;
import com.app.entity.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper extends GenericModelMapper<User, UserDto>{
}
