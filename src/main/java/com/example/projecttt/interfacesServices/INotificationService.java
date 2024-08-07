package com.example.projecttt.interfacesServices;

import com.example.projecttt.entities.Message;
import com.example.projecttt.entities.Notification;

import java.util.List;

public interface INotificationService {
    public List<Notification> getAllNotifications();
    public Notification AddNotif(Notification   notification);
}
