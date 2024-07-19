package com.example.projecttt.repositories;

import com.example.projecttt.entities.Publication;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PublicationRepo  extends CrudRepository<Publication, Integer> {
}
