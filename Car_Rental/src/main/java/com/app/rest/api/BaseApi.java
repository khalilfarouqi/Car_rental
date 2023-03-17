package com.app.rest.api;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
public interface BaseApi<T> {
    @Operation(
            summary = "Entity Get API",
            description = "Entity Get API")
    @ApiResponse(
            responseCode = "200",
            description = "200 IS OK")

    @GetMapping("/search")
    Page<T> search(@RequestParam(defaultValue = "id>0") String query,
                   @RequestParam(defaultValue = "0") Integer page,
                   @RequestParam(defaultValue = "10") Integer size,
                   @RequestParam(defaultValue = "asc") String order,
                   @RequestParam(defaultValue = "id") String sort
    );
    @GetMapping
    List<T> getAll();

    @GetMapping(value = "/{id}")
    T getById(@PathVariable Long id);

    @PostMapping
    void save(@RequestBody T t);

    @PutMapping(value = "/updateCar")
    void update(@RequestBody T t);

    @DeleteMapping(value = "/{id}")
    void delete(@PathVariable Long id);
}
