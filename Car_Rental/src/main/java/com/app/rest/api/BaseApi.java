package com.app.rest.api;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.io.Serializable;
import java.util.List;

@CrossOrigin(origins = "*")
public interface BaseApi<E, D extends Serializable> {
    @Operation(
            summary = "Entity Get API",
            description = "Entity Get API")
    @ApiResponse(
            responseCode = "200",
            description = "200 IS OK")

    @GetMapping(value = "/{id}")
    D getById(@PathVariable Long id);

    @GetMapping("/search")
    Page<D> search(@RequestParam(defaultValue = "id>0") String query,
                   @RequestParam(defaultValue = "0") Integer page,
                   @RequestParam(defaultValue = "10") Integer size,
                   @RequestParam(defaultValue = "asc") String order,
                   @RequestParam(defaultValue = "id") String sort
    );
    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    D save(@RequestBody D d);

    @PutMapping
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    D update(@RequestBody D d);

    @DeleteMapping("/{id}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    void delete(@PathVariable Long id);

    @GetMapping
    List<D> getAll();
}
