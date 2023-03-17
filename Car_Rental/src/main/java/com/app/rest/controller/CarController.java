package com.app.rest.controller;

import com.app.dto.CarDto;
import com.app.entity.Car;
import com.app.rest.api.CarApi;
import com.app.sevice.impl.ServiceCarImpl;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@RequiredArgsConstructor
@RestController
public class CarController implements CarApi {

    private final ServiceCarImpl caeService;

    public List<CarDto> getAllCar(){
        return caeService.getAllCar();
    }

    public CarDto getCarById(Long id){
        return caeService.getCarById(id);
    }

    public void saveCar(CarDto carDto){
        caeService.saveCar(carDto);
    }

    public void updateCar(CarDto carDto){
        caeService.updateCar(carDto);
    }

    public void deleteCar(Long id){
        caeService.deleteCar(id);
    }

}
