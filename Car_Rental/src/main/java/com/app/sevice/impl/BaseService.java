package com.app.sevice.impl;

import io.github.perplexhub.rsql.RSQLJPASupport;
import com.app.exception.ResourceNotFoundException;
import com.app.mapper.GenericModelMapper;
import com.app.repository.BaseJpaRepository;
import com.app.sevice.IBaseService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import oracle.security.crypto.util.InvalidInputException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.Optional;

@Slf4j
@Transactional(readOnly = true)
@RequiredArgsConstructor
@Service
public class BaseService<E, D extends Serializable> implements IBaseService<E, D> {
    BaseJpaRepository<E> baseJpaRepository;
    GenericModelMapper<E, D> mapperBase;
    @Override
    @Transactional
    public D save(D dto) {
        return mapperBase.toDto(baseJpaRepository.save(mapperBase.toEntity(dto)));
    }

    @Override
    @Transactional
    public D update(D dto) {
        return mapperBase.toDto(baseJpaRepository.save(mapperBase.toEntity(dto)));
    }

    @Override
    @Transactional
    public void delete(Long id) {
        Optional<E> auditEntity = baseJpaRepository.findById(id);
        if (auditEntity.isPresent()) {
            baseJpaRepository.delete(auditEntity.get());
        } else {
            log.debug(String.format("Resource with ID %s not found", id));
            throw new ResourceNotFoundException(String.format("Resource with ID %s not found", id, "delete ====> ", auditEntity.getClass().getSimpleName()));
        }
    }

    @Override
    public D findById(Long id) {
        log.debug("find by id = ".concat(id.toString()));
        Optional<E> auditEntity = baseJpaRepository.findById(id);
        if (auditEntity.isPresent()) {
            return mapperBase.toDto(auditEntity.get());
        } else {
            log.debug(String.format("User with ID %s not found", id));
            throw new ResourceNotFoundException(String.format("User with ID %s not found ====> ", id, "findById ====> ", auditEntity.getClass().getSimpleName()));
        }
    }

    @Override
    public Page<D> rsqlQuery(String query, Integer page, Integer size, String order, String sort) {
        if (query.isEmpty()) {
            try {
                throw new InvalidInputException("Argument is required");
            } catch (InvalidInputException e) {
                throw new RuntimeException(e);
            }
        }
        if (size > 20) {
            size = 20;
        }
        Specification spec = RSQLJPASupport.toSpecification(query);
        return baseJpaRepository.findAll(spec, PageRequest.of(page, size, Sort.Direction.fromString(order), sort)).map(mapperBase::toDtoOb);
    }
}
