package com.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.entity.Photo;

@Repository
public interface PhotoRepo extends JpaRepository<Photo, Long> {

}
