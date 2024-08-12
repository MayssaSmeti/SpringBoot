package com.example.projecttt.controllers;

import com.example.projecttt.entities.Message;
import com.example.projecttt.entities.Notification;
import com.example.projecttt.entities.Publication;
import com.example.projecttt.services.NotificationServiceIml;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
@CrossOrigin("*")
@RestController()
public class NotificationController {
    @Autowired
    NotificationServiceIml notificationService;


    @GetMapping("/NotifUser")
    public List<Notification> getNotificationByUtilisateur(@RequestParam Long  utilisateur_id) {
        return notificationService.getNotificationsByUserId(utilisateur_id);
    }
    @GetMapping("/Notif")
    public List<Notification> getAllNotifications() {
        return notificationService.getAllNotifications();
    }
    // Nouveau endpoint pour compter les notifications non lues
    @GetMapping("/unread-count")
    public int getUnreadNotificationsCount(@RequestParam Long utilisateur_id) {
        return notificationService.countUnreadNotifications(utilisateur_id);
    }


    @PostMapping("/AddNotif")
    public Notification addNotification(@RequestBody Notification notification) {
        notification.setDateNotification(new Date());
        notificationService.AddNotif(notification) ;
        return notification;
    }
}
