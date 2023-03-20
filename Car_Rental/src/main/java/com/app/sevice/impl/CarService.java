package com.app.sevice.impl;

import com.app.dto.CarDto;
import com.app.repository.CarRepo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.entity.Car;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Transactional(readOnly = true)
@RequiredArgsConstructor
@Service
public class CarService extends BaseService<Car, CarDto>{
    @Autowired
    private final CarRepo carRepository;
    @Autowired
    private final ModelMapper modelMapper;

    public List<CarDto> getAllCar(){
        List<CarDto> carDtoList = new ArrayList<>();
        carRepository.findAll().forEach(element -> carDtoList.add(modelMapper.map(element, CarDto.class)));
        return carDtoList;
    }

    public CarDto getCarById(Long id){
        return modelMapper.map(carRepository.findById(id), CarDto.class);
    }

}
