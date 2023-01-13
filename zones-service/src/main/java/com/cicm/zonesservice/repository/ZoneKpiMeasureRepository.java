package com.cicm.zonesservice.repository;

import com.cicm.zonesservice.model.ZoneKpiMeasure;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ZoneKpiMeasureRepository extends MongoRepository<ZoneKpiMeasure, String> {
}
