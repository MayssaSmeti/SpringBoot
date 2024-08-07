package com.example.projecttt.repositories;

import com.example.projecttt.entities.Commentaire;
import com.example.projecttt.entities.Publication;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PublicationRepo  extends JpaRepository<Publication, Integer> {

    Publication  findByIdPublication(Integer idPublication);
    @Query("SELECT p" +
            " FROM Publication p WHERE p.utilisateur.utilisateur_id= :utilisateur_id")
    List<Publication> findAllByUtilisateur(@Param("utilisateur_id") Long utilisateur_id);

}
