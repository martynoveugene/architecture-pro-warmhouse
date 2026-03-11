package com.warmhouse.service;

import com.warmhouse.model.TelemetryLog;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

@RequiredArgsConstructor
@Slf4j
@Service
@Transactional(readOnly = true)
public class TemperatureServiceImpl implements TemperatureService {

    @Override
    public TelemetryLog getByLocation(String location) {
        log.info("find by location = '{}'", location);

        // If no sensor ID is provided, generate one based on location
        String sensorId = "";
        if( location!=null ){
            sensorId = switch( location ) {
                case "Living Room" -> "1";
                case "Bedroom" -> "2";
                case "Kitchen" -> "3";
                default -> "0";
            };
        }

        TelemetryLog log = new TelemetryLog();
        log.setId(111);
        log.setUnit("celsius");
        log.setValue(-40 + (float)Math.random() * 80);
        log.setTimestamp(new Date());
        log.setSensorId(sensorId);
        log.setLocation(location);
        log.setStatus("active");
        log.setSensorType("temperature");
        log.setDescription("random temp sensor");
        return log;
    }

    @Override
    public TelemetryLog getBySenorId(String sensorId) {
        log.info("find by sensorId = '{}'", sensorId);

        // If no location is provided, use a default based on sensor ID
        String location = "";
        if( sensorId!=null ){
            location = switch( sensorId ) {
                case "1" -> "Living Room";
                case "2" -> "Bedroom";
                case "3" -> "Kitchen";
                default -> "Unknown";
            };
        }

        TelemetryLog log = new TelemetryLog();
        log.setId(111);
        log.setUnit("celsius");
        log.setValue(-40 + (float)Math.random() * 80);
        log.setTimestamp(new Date());
        log.setSensorId(sensorId);
        log.setLocation(location);
        log.setStatus("active");
        log.setSensorType("temperature");
        log.setDescription("random temp sensor");
        return log;
    }
}
