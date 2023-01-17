package com.cicm.kpimeasureservice.service;


import com.cicm.kpimeasureservice.model.KpiMeasure;
import org.springframework.stereotype.Service;

public interface KpiMeasureService {
    void saveMeasure(KpiMeasure measure);
}
