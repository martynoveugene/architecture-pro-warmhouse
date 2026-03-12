package com.warmhouse.service;

import com.warmhouse.model.TelemetryLog;

public interface TemperatureService {

    TelemetryLog getByLocation(String location);

    TelemetryLog getBySenorId(String sensorId);
}
