package com.example.projecttt.interfacesServices;

import com.example.projecttt.entities.Commentaire;
import com.example.projecttt.entities.Publication;

import java.util.List;

public interface IPublicationService {
     public List<Publication> getAllPublications();
    public Publication AjoutPublication(Publication publication);
    public Publication  ModifierPub(Publication publication);
    public void SupprimerPublication (int idPublication);
    List<Publication> getPublicationByUserId(Long utilisateur_id);
    public Publication retrievePublication(int idPublication);

}
