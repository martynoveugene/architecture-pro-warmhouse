package com.warmhouse.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Table(name = "telemetry_sensor")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TelemetrySensor {

    @Id
    @JsonProperty("id")
    private Long id;

    @JsonProperty("type")
    @Column(nullable = false, length = 50)
    private String type;

    @JsonProperty("location")
    @Column(nullable = false, length = 100)
    private String location;

    @JsonProperty("status")
    @Column(nullable = false, length = 20)
    private String status = "inactive";
}
