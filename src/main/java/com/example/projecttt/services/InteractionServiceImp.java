package com.example.projecttt.services;

import com.example.projecttt.entities.Interaction;
import com.example.projecttt.entities.Publication;
import com.example.projecttt.entities.Utilisateur;
import com.example.projecttt.interfacesServices.IInteractionService;
import com.example.projecttt.repositories.InteractionRepo;
import com.example.projecttt.repositories.PublicationRepo;
import com.example.projecttt.repositories.UtilisateurRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class InteractionServiceImp  implements IInteractionService {

    @Autowired
    private InteractionRepo interactionRepo;

    @Autowired
    private PublicationRepo publicationRepo;

    @Autowired
    private UtilisateurRepo utilisateurRepo;
    @Override
    public void likePublication(int idPublication, Long utilisateur_id) {
        Publication publication = publicationRepo.findById(idPublication).orElseThrow(() -> new RuntimeException("Publication not found"));
        Utilisateur utilisateur = utilisateurRepo.findById(utilisateur_id).orElseThrow(() -> new RuntimeException("User not found"));

        Interaction interaction = interactionRepo.findByPublicationAndUser(idPublication, utilisateur_id);
        if (interaction == null) {
            interaction = new Interaction();
            interaction.setInterPublications(publication);
            interaction.setInterUtilisateur(utilisateur);
            interaction.setInterType(true);
            interactionRepo.save(interaction);
        } else if (!interaction.isInterType()) {
            interaction.setInterType(true);
            interactionRepo.save(interaction);
        }

    }

    @Override
    public void unlikePublication(int idPublication, Long utilisateur_id) {
        Interaction interaction = interactionRepo.findByPublicationAndUser(idPublication, utilisateur_id);
        if (interaction != null && interaction.isInterType()) {
            interaction.setInterType(false);
            interactionRepo.save(interaction);
        }
    }

    @Override
    public List<Interaction> getLikesByPublication(int idPublication) {
        return interactionRepo.findLikesByPublication(idPublication);
    }

    @Override
    public List<Utilisateur> getUserLikes(int idPublication) {
        return interactionRepo.findUsersWhoLikedPublication(idPublication);

    }

    @Override
    public int getLikes(int idPublication) {
        return interactionRepo.countLikesByPublication(idPublication);
    }
}
