package com.app.rest.controller;

import com.app.sevice.IBaseService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.io.Serializable;

@Slf4j
public abstract class BaseController<E, D extends Serializable> {
    public abstract IBaseService<E, D> getService();
    @PostMapping()
    @ResponseStatus(code = HttpStatus.CREATED)
    public D save(@RequestBody D dto) {
        return getService().save(dto);
    }

    @PutMapping()
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public D update(@RequestBody D dto) {
        return getService().update(dto);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public void delete(@PathVariable("id") Long id) {
        this.getService().delete(id);
    }

    @GetMapping("/{id}")
    public D getById(@PathVariable("id") Long id) {
        return this.getService().findById(id);
    }

    @GetMapping("/search")
    public Page<D> search(@RequestParam(defaultValue = "id>0") String query,
                          @RequestParam(defaultValue = "0") Integer page,
                          @RequestParam(defaultValue = "10") Integer size,
                          @RequestParam(defaultValue = "asc") String order,
                          @RequestParam(defaultValue = "id") String sort
    ) {
        return this.getService().rsqlQuery(query, page, size, order, sort);
    }

}
