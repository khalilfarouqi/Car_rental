package com.app.mapper;

import com.app.dto.PhotoDto;
import com.app.entity.Photo;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PhotoMapper extends GenericModelMapper<Photo, PhotoDto> {
}
