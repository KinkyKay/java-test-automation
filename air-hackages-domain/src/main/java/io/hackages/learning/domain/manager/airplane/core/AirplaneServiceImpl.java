package io.hackages.learning.domain.manager.airplane.core;

import io.hackages.learning.domain.exception.FunctionalException;
import io.hackages.learning.domain.exception.TechnicalException;
import io.hackages.learning.domain.manager.airplane.api.AirplaneService;
import io.hackages.learning.domain.manager.airplane.spi.AirplaneServiceProvider;
import io.hackages.learning.domain.model.Airplane;

import java.util.List;

public class AirplaneServiceImpl implements AirplaneService {

    private final AirplaneServiceProvider provider;

    public AirplaneServiceImpl(AirplaneServiceProvider provider) {
        this.provider = provider;
    }

    @Override
    public List<Airplane> getAirplanes() {
        return provider.getAirplanes();
    }

    @Override
    public Airplane addAirplane(Airplane airplane) {
        if (airplane != null && airplane.getCode() != null) {
            try {
                return provider.addAirplane(airplane.getCode(), airplane.getModel(), airplane.getDescription());
            } catch (TechnicalException ex) {
                System.out.println("un erreur".concat(ex.getMessage()));
                return null;
            }
        } else {
            throw new FunctionalException("Missing required data for this action");
        }
    }

    @Override
    public void removeAirplane(String code) {
        try {
            provider.deleteAirplane(code);
        } catch (TechnicalException e) {
            throw new TechnicalException("Connection error with the database");
        }
    }

    @Override
    public Airplane changeModel(Airplane airplane, String model) {
        if (airplane.getCode() != null) {
            if (model != null && !model.isEmpty()) {
                return provider.updateAirplaneModel(airplane.getCode(), model);
            } else {
                throw new FunctionalException("Description must not be null or empty");
            }
        } else {
            throw new FunctionalException("Missing required data for this action");
        }
    }

    @Override
    public Airplane getAirplaneByCode(String code) {
        if (code == null) {
            throw new FunctionalException("Missing required data for this action");
        }
        return provider.getAirplaneByCode(code);
    }
}
