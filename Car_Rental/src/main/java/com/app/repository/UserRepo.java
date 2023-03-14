package com.app.repository;

import org.springframework.stereotype.Repository;

import com.app.entity.User;

@Repository
public interface UserRepo extends BaseJpaRepository<User> {
	
}
