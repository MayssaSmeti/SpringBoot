package com.example.projecttt.services;

import com.example.projecttt.dto.SignupRequest;
import com.example.projecttt.entities.Utilisateur;
import com.example.projecttt.interfacesServices.AuthService;
import com.example.projecttt.repositories.UtilisateurRepo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.io.IOException;
@Service
public class AuthServiceImpl implements AuthService {

    private final UtilisateurRepo utilisateurRepo ;
    private  final PasswordEncoder passwordEncoder ;


    @Autowired
    public  AuthServiceImpl (UtilisateurRepo utilisateurRepo, PasswordEncoder passwordEncoder) {
        this.utilisateurRepo = utilisateurRepo;
         this.passwordEncoder = passwordEncoder;
    }

    @Override
    public boolean createUser(SignupRequest signupRequest) throws IOException {
        Utilisateur user = new Utilisateur();
        BeanUtils.copyProperties(signupRequest,user);
        String hashPassword = passwordEncoder.encode(signupRequest.getPassword());
        user.setPassword(hashPassword);
        Utilisateur createdUser = utilisateurRepo.save(user);
        return true;
    }
}
