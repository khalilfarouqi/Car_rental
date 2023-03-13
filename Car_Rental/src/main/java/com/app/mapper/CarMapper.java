package com.app.mapper;

import com.app.dto.CarDto;
import com.app.entity.Car;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CarMapper extends GenericModelMapper<Car, CarDto> {
}
