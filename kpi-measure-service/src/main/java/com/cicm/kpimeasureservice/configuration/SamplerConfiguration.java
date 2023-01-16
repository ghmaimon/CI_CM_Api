package com.cicm.kpimeasureservice.configuration;

import com.cicm.kpimeasureservice.sampler.DataSampler;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SamplerConfiguration {

    @Value("${sampling.ratio}")
    private Integer samplingRatio;
    @Bean
    public DataSampler dataSampler() {
        return new DataSampler(samplingRatio);
    }
}
