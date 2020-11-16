package io.hackages.learning.domain.manager.airplane.api;

import io.hackages.learning.domain.model.Airplane;

import java.util.List;

public interface AirplaneService {

    /**
     * Get all airplane of the company
     * @return All the airplanes
     */
    List<Airplane> getAirplanes();

    /**
     * Add a new airplane
     * @param airplane airplane
     * @return the added airplane
     */
    Airplane addAirplane(Airplane airplane);

    /**
     * Remove an airplane with a specific code
     * @param code airplane code
     */
    void removeAirplane(String code);

    /**
     * Change description of an airplane
     * @param airplane airplane to update
     * @param model description of the airplane
     * @return the airplane
     */
    Airplane changeModel(Airplane airplane, String model);

    /**
     * Get an airplane by code
     * @param code identification code of an airplane
     * @return the airplane
     */
    Airplane getAirplaneByCode(String code);

}
