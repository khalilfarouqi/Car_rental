package com.app.sevice.impl;

import com.app.repository.BaseJpaRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Transactional(readOnly = true)
@RequiredArgsConstructor
@Service
public class BaseService<T> {
    private final BaseJpaRepository baseJpaRepository;
    private final ModelMapper modelMapper;

    public List<T> getAll(){
        List<T> tList = new ArrayList<>();
        baseJpaRepository.findAll().forEach(element -> tList.add((T) element));
        return tList;
    }

    public T getById(Long id){
        return (T) baseJpaRepository.findById(id);
    }

    public void save(T t){
        baseJpaRepository.save(t);
    }

    public void update(T t){
        baseJpaRepository.save(t);
    }

    public void delete(Long id){
        baseJpaRepository.deleteById(id);
    }
}
