package com.example.projecttt.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Entity
@ToString
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Notification {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private int  idNotification;

    @ManyToOne
    @JoinColumn(name = "utilisateur_id")
    private Utilisateur utilisateur;
    private boolean vu ;
    private String contenu;
    private Date dateNotification;

}
