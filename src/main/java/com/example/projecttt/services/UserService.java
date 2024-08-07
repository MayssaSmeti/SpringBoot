package com.example.projecttt.services;

import com.example.projecttt.entities.Utilisateur;
import com.example.projecttt.interfacesServices.IUserService;
import com.example.projecttt.repositories.UtilisateurRepo;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

import java.security.Principal;
import java.util.List;

@Service
public class UserService implements IUserService {
    @Autowired
  private UtilisateurRepo utilisateurRepo ;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    @Transactional
    public List<Utilisateur> retrieveAllUsers() {
        return utilisateurRepo.findAll();
    }

    @Override
    public Utilisateur AjoutUtilisateur(Utilisateur utilisateur) {
        return utilisateurRepo.save(utilisateur);
    }

    @Override
    public Utilisateur ModifierUtilisateur(Utilisateur utilisateur) {
        String hashPassword = passwordEncoder.encode(utilisateur.getPassword());
        utilisateur.setPassword(hashPassword);
        return utilisateurRepo.save(utilisateur);
    }
    @Override
    public void SupprimerUtilisateur(Long utilisateur_id) {
        if (utilisateurRepo.existsById(utilisateur_id)) {
            utilisateurRepo.deleteById(utilisateur_id);
        } else {
            throw new EntityNotFoundException("Utilisateur avec l'id " + utilisateur_id + " n'existe pas.");
        }
    }
    @Override
    public Utilisateur retrieveUserByMail(String email) {
        return utilisateurRepo.findByEmail(email).orElse(null);
    }

    public Utilisateur getCurrentUser(UserDetails userDetails) {

        Utilisateur utilisateur = new Utilisateur();
        utilisateur.setEmail(userDetails.getUsername());
        return utilisateur;
    }
    @Override
    public void deleteCurrentUser(Principal connectedUser) {

    }


}

