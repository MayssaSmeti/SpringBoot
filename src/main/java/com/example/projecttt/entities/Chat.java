package com.example.projecttt.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString

public class Chat {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long idChat;
    private boolean visibility;
    @ManyToMany
    @CollectionTable( name="utilisateur_id")
    private List<Utilisateur> emetteur  ;


}
