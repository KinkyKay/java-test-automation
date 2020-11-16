package io.hackages.learning.repository;

import io.hackages.learning.domain.manager.flight.spi.FlightServiceProvider;
import io.hackages.learning.domain.model.Flight;
import io.hackages.learning.repository.dao.FlightDao;
import io.hackages.learning.repository.model.FlightEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class FlightRepository implements FlightServiceProvider {

    @Autowired
    FlightDao flightDao;

    public FlightRepository() {
    }

    @Override
    public List<Flight> getFlights() {
        List<Flight> flights = new ArrayList<>();
        for(FlightEntity flightEntity: flightDao.findAll()) {
            flights.add(this.flightEntityToFlight(flightEntity));
        }
        return flights;
    }

    @Override
    public List<Flight> getFlightByOrigin(String origin) {
        List<Flight> flights = new ArrayList<>();
        for(FlightEntity flightEntity: flightDao.findByOrigin(origin)) {
            flights.add(this.flightEntityToFlight(flightEntity));
        }
        return flights;
    }

    @Override
    public List<Flight> getFlightByDestination(String destination) {
        List<Flight> flights = new ArrayList<>();
        for(FlightEntity flightEntity: flightDao.findByDestination(destination)) {
            flights.add(this.flightEntityToFlight(flightEntity));
        }
        return flights;
    }

    @Override
    public Flight saveFlight(Flight flight) {
        FlightEntity flightEntity = flightDao.save(this.flightToFlightEntity(flight));
        return this.flightEntityToFlight(flightEntity);
    }

    private Flight flightEntityToFlight(FlightEntity flightEntity) {
        return new Flight(
                flightEntity.getId(),
                flightEntity.getType(),
                flightEntity.getOrigin(),
                flightEntity.getDestination(),
                flightEntity.getDepartureDate(),
                flightEntity.getArrivalDate(),
                AirplaneRepository.airplaneEntityToAirplane(flightEntity.getAirplane())
        );
    }

    private FlightEntity flightToFlightEntity(Flight flight) {
        return new FlightEntity(
                flight.getType(),
                flight.getOrigin(),
                flight.getDestination(),
                flight.getDepartureDate(),
                flight.getArrivalDate(),
                AirplaneRepository.airplaneToAirplaneEntity(flight.getAirplane())
        );
    }
}
