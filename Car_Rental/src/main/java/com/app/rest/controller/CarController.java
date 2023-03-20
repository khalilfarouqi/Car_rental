package com.app.rest.controller;

import com.app.dto.CarDto;
import com.app.entity.Car;
import com.app.rest.api.CarApi;
import com.app.sevice.IBaseService;
import com.app.sevice.impl.CarService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@RestController
public class CarController extends BaseController<Car, CarDto> implements CarApi {

    private final CarService carService;

    @Override
    public CarDto getById(@PathVariable("id") Long id) {
        return carService.getCarById(id);
    }

    @Override
    public Page<CarDto> search(String query, Integer page, Integer size, String order, String sort) {
        return carService.rsqlQuery(query, page, size, order, sort);
    }

    @Override
    public List<CarDto> getAll() {
        return carService.getAllCar();
    }

    @Override
    public IBaseService<Car, CarDto> getService() {
        return carService;
    }
}
