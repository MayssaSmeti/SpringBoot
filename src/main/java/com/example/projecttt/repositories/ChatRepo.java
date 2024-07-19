package com.example.projecttt.repositories;

import com.example.projecttt.entities.Chat;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChatRepo  extends CrudRepository<Chat, Long> {
}
