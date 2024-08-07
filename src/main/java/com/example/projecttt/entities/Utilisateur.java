package com.example.projecttt.entities;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Utilisateur implements UserDetails {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long utilisateur_id;
    private String nom;
    private String prenom;
    @NonNull
    @Column(unique = true)
    private String email;
    private String adresse ;
    private String password;
    private int numero ;
    private boolean ban ;
    @Lob
    private  byte[] imagePath;


    @Enumerated (EnumType.STRING)
    private Grad grade;

    public Utilisateur(long utilisateur_id) {
        this.utilisateur_id = utilisateur_id;
    }


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of();
    }

    @Override
    public String getUsername() {
        return "";
    }

    @Override
    public boolean isEnabled() {
        return UserDetails.super.isEnabled();
    }


}
