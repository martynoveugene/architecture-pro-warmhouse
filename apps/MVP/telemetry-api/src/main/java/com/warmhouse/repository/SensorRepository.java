package com.warmhouse.repository;

import com.warmhouse.model.TelemetrySensor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface SensorRepository extends JpaRepository<TelemetrySensor, Integer> {

}