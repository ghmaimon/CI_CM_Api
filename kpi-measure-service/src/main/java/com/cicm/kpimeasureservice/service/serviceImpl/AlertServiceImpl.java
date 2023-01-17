package com.cicm.kpimeasureservice.service.serviceImpl;

import com.cicm.kpimeasureservice.kafkaProducer.AlertProducer;
import com.cicm.kpimeasureservice.model.Alert;
import com.cicm.kpimeasureservice.service.AlertService;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Service
@Primary
@AllArgsConstructor
public class AlertServiceImpl implements AlertService {

    public AlertProducer alertProducer;

    @Override
    public void produceAlert(Alert alert) {
        alertProducer.sendMessage(alert);
    }
}
