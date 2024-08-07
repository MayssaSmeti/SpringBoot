package com.example.projecttt.repositories;

import com.example.projecttt.entities.Commentaire;
import com.example.projecttt.entities.Publication;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CommentaireRepo  extends JpaRepository<Commentaire, Long> {


    Optional<Commentaire> findByIdCommentaire(Integer idCommentaire);

    List<Commentaire> getAllByPublication(Publication publication);

}
