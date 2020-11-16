package io.hackages.learning.repository.dao;

import io.hackages.learning.repository.model.FlightEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface FlightDao extends CrudRepository<FlightEntity, Long> {
    List<FlightEntity> findByOrigin(String origin);
    List<FlightEntity> findByDestination(String destination);
}
