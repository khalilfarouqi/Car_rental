package com.app.rest.controller;

import com.app.dto.CarDto;
import com.app.entity.Car;
import com.app.rest.api.CarApi;
import com.app.sevice.IBaseService;
import com.app.sevice.impl.ServiceCarImpl;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RequiredArgsConstructor
@RestController
public class CarController extends BaseController<Car, CarDto> implements CarApi {

    private final ServiceCarImpl serviceCar;
    @Override
    public IBaseService<Car, CarDto> getService() {
        return serviceCar;
    }
}
