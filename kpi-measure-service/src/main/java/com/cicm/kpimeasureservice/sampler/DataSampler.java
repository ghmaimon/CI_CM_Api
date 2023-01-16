package com.cicm.kpimeasureservice.sampler;

import lombok.Getter;

@Getter
public class DataSampler {
    private Integer samplingRatio;
    private final Integer defaultSamplingRatio;
    private Integer counter;

    public DataSampler(Integer defaultSamplingRatio) {
        this.defaultSamplingRatio = defaultSamplingRatio;
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
