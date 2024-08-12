package com.example.projecttt.services;

import com.example.projecttt.entities.Notification;
import com.example.projecttt.entities.Publication;
import com.example.projecttt.entities.Utilisateur;
import com.example.projecttt.interfacesServices.IPublicationService;
import com.example.projecttt.repositories.PublicationRepo;
import com.example.projecttt.repositories.UtilisateurRepo;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class PublicationService implements IPublicationService {
    @Autowired
    PublicationRepo publicationRepo;
    @Autowired
    NotificationServiceIml notificationServiceIml;
    @Autowired
    UserService userService;

    @Override
    public List<Publication> getAllPublications() {
        return publicationRepo.findAll();
    }

    @Override
    public Publication AjoutPublication(Publication publication) {
        // Récupérer l'utilisateur (vous devrez ajuster cela en fonction de votre logique d'authentification)
        Utilisateur user  = userService.retrieveUserByIdUtilisateur(publication.getUtilisateur().getUtilisateur_id());

        // Créer et enregistrer une notification
        // Créer et enregistrer une notification
        Notification notification = new Notification();
        notification.setDateNotification(new Date());
        notification.setContenu("Nouvelle publication ajoutée : " + publication.getContenu());
        notification.setUtilisateur(user);
        notificationServiceIml.AddNotif(notification);
        publication.setDatePublication(new Date());
        return publicationRepo.save(publication);
    }

    @Override
    public Publication ModifierPub(Publication publication) {
        return publicationRepo.save(publication);
    }

    @Override
    public void SupprimerPublication(int idPublication) {
        publicationRepo.deleteById(idPublication);

    }

    @Override
    @Transactional
    public List<Publication> getPublicationByUserId(Long utilisateur_id) {
        return publicationRepo.findAllByUtilisateur(utilisateur_id);

    }

    @Override
    public Publication retrievePublication(int idPublication) {
        return publicationRepo.findById(idPublication).orElse(null);
    }


}
