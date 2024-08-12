package com.example.projecttt.repositories;

import com.example.projecttt.entities.Notification;
import com.example.projecttt.entities.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NotificaionRepo extends JpaRepository<Notification, Integer> {
    @Query("select n from Notification n where n.utilisateur = :utilisateur")
    List<Notification> findNotifByUser(@Param("utilisateur")Utilisateur utilisateur);
    @Query("select count(n) from Notification n where n.utilisateur.utilisateur_id = :utilisateur_id and n.vu = false")
    int countByUserReceiver(@Param("utilisateur_id") Long utilisateur_id);
}
