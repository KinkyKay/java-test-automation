package io.hackages.learning.repository;

import io.hackages.learning.domain.exception.TechnicalException;
import io.hackages.learning.domain.manager.airplane.spi.AirplaneServiceProvider;
import io.hackages.learning.domain.model.Airplane;
import io.hackages.learning.repository.dao.AirplaneDao;
import io.hackages.learning.repository.model.AirplaneEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class AirplaneRepository implements AirplaneServiceProvider {

    @Autowired
    AirplaneDao airplaneDao;

    @Override
    public List<Airplane> getAirplanes() {
        List<Airplane> airplanes = new ArrayList<>();
        for(AirplaneEntity airplane  : airplaneDao.findAll()) {
            airplanes.add(this.airplaneEntityToAirplane(airplane));
        }
        return airplanes;
    }

    @Override
    public Airplane addAirplane(String code, String model, String description) {
        try {
            AirplaneEntity airplaneEntity = airplaneDao.save(new AirplaneEntity(code, model, description));
            return this.airplaneEntityToAirplane(airplaneEntity);
        } catch (Exception ex) {
            throw new TechnicalException(ex.getMessage());
        }
    }

    @Override
    public void deleteAirplane(String code) throws TechnicalException {
        airplaneDao.deleteByCode(code);
    }

    @Override
    public Airplane updateAirplaneModel(String code, String model) throws TechnicalException {
        AirplaneEntity airplaneByCode = airplaneDao.findByCode(code);
        airplaneByCode.setModel(model);
        AirplaneEntity airplaneEntity = airplaneDao.save(airplaneByCode);
        return new Airplane(airplaneByCode.getCode(), airplaneByCode.getModel(), airplaneByCode.getDescription());
    }

    @Override
    public Airplane getAirplaneByCode(String code) {
        AirplaneEntity airplane = airplaneDao.findByCode(code);
        return new Airplane(airplane.getCode(), airplane.getModel(), airplane.getDescription());
    }

    static Airplane airplaneEntityToAirplane(AirplaneEntity airplaneEntity) {
        return new Airplane(airplaneEntity.getId(), airplaneEntity.getCode(), airplaneEntity.getModel(), airplaneEntity.getDescription());
    }

    static AirplaneEntity airplaneToAirplaneEntity(Airplane airplane) {
        return new AirplaneEntity(airplane.getCode(), airplane.getModel(), airplane.getDescription());
    }
}
