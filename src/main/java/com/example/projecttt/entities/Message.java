package com.example.projecttt.entities;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Message {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long   idMessage;
    private  boolean etat;
    private String contenu;
    private Date dateEnvoi;
    @ManyToOne
    @JoinColumn(name = "utilisateur_id")
    private Utilisateur emetteur;

    @ManyToOne
    @JoinColumn(name = "chat")
    private Chat chat;

}
