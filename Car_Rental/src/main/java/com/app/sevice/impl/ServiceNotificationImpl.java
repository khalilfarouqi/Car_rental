package com.app.sevice.impl;

import com.app.entity.Notification;
import com.app.repository.NotificationRepo;
import com.app.sevice.IService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class ServiceNotificationImpl implements IService<Notification> {

    private NotificationRepo notificationRepo;

    @Override
    public List<Notification> getAll() {
        return notificationRepo.findAll();
    }

    @Override
    public Notification save(Notification notification) {
        return notificationRepo.save(notification);
    }

    @Override
    public Notification getById(Long id) {
        return notificationRepo.findById(id).get();
    }

    @Override
    public Notification update(Notification notification, Long id) {
        notification.setID(id);
        return notificationRepo.save(notification);
    }

    @Override
    public void deleteById(Long id) {
        this.notificationRepo.deleteById(id);
    }
}
