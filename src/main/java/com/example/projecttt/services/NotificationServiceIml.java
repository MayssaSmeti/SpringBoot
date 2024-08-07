package com.example.projecttt.services;

import com.example.projecttt.entities.Notification;
import com.example.projecttt.interfacesServices.INotificationService;
import com.example.projecttt.repositories.NotificaionRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NotificationServiceIml implements INotificationService {
    @Autowired
    NotificaionRepo notificaionRepo;
    @Override
    public List<Notification> getAllNotifications() {
        return  notificaionRepo.findAll();
    }

    @Override
    public Notification AddNotif(Notification notification) {
        return notificaionRepo.save(notification);
    }

}
