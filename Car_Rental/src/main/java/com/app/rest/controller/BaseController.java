package com.app.rest.controller;

import com.app.rest.api.BaseApi;
import com.app.sevice.impl.BaseService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@RestController
public class BaseController<T> implements BaseApi<T> {
    public final BaseService<T> baseService;

    @Override
    public Page<T> search(String query, Integer page, Integer size, String order, String sort) {
        return null;
    }

    @Override
    public List<T> getAll() {
        return baseService.getAll();
    }

    @Override
    public T getById(Long id) {
        return baseService.getById(id);
    }

    @Override
    public void save(T t) {
        baseService.save(t);
    }

    @Override
    public void update(T t) {
        baseService.update(t);
    }

    @Override
    public void delete(Long id) {
        baseService.delete(id);
    }
}
