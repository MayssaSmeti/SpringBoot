package com.example.projecttt.controllers;

import com.example.projecttt.dto.SignupRequest;
import com.example.projecttt.entities.Grad;
import com.example.projecttt.entities.Utilisateur;
import com.example.projecttt.interfacesServices.AuthService;
import com.example.projecttt.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
@CrossOrigin("*")
@RestController
@RequestMapping("/signUp")
public class SignUpControler {
    private final AuthService authService ;
    private final UserService userService ;

    @Autowired
    public SignUpControler(AuthService authService, UserService userService) {
        this.authService = authService;
        this.userService = userService;
    }

    @GetMapping("/retrieve-user-by-mail/{email}")
    public Utilisateur retrieveUserByEmail(@PathVariable("email") String mail) {
        Utilisateur user = userService.retrieveUserByMail(mail);
        return user;
    }

    @PostMapping(value="registration", consumes = "multipart/form-data")
    public ResponseEntity<String> signupUser(@RequestParam String nom,
                                             @RequestParam String prenom,
                                             @RequestParam String email,
                                             @RequestParam String password,
                                             @RequestParam int numero,
                                             @RequestParam String adresse,
                                             @RequestParam Grad grade,
                                             @RequestParam("imagePath") MultipartFile image) throws IOException {

        SignupRequest signupRequest = new SignupRequest();
        signupRequest.setNom(nom);
        signupRequest.setPrenom(prenom);
        signupRequest.setEmail(email);
        signupRequest.setPassword(password);
        signupRequest.setNumero(numero);
        signupRequest.setAdresse(adresse);
        signupRequest.setGrade(grade);
     //   signupRequest.setImagePath(imageBytes);

        boolean isUserCreated = authService.createUser(signupRequest, image);
        if (isUserCreated) {
            return ResponseEntity.status(HttpStatus.CREATED).body("{\"message\": \"User created successfully\"}");
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"message\": \"Failed to create user\"}");
        }
    }


}

