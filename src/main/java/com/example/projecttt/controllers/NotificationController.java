package com.example.projecttt.controllers;

import com.example.projecttt.entities.Message;
import com.example.projecttt.entities.Notification;
import com.example.projecttt.entities.Publication;
import com.example.projecttt.services.NotificationServiceIml;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

@RestController("/Notification")
public class NotificationController {
    NotificationServiceIml notificationService;

    @GetMapping("Notif")
    public List<Notification> getAllNotifications() {
        return notificationService.getAllNotifications();
    }

    @PostMapping("/AddNotif")
    public Notification addNotification(@RequestBody Notification notification) {
        notification.setDateNotification(new Date());
        notificationService.AddNotif(notification) ;
        return notification;
    }
}
