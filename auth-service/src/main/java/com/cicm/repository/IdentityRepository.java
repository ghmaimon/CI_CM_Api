package com.cicm.repository;

import com.cicm.model.Identity;
import io.micronaut.data.mongodb.annotation.MongoRepository;
import io.micronaut.data.repository.CrudRepository;

import java.util.Optional;

@MongoRepository
public interface IdentityRepository extends CrudRepository<Identity, String> {

    Optional<Identity> findByUsername(String username);
}
