package com.cicm.kpimeasureservice.kafkaConsumer;

import com.cicm.kpimeasureservice.model.KpiMeasure;
import com.cicm.kpimeasureservice.service.KpiMeasureService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
@Slf4j
public class KpiMeasureConsumer {

    private KpiMeasureService kpiMeasureService;
    @KafkaListener(topics = {"${spring.kafka.topic}", })
    public void onMessage(ConsumerRecord<String, KpiMeasure> record) {
        kpiMeasureService.saveMeasure(record.value());
        log.info(record.toString());
    }
}
