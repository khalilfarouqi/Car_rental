package com.app.repository;

import org.springframework.stereotype.Repository;

import com.app.entity.Car;

@Repository
public interface CarRepo extends BaseJpaRepository<Car> {
	
}
