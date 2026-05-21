package com.warmhouse.service;

import com.warmhouse.model.CoreSensor;
import com.warmhouse.repository.SensorRepository;
import com.warmhouse.model.SensorEvent;
import com.warmhouse.model.TelemetrySensor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class KafkaConsumerService {

    @Autowired
    SensorRepository sensorRepository;

    @KafkaListener(topics = "sensor-info")
    public void consume(SensorEvent message) {
        log.info("Received message {} from Go app: Sensor ID = {}, Location = {}",
                message.getEvent(), message.getSensor().getType(), message.getSensor());

        CoreSensor coreSensor = message.getSensor();
        String event = message.getEvent();
        TelemetrySensor sensor = new TelemetrySensor();
        sensor.setId(coreSensor.getId());
        sensor.setType(coreSensor.getType());
        sensor.setStatus(coreSensor.getStatus());
        sensor.setLocation(coreSensor.getLocation());

        if( "SensorCreated".equals(event) ) {
            sensorRepository.save(sensor);
        } else if( "SensorDeleted".equals(event) ){
            sensorRepository.delete(sensor);
        }
    }
}