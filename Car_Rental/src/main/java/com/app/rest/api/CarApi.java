package com.app.rest.api;

import com.app.dto.CarDto;
import com.app.entity.Car;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@Tag(name = "Car", description = "REST API for Car information")
@RequestMapping("/v1/car")
public interface CarApi extends BaseApi<Car, CarDto> {

}
