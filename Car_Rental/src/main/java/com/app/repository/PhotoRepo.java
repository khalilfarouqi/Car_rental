package com.app.repository;

import org.springframework.stereotype.Repository;

import com.app.entity.Photo;

@Repository
public interface PhotoRepo extends BaseJpaRepository<Photo> {

}
