package com.example.projecttt.repositories;

import com.example.projecttt.entities.Interaction;
import com.example.projecttt.entities.Publication;
import com.example.projecttt.entities.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository

public interface InteractionRepo extends JpaRepository<Interaction, Integer> {
    @Query("SELECT i FROM Interaction i WHERE i.InterPublications.idPublication = :idPublication AND i.InterUtilisateur.utilisateur_id = :utilisateur_id")
    Interaction findByPublicationAndUser(int idPublication, Long utilisateur_id);

    @Query("SELECT COUNT(i) FROM Interaction i WHERE i.InterPublications.idPublication = :idPublication AND i.InterType = true")
    int countLikesByPublication(int idPublication);

    @Query("SELECT i.InterUtilisateur FROM Interaction i WHERE i.InterPublications.idPublication = :idPublication AND i.InterType = true")
    List<Utilisateur> findUsersWhoLikedPublication(int idPublication);

    @Query("SELECT i FROM Interaction i WHERE i.InterPublications.idPublication = :idPublication AND i.InterType = true")
    List<Interaction> findLikesByPublication(int idPublication);
}
