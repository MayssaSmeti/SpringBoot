package com.example.projecttt.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor


public class Utilisateur {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private long utilisateur_id;
    private String nom;
    private String prenom;
    private String email;
    private String password;


    @Enumerated(EnumType.STRING)
    private Role role;
    private int numero ;
    private boolean ban ;


    @Enumerated (EnumType.STRING)
    private Grad grade;

    @OneToMany(mappedBy = "utilisateur", cascade = CascadeType.ALL)
    private List<Publication> posts;

    @OneToMany(mappedBy = "utilisateur", cascade = CascadeType.ALL)
    private List<Commentaire> commentaires;

    @OneToMany(mappedBy = "emetteur", cascade = CascadeType.ALL)
    private List<Message> messagesEnvoyes;

    @OneToMany(mappedBy = "recepteur", cascade = CascadeType.ALL)
    private List<Message> messagesRecus;

    @OneToMany(mappedBy = "utilisateur", cascade = CascadeType.ALL)
    private List<Notification> notifications;


}
