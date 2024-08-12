package com.example.projecttt.services;

import com.example.projecttt.entities.Notification;
import com.example.projecttt.entities.Utilisateur;
import com.example.projecttt.interfacesServices.INotificationService;
import com.example.projecttt.repositories.NotificaionRepo;
import com.example.projecttt.repositories.UtilisateurRepo;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NotificationServiceIml implements INotificationService {
    @Autowired
    NotificaionRepo notificaionRepo;
    @Autowired
    private UtilisateurRepo utilisateurRepo;

    @Override
    public List<Notification> getAllNotifications() {
        return  notificaionRepo.findAll();
    }

    @Override
    public Notification AddNotif(Notification notification) {
        return notificaionRepo.save(notification);
    }
@Override
    // Nouvelle méthode pour compter les notifications non lues
    public int countUnreadNotifications(Long utilisateur_id) {
        return notificaionRepo.countByUserReceiver(utilisateur_id);
    }
    @Override
    public List<Notification> getNotificationsByUserId(Long utilisateur_id) {
        // Fetch the Utilisateur entity by ID
        Utilisateur utilisateur = utilisateurRepo.findByUtilisateurid(utilisateur_id);

        // Use the fetched Utilisateur entity in the query
        return notificaionRepo.findNotifByUser(utilisateur);    }

}
