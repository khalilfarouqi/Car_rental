package com.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.entity.Client;

@Repository
public interface ClientRepo extends JpaRepository<Client, Long> {

}
