package com.app.sevice;

import com.app.exception.ResourceNotFoundException;
import com.app.mapper.GenericModelMapper;
import com.app.repository.BaseJpaRepository;
import com.app.sevice.IBaseService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;

import javax.transaction.Transactional;
import java.io.Serializable;
import java.util.Optional;

@Slf4j
public abstract class BaseServiceImpl <E, D extends Serializable> implements IBaseService<E, D> {

    @Autowired
    BaseJpaRepository<E> baseJpaRepository;

    @Autowired
    GenericModelMapper<E, D> mapper;

    @Override
    public D save(D dto) {
        return mapper.toDto(baseJpaRepository.save(mapper.toEntity(dto)));
    }

    @Override
    @Transactional
    public D update(D dto) {
        return mapper.toDto(baseJpaRepository.save(mapper.toEntity(dto)));
    }

    @Override
    @Transactional
    public void delete(Long id) {
        Optional<E> auditEntity = baseJpaRepository.findById(id);
        if (auditEntity.isPresent()) {
            baseJpaRepository.delete(auditEntity.get());
        } else {
            log.debug(String.format("Resource with ID %s not found", id));
            throw new ResourceNotFoundException("Resource with ID %s not found", id, "delete ====> ", auditEntity.getClass().getSimpleName());
        }
    }

    @Override
    public D findById(Long id) {
        log.debug("find by id = ".concat(id.toString()));
        Optional<E> auditEntity = baseJpaRepository.findById(id);
        if (auditEntity.isPresent()) {
            return mapper.toDto(auditEntity.get());
        } else {
            log.debug(String.format("User with ID %s not found", id));
            throw new ResourceNotFoundException("User with ID %s not found ====> ", id, "findById ====> ", auditEntity.getClass().getSimpleName());
        }
    }

    @Override
    public Page<E> findAll(Specification spec, Pageable pageable) {
        return baseJpaRepository.findAll(spec, pageable);
    }
}
