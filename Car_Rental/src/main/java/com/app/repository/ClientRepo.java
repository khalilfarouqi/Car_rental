package com.app.repository;

import org.springframework.stereotype.Repository;

import com.app.entity.Client;

@Repository
public interface ClientRepo extends BaseJpaRepository<Client> {

}
