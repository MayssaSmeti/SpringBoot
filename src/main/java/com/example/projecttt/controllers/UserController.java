package com.example.projecttt.controllers;

import com.example.projecttt.entities.Publication;
import com.example.projecttt.entities.Utilisateur;
import com.example.projecttt.repositories.UtilisateurRepo;
import com.example.projecttt.services.UserService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController()
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/users")
    public List<Utilisateur> getAllPublications() {
        return userService.retrieveAllUsers();
    }

    @GetMapping("/me")
    public ResponseEntity<Utilisateur> getCurrentUtilisateur(@AuthenticationPrincipal UserDetails userDetails) {
        Utilisateur currentUser = userService.getCurrentUser(userDetails);
        return ResponseEntity.ok(currentUser);
    }
    @PostMapping("/Create")
    public Utilisateur CreateUser (@RequestBody Utilisateur utilisateur)
    {
        userService.AjoutUtilisateur(utilisateur);
        return (utilisateur);
    }
    @PutMapping("/Update")
    public  Utilisateur UpdateUtilisateur ( @RequestBody Utilisateur utilisateur)
    {
        userService.ModifierUtilisateur(utilisateur);
        return (utilisateur);
    }

    @DeleteMapping("supprimer/{utilisateur_id}")
    public ResponseEntity<String> supprimerUtilisateur(@PathVariable Long utilisateur_id) {
        try {
            userService.SupprimerUtilisateur(utilisateur_id);
            return new ResponseEntity<>("Utilisateur supprimé avec succès.", HttpStatus.OK);
        } catch (EntityNotFoundException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>("Une erreur est survenue lors de la suppression de l'utilisateur.", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Retrieve user by email
    @GetMapping("/retrieve-user-by-mail/{email}")
    public Utilisateur retrieveUserByEmail(@PathVariable("email") String mail) {
        Utilisateur user = userService.retrieveUserByMail(mail);
        return user;
    }



}
