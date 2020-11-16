package io.hackages.learning.repository.dao;

import io.hackages.learning.repository.model.AirplaneEntity;
import org.springframework.data.repository.CrudRepository;

public interface AirplaneDao extends CrudRepository<AirplaneEntity, Long> {
    AirplaneEntity findByCode(String code);
    void deleteByCode(String code);
}
