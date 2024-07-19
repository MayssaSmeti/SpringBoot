package com.example.projecttt.repositories;

import com.example.projecttt.entities.Commentaire;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentaireRepo  extends CrudRepository<Commentaire, Integer> {
}
