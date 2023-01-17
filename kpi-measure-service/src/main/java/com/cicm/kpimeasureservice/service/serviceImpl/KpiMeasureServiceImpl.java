package com.cicm.kpimeasureservice.service.serviceImpl;

import com.cicm.kpimeasureservice.model.KpiMeasure;
import com.cicm.kpimeasureservice.repository.KpiMeasureRepository;
import com.cicm.kpimeasureservice.sampler.DataSampler;
import com.cicm.kpimeasureservice.service.KpiMeasureService;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Primary
@Service
@AllArgsConstructor
public class KpiMeasureServiceImpl implements KpiMeasureService {
    private KpiMeasureRepository kpiMeasureRepository;
    private DataSampler dataSampler;
    @Override
    public void saveMeasure(KpiMeasure measure) {
        if (dataSampler.selectableSample())
            kpiMeasureRepository.save(measure);
    }
}
