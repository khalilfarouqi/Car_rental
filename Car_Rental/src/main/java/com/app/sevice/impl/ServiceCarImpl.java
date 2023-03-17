package com.app.sevice.impl;

import com.app.dto.CarDto;
import com.app.repository.CarRepo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.app.entity.Car;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Transactional(readOnly = true)
@RequiredArgsConstructor
@Service
public class ServiceCarImpl {
    private final CarRepo carRepository;
    private final ModelMapper modelMapper;

    public List<CarDto> getAllCar(){
        List<CarDto> carDtoList = new ArrayList<>();
        carRepository.findAll().forEach(element -> carDtoList.add(modelMapper.map(element, CarDto.class)));
        return carDtoList;
    }

    public CarDto getCarById(Long id){
        return modelMapper.map(carRepository.findById(id), CarDto.class);
    }

    public void saveCar(CarDto carDto){
        carRepository.save(modelMapper.map(carDto, Car.class));
    }

    public void updateCar(CarDto carDto){
        carRepository.save(modelMapper.map(carDto, Car.class));
    }

    public void deleteCar(Long id){
        carRepository.deleteById(id);
    }

}
