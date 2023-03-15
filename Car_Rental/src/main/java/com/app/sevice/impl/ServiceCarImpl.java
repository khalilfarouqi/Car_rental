package com.app.sevice.impl;

import com.app.dto.CarDto;
import com.app.repository.CarRepo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.entity.Car;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Transactional(readOnly = true)
@RequiredArgsConstructor
@Service
public class ServiceCarImpl {
    @Autowired
    private CarRepo carRepository;
    @Autowired
    private ModelMapper modelMapper;

    public List<CarDto> getAllCar(){
        return carRepository.findAll()
                .stream()
                .map(this::convertEntityToDto)
                .collect(Collectors.toList());
    }
    private CarDto convertEntityToDto(Car car){
        modelMapper.getConfiguration()
                .setMatchingStrategy(MatchingStrategies.LOOSE);
        return modelMapper.map(car, CarDto.class);
    }

    private Car convertDtoToEntity(CarDto carDto){
        modelMapper.getConfiguration()
                .setMatchingStrategy(MatchingStrategies.LOOSE);
        return modelMapper.map(carDto, Car.class);
    }
}
