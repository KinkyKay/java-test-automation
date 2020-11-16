package io.hackages.learning.domain.manager.flight.spi;

import io.hackages.learning.domain.model.Flight;

import java.util.List;

public interface FlightServiceProvider {

    List<Flight> getFlights();

    List<Flight> getFlightByOrigin(String origin);

    List<Flight> getFlightByDestination(String destination);

    Flight saveFlight(Flight flight);
}
