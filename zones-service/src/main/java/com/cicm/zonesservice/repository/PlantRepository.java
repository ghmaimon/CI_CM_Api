package com.cicm.zonesservice.repository;

import com.cicm.zonesservice.model.Plant;
import com.cicm.zonesservice.model.Zone;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PlantRepository extends MongoRepository<Plant, String> {
}
