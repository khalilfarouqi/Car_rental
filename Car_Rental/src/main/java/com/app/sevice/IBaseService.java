package com.app.sevice;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;

import java.io.Serializable;

public interface IBaseService<E, D extends Serializable> extends IRsqlService<E, D> {
    D save(D dto);

    D update(D dto);

    void delete(Long id);

    D findById(Long id);
    Page<E> findAll(Specification spec, Pageable pageable);
}
