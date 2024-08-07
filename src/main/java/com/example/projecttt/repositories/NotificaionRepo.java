package com.example.projecttt.repositories;

import com.example.projecttt.entities.Notification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NotificaionRepo extends JpaRepository<Notification, Integer> {
    @Query("select n from Notification n where n.utilisateur = :utilisateur_id")
    List<Notification> findNotifByUser(@Param("utilisateur_id") Long utilisateur_id);
    @Query("select count(*) from Notification i where i.utilisateur = :utilisateur_id and i.vu = false ")
    public int countByUserReceiver(@Param("utilisateur_id") Long utilisateur_id);
}
