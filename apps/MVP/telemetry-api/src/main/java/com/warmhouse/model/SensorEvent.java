package com.warmhouse.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.ToString;


@Data
@ToString
public class SensorEvent {

    @JsonProperty("sensor")
    CoreSensor sensor;

    @JsonProperty("event")
    String event;
}
