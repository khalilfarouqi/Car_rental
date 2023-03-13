package com.app.sevice.impl;

import com.app.entity.NotificationGroupe;
import com.app.repository.NotificationGroupeRepo;
import com.app.sevice.IService;

import java.util.List;

public class ServiceNotificationGroupeImpl implements IService<NotificationGroupe> {

    private NotificationGroupeRepo notificationGroupeRepo;

    @Override
    public List<NotificationGroupe> getAll() {
        return notificationGroupeRepo.findAll();
    }

    @Override
    public NotificationGroupe save(NotificationGroupe notificationGroupe) {
        return notificationGroupeRepo.save(notificationGroupe);
    }

    @Override
    public NotificationGroupe getById(Long id) {
        return notificationGroupeRepo.findById(id).get();
    }

    @Override
    public NotificationGroupe update(NotificationGroupe notificationGroupe, Long id) {
        notificationGroupe.setID(id);
        return notificationGroupeRepo.save(notificationGroupe);
    }

    @Override
    public void deleteById(Long id) {
        this.notificationGroupeRepo.deleteById(id);
    }
}
