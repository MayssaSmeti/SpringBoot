package com.example.projecttt.repositories;

import com.example.projecttt.entities.Commentaire;
import com.example.projecttt.entities.Message;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MessageRepo extends JpaRepository<Message, Long> {


    @Query("select m from Message m where m.chat.idChat = :idChat")
    List<Message> getChatByChatId(@Param("idChat") long idChat );
}
