package com.example.projecttt.repositories;

import com.example.projecttt.entities.Publication;
import com.example.projecttt.entities.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UtilisateurRepo extends JpaRepository<Utilisateur, Long> {
    Optional<Utilisateur> findByEmail(String Email);
    @Query("SELECT u FROM Utilisateur u WHERE u.utilisateur_id = :utilisateur_id")
    Utilisateur  findByUtilisateurid(@Param("utilisateur_id") Long utilisateur_id);
    @Query("SELECT u FROM Utilisateur u WHERE u.email = :email")
    Optional<Utilisateur> findByUtilisateurmail(@Param("email") String email);
}
