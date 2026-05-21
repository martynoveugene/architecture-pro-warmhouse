package com.warmhouse.controller;

import com.warmhouse.model.TelemetryLog;
import com.warmhouse.service.TemperatureService;
import lombok.val;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping("/temperature")
public class TemperatureController {
    private final TemperatureService temperatureService;

    @Autowired
    public TemperatureController(TemperatureService temperatureService) {
        this.temperatureService = temperatureService;
    }

    @GetMapping(value = "{sensorId}",  produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<TelemetryLog> getBySensorId(
            @PathVariable("sensorId") String sensorId
    ) {
        val data = temperatureService.getBySenorId(sensorId);
        return ResponseEntity.ok(data);
    }

    @GetMapping(produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<TelemetryLog> getByLocation(
        @RequestParam("location") String location
    ) {
        val data = temperatureService.getByLocation(location);
        return ResponseEntity.ok(data);
    }
}
