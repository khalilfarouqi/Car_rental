package com.app.rest.api;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.io.Serializable;

@CrossOrigin(origins = "*")
public interface BaseApi<E, D extends Serializable> {
    @Operation(
            summary = "Entity Get API",
            description = "Entity Get API")
    @ApiResponse(
            responseCode = "200",
            description = "200 IS OK")
    @GetMapping("/{id}")
    D getById(@PathVariable("id") Long id);

    @GetMapping("/search")
    Page<D> search(@RequestParam(defaultValue = "id>0") String query,
                   @RequestParam(defaultValue = "0") Integer page,
                   @RequestParam(defaultValue = "10") Integer size,
                   @RequestParam(defaultValue = "asc") String order,
                   @RequestParam(defaultValue = "id") String sort
    );
}
