package com.app.repository;

import org.springframework.data.domain.*;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.*;

public interface BaseJpaRepository<T> extends JpaRepository<T, Long>, JpaSpecificationExecutor<T> {
    Page<T> findAll(Specification spec, Pageable pageable);
}
