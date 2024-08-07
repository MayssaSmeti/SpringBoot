package com.example.projecttt.entities;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
@ToString
public class Publication implements Serializable {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private int idPublication;
    @Lob
    private byte[] imagePublication;
    @ManyToOne
    @JoinColumn(name = "utilisateur_id")
    private Utilisateur utilisateur;
    private String contenu;
    private Date datePublication;




}
