package com.example.projecttt.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Message {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private int idMessage;
    private String cropM ;
    private Date date ;
    private  boolean etat  ;


    @ManyToOne
    @JoinColumn(name = "emetteur_id")
    private Utilisateur emetteur;

    @ManyToOne
    @JoinColumn(name = "recepteur_id")
    private Utilisateur recepteur;

    private String contenu;
    private LocalDateTime dateEnvoi;

}
