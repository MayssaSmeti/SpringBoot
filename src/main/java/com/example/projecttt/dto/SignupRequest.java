package com.example.projecttt.dto;

import com.example.projecttt.entities.Grad;
import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Lob;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class SignupRequest {
    private String nom;
    private String prenom;
    private String email;
    private String password;
    private int numero ;
    private String adresse ;
    @Enumerated(EnumType.STRING)
    private Grad grade;
    @Lob
    private byte[] photo;
}
