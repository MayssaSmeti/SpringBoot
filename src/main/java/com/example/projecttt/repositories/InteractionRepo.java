package com.example.projecttt.repositories;

import com.example.projecttt.entities.Interaction;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface InteractionRepo extends CrudRepository<Interaction, Integer> {
}
