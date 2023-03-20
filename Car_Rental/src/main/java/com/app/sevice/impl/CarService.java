package com.app.sevice.impl;

import com.app.dto.CarDto;
import com.app.mapper.CarMapper;
import com.app.repository.CarRepo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Service;

import com.app.entity.Car;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Slf4j
@Transactional(readOnly = true)
@RequiredArgsConstructor
@Service
public class CarService extends BaseService<Car, CarDto>{
    private final CarRepo carRepository;
    private final CarMapper carMapper = Mappers.getMapper(CarMapper.class);

    public List<CarDto> getAllCar(){
        return carMapper.toDto(carRepository.findAll());
    }

    public CarDto getCarById(Long id){
        return carMapper.toDto(carRepository.findById(id));
    }

}
