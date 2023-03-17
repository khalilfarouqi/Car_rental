package com.app.repository;

import org.springframework.data.jpa.repository.*;

public interface BaseJpaRepository<T> extends JpaRepository<T, Long>, JpaSpecificationExecutor<T> {

}
