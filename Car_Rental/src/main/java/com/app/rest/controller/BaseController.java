package com.app.rest.controller;

import com.app.sevice.IBaseService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.io.Serializable;

@Slf4j
@RequiredArgsConstructor
@RestController
public abstract class BaseController<E, D extends Serializable> {
    public abstract IBaseService<E, D> getService();
    @GetMapping("/{id}")
    public D findById(@PathVariable("id") Long id) {
        return this.getService().findById(id);
    }

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public D save(@RequestBody D dto){
        return getService().save(dto);
    }

    @PutMapping(value = "/updateCar")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public D update(@RequestBody D dto){
        return getService().update(dto);
    }

    @DeleteMapping(value = "/{id}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public void delete(@PathVariable("id") Long id){
        this.getService().delete(id);
    }
}
