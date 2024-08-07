package com.example.projecttt.repositories;

import com.example.projecttt.entities.Chat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ChatRepo  extends JpaRepository<Chat, Long> {

    @Query("SELECT c FROM Chat c JOIN c.emetteur u WHERE u.utilisateur_id = :utilisateur_id")
    List<Chat> findByUtilisateurs(@Param("utilisateur_id") Long utilisateur_id);
}
