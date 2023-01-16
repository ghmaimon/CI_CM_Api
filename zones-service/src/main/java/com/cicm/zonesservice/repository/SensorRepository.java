package com.cicm.zonesservice.repository;

import com.cicm.zonesservice.model.Sensor;
import com.cicm.zonesservice.model.Zone;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface SensorRepository extends MongoRepository<Sensor, String> {
}
