package com.example.projecttt.entities;

import jakarta.persistence.*;
import lombok.*;
@Entity
@Setter
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class Interaction {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private int idInteraction;
    private boolean  InterType ;
    @ManyToOne
    @JoinColumn(name="idPublication")
    private Publication InterPublications ;
    @ManyToOne
    @JoinColumn(name="utilisateur_id")
    private Utilisateur InterUtilisateur;



}
