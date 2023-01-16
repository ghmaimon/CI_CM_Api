package com.cicm.kpimeasureservice.service.serviceImpl;

import com.cicm.kpimeasureservice.model.KpiMeasure;
import com.cicm.kpimeasureservice.sampler.DataSampler;
import com.cicm.kpimeasureservice.service.KpiMeasureService;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Primary;

@Primary
@AllArgsConstructor
public class KpiMeasureServiceImpl implements KpiMeasureService {
    private KpiMeasureService kpiMeasureService;
    private DataSampler dataSampler;
    @Override
    public void saveMeasure(KpiMeasure measure) {
        if (dataSampler.selectableSample())
            kpiMeasureService.saveMeasure(measure);
    }
}
