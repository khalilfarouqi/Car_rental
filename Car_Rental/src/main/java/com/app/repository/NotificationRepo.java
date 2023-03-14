package com.app.repository;

import com.app.entity.Notification;
import org.springframework.stereotype.Repository;

@Repository
public interface NotificationRepo extends BaseJpaRepository<Notification> {
}
