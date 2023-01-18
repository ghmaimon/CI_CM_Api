package com.cicm.zonesservice.repository;

import com.cicm.zonesservice.model.Plant;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface PlantRepository extends MongoRepository<Plant, String> {
}
