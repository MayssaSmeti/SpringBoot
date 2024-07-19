package com.example.projecttt.repositories;

import com.example.projecttt.entities.Message;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface MessageRepo extends CrudRepository<Message, Long> {
}
