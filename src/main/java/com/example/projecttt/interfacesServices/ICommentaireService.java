package com.example.projecttt.interfacesServices;

import com.example.projecttt.entities.Commentaire;

import java.security.Principal;
import java.util.List;
import java.util.Optional;

public interface ICommentaireService {
    public Optional<Commentaire> getCommentById(Integer id_comment) ;
    public int countUnreadNotifications(int idPublication) ;
    public List<Commentaire> getCommentaire();
    public Commentaire addCommentaire(Commentaire commentaire);
    public Commentaire updateCommentaire(Commentaire commentaire);
    List<Commentaire> getCommentsByPostId(Long postId);
    public void SupprimerCommentaire(long idCommentaire) ;
    public List<Commentaire> retrieveAllCommentairesByPublication(Integer idPublication) ;
    public Commentaire addComment2(int  idPublication, Commentaire commentaire) ;




    }
