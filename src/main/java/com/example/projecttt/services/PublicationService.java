package com.example.projecttt.services;

import com.example.projecttt.entities.Publication;
import com.example.projecttt.interfacesServices.IPublicationService;
import com.example.projecttt.repositories.PublicationRepo;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class PublicationService implements IPublicationService {
    @Autowired
    PublicationRepo publicationRepo;

    @Override
    public List<Publication> getAllPublications() {
        return publicationRepo.findAll();
    }

    @Override
    public Publication AjoutPublication(Publication publication) {
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
