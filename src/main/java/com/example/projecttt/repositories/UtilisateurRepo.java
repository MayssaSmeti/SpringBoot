package com.example.projecttt.repositories;

import com.example.projecttt.entities.Utilisateur;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UtilisateurRepo extends CrudRepository<Utilisateur, Integer> {
}
