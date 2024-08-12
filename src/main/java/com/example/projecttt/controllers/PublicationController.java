package com.example.projecttt.controllers;

import com.example.projecttt.entities.Publication;
import com.example.projecttt.entities.Utilisateur;
import com.example.projecttt.interfacesServices.IPublicationService;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Date;
import java.util.List;
@CrossOrigin("*")
@RestController()
@AllArgsConstructor
public class PublicationController {
    @Autowired
    private IPublicationService publicationService ;

    @GetMapping("/List")
    public List<Publication> getAllPublications() {
        return publicationService.getAllPublications();
    }
    @PostMapping("/add")
    public Publication addPublication(@RequestParam("contenu") String contenu,
                                      @RequestParam("utilisateur_id") long utilisateur_id,
                                      @RequestParam(value="imagePublication" ,required = false) MultipartFile image) throws IOException {
        Publication publication = new Publication();
        publication.setContenu(contenu);
        publication.setDatePublication(new Date());
        publication.setUtilisateur(new Utilisateur(utilisateur_id)); // Assuming Utilisateur has a constructor with id

        if (image != null && !image.isEmpty()) {
            publication.setImagePublication(image.getBytes());
            return publicationService.AjoutPublication(publication);
        }
        else {

        return publicationService.AjoutPublication(publication);}

    }

    @GetMapping("/publica/{utilisateur_id}")
    public List<Publication> getPublicationsByUserId(@PathVariable Long utilisateur_id) {
        return publicationService.getPublicationByUserId(utilisateur_id);
    }

    @PostMapping("Modifier")
    public Publication modifyPublication(@RequestBody Publication publication) {
        publicationService.AjoutPublication(publication);
        return publication;
    }

    @DeleteMapping("Delete/{idPublication}")
    public ResponseEntity<String> DeletePub(@PathVariable int idPublication) {
        try {
            publicationService.SupprimerPublication(idPublication);
            return new ResponseEntity<>("Publication supprimé avec succès.", HttpStatus.OK);
        } catch (EntityNotFoundException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>("Une erreur est survenue lors de la suppression de publication .", HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }
    
}
