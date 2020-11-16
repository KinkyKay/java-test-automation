package io.hackages.learning.domain.manager.airplane.spi;

import io.hackages.learning.domain.exception.TechnicalException;
import io.hackages.learning.domain.model.Airplane;

import java.io.IOException;
import java.util.List;

public interface AirplaneServiceProvider {

    /**
     * List all airplanes of the company
     * @return All airplanes
     * @throws TechnicalException Mostly for database error
     */
    List<Airplane> getAirplanes() throws TechnicalException;

    /**
     * Add a new airplane
     * @param code airplane's code
     * @param model airplane's description
     * @param description airplane's description
     * @return The new airplane Something went wrong for the database
     * @throws TechnicalException Something went wrong for the database
     */
    Airplane addAirplane(String code, String model, String description) throws TechnicalException;

    /**
     * Delete airplane with the specific code
     * @param code airplane code
     * @throws TechnicalException Something went wrong for the database
     */
    void deleteAirplane(String code) throws TechnicalException;

    /**
     * Update the model of an airplane
     * @param code the airplane's code
     * @param model the new model of the airplane
     * @return the airplane with updated description
     * @throws TechnicalException Something went wrong for the database
     */
    Airplane updateAirplaneModel(String code, String model) throws TechnicalException;

    /**
     * Find an airplane with this {code}
     * @param code airplane's code
     * @return an airplane
     * @throws TechnicalException Something went wrong for the database
     */
    Airplane getAirplaneByCode(String code) throws TechnicalException;
}
