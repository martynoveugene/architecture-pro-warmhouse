package com.warmhouse.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.ToString;

import java.util.Date;

@Data
@ToString
public class CoreSensor {

    @JsonProperty("id")
    private Long id;

    @JsonProperty("name")
    private String name;

    @JsonProperty("type")
    private String type;

    @JsonProperty("location")
    private String location;

    @JsonProperty("value")
    private Float value;

    @JsonProperty("unit")
    private String unit;

    @JsonProperty("status")
    private String status;

    @JsonProperty("last_updated")
    private Date lastUpdated;

    @JsonProperty("created_at")
    private Date createdAt;
}
