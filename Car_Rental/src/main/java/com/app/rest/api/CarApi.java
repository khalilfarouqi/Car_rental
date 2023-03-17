package com.app.rest.api;

import com.app.dto.CarDto;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@Tag(name = "Car", description = "REST API for Car information")
@RequestMapping("/v1/car")
public interface CarApi {
    @GetMapping
    List<CarDto> getAllCar();

    @GetMapping(value = "/{id}")
    CarDto getCarById(@PathVariable Long id);

    @PostMapping
    void saveCar(@RequestBody CarDto carDto);

    @PutMapping(value = "/updateCar")
    void updateCar(@RequestBody CarDto carDto);

    @DeleteMapping(value = "/{id}")
    void deleteCar(@PathVariable Long id);
}
