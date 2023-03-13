package com.app.repository;

import com.app.entity.NotificationGroupe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NotificationGroupeRepo extends JpaRepository<NotificationGroupe, Long> {
}
