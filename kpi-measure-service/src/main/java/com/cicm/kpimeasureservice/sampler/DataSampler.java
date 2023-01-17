package com.cicm.kpimeasureservice.sampler;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Getter
@Component
public class DataSampler {
    private Integer samplingRatio;
    @Value("${sampling.ratio}")
    private Integer defaultSamplingRatio;
    private Integer counter;

    public DataSampler() {
        this.samplingRatio = this.defaultSamplingRatio;
        this.counter = 0;
    }

    public void setSamplingRatio(Integer samplingRatio) {
        this.samplingRatio = samplingRatio;
    }

    public Boolean selectableSample() {
        this.counter ++;
        if (this.counter.equals(this.samplingRatio)) {
            this.counter = 0;
            return true;
        }
        return false;
    }
}
