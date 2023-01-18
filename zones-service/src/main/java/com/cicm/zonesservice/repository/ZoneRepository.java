package com.cicm.zonesservice.repository;

import com.cicm.zonesservice.model.Zone;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface ZoneRepository extends MongoRepository<Zone, String> {
    Optional<Zone> findZoneBySensor_Id(String sensorId);
}
