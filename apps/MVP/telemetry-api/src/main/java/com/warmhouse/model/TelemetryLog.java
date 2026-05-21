package com.warmhouse.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Data;

import java.time.OffsetDateTime;

@Entity
@Table(name = "telemetry_log")
@Data
public class TelemetryLog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonProperty("id")
    private Integer id;

    @Column(name = "sensor_id")
    @JsonProperty("sensor_id")
    private String sensorId;

    @JsonProperty("value")
    private Float value;

    @JsonProperty("unit")
    private String unit;

    @Column(name = "created_at")
    @JsonProperty("timestamp")
    private OffsetDateTime createdAt;

    @JsonProperty("location")
    private String location;

    @JsonProperty("sensor_type")
    private String sensorType;

    @JsonProperty("status")
    private String status;

    @JsonProperty("description")
    private String description;
}
