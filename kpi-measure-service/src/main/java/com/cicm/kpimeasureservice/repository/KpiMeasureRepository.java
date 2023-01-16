package com.cicm.kpimeasureservice.repository;

import com.cicm.kpimeasureservice.model.KpiMeasure;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface KpiMeasureRepository extends MongoRepository<KpiMeasure, String> {
}
