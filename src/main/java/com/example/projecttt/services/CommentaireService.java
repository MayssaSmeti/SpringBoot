package com.example.projecttt.services;

import com.example.projecttt.entities.Commentaire;
import com.example.projecttt.entities.Publication;
import com.example.projecttt.entities.Utilisateur;
import com.example.projecttt.interfacesServices.ICommentaireService;
import com.example.projecttt.repositories.CommentaireRepo;
import com.example.projecttt.repositories.PublicationRepo;
import com.example.projecttt.repositories.UtilisateurRepo;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.security.Principal;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class CommentaireService implements ICommentaireService {
    @Autowired
    CommentaireRepo commentaireRepo;
    @Autowired
    PublicationRepo publicationRepo;
    @Autowired
    UtilisateurRepo utilisateurRepo;
    @Autowired
    PublicationService publicationService;
@Override
    public Commentaire addComment2(int idPublication,  Commentaire commentaire) {
        Publication publication = publicationRepo.findByIdPublication(idPublication);
     commentaire.setPublication(publication);
    commentaire.setDateComment(new Date());


    return commentaireRepo.save(commentaire);
    }
    @Override
    public Optional<Commentaire> getCommentById(Integer id_commentaire) {
        return commentaireRepo.findByIdCommentaire(id_commentaire);
    }

    @Override
    public List<Commentaire> getCommentaire() {
        return commentaireRepo.findAll();
    }


    @Override
    public Commentaire addCommentaire(Commentaire commentaire) {

        commentaire.setDateComment(new Date());
        commentaireRepo.save(commentaire);
        return commentaire;
    }

    @Transactional
    public void saveCommentaireWithUtilisateur(Commentaire commentaire, Utilisateur utilisateur) {
        // Save the Utilisateur entity first
        if (utilisateur.getUtilisateur_id() == 0) { // Assuming 0 means it's not persisted yet
            utilisateurRepo.save(utilisateur);
        }

        // Set the persisted Utilisateur to the Commentaire
        commentaire.setUtilisateur(utilisateur);

        // Save the Commentaire entity
        commentaireRepo.save(commentaire);
    }
    @Override
    public Commentaire updateCommentaire(Commentaire commentaire) {
        commentaire.setDateComment(new Date());

        return commentaireRepo.save(commentaire);
    }

    @Override
    public List<Commentaire> getCommentsByPostId(Long postId)
    {
        return  null ;
                /*commentaireRepo.findByPostId(postId);*/

    }

    @Override
    public void SupprimerCommentaire(long idCommentaire) {
        commentaireRepo.deleteById(idCommentaire);

    }

    @Override
    public List<Commentaire> retrieveAllCommentairesByPublication(Integer idPublication) {
        Publication pub = publicationService.retrievePublication(idPublication);
        return commentaireRepo.getAllByPublication(pub);
    }
}

