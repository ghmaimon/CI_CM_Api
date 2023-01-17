package com.cicm.kpimeasureservice.kafkaConsumer;

import com.cicm.kpimeasureservice.enumeration.AlertType;
import com.cicm.kpimeasureservice.model.Alert;
import com.cicm.kpimeasureservice.model.KpiMeasure;
import com.cicm.kpimeasureservice.service.AlertService;
import com.cicm.kpimeasureservice.service.KpiMeasureService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;
import java.time.Instant;

@Component
@AllArgsConstructor
@Slf4j
public class KpiMeasureConsumer {

    private KpiMeasureService kpiMeasureService;
    private AlertService alertService;
    @KafkaListener(topics = {"${spring.kafka.consumer-topic}"})
    public void onMessage(ConsumerRecord<String, KpiMeasure> record) {
        kpiMeasureService.saveMeasure(record.value());
        if (record.value().getMoisture().getVolumetricWaterContent() >= Alert.WATER_UPPER_THRESHOLD) {
            Alert alert = new Alert(
                    AlertType.SUFFICIENT_WATER_LEVEL,
                    "Stop the irrigation",
                    Instant.now(),
                    "dummy zone id"
            );
            alertService.produceAlert(alert);
        } else if (record.value().getMoisture().getVolumetricWaterContent() <= Alert.WATER_LOWER_THRESHOLD) {
            Alert alert = new Alert(
                    AlertType.LOW_WATER_LEVEL,
                    "Start the irrigation",
                    Instant.now(),
                    "dummy zone id"
            );
            alertService.produceAlert(alert);
        }
        log.info(record.value().toString());
    }

}
