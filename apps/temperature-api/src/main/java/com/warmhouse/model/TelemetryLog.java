package com.warmhouse.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.Date;

@Data
public class TelemetryLog {

    @JsonProperty("id")
    private Integer id;

    @JsonProperty("sensor_id")
    private String sensorId;

    @JsonProperty("value")
    private Float value;

    @JsonProperty("unit")
    private String unit;

    @JsonProperty("timestamp")
    private Date timestamp;

    @JsonProperty("location")
    private String location;

    @JsonProperty("sensor_type")
    private String sensorType;

    @JsonProperty("status")
    private String status;

    @JsonProperty("description")
    private String description;


}
