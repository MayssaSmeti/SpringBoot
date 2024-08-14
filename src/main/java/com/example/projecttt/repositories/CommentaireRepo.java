package com.example.projecttt.repositories;

import com.example.projecttt.entities.Commentaire;
import com.example.projecttt.entities.Publication;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CommentaireRepo  extends JpaRepository<Commentaire, Long> {

    @Query("select count(n) from Commentaire n where n.publication.idPublication = :idPublication")
    int countByUserReceiver(@Param("idPublication") int idPublication);

    Optional<Commentaire> findByIdCommentaire(Integer idCommentaire);

    List<Commentaire> getAllByPublication(Publication publication);

}
