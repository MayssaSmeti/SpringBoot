package com.example.projecttt.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Commentaire {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  long idCommentaire ;
    private  String contenu ;
    private Date dateComment ;

    @ManyToOne
    @JoinColumn(name = "idPublication")
    private Publication publication;

    @ManyToOne
    @JoinColumn(name = "utilisateur_id")
    private Utilisateur utilisateur;

}
