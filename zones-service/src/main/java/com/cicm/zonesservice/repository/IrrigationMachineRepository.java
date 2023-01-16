package com.cicm.zonesservice.repository;

import com.cicm.zonesservice.model.IrrigationMachine;
import com.cicm.zonesservice.model.Zone;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface IrrigationMachineRepository extends MongoRepository<IrrigationMachine, String> {
}
