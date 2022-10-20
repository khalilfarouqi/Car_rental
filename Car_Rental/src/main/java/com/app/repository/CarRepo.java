package com.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.entity.Car;

@Repository
public interface CarRepo extends JpaRepository<Car, Long> {
	
}
