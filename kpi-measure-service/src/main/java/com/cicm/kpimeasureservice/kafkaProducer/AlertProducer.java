package com.cicm.kpimeasureservice.kafkaProducer;

import com.cicm.kpimeasureservice.model.Alert;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;

@Component
public class AlertProducer {

    private final KafkaTemplate<String, Alert> kafkaTemplate;
    private final String topic;

    public AlertProducer(
            KafkaTemplate<String, Alert> kafkaTemplate,
            @Value("${spring.kafka.producer-topic}") String topic
    ) {
        this.kafkaTemplate = kafkaTemplate;
        this.topic = topic;
    }

    public void sendMessage(Alert alert) {
        Message<Alert> message = MessageBuilder
                .withPayload(alert)
                .setHeader(KafkaHeaders.TOPIC, this.topic)
                .build();

        kafkaTemplate.send(message);
    }

}
