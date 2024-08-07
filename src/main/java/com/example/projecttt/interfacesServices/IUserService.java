package com.example.projecttt.interfacesServices;

import com.example.projecttt.entities.Utilisateur;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.security.Principal;
import java.util.List;

public interface IUserService {
    public List<Utilisateur> retrieveAllUsers();
    public Utilisateur AjoutUtilisateur(Utilisateur utilisateur);
    public Utilisateur  ModifierUtilisateur(Utilisateur utilisateur);
    public void SupprimerUtilisateur(Long utilisateur_id);
    public Utilisateur retrieveUserByMail(String email);
    public void deleteCurrentUser(Principal connectedUser) ;


}
