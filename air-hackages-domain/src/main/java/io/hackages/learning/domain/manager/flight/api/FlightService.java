package io.hackages.learning.domain.manager.flight.api;

import io.hackages.learning.domain.model.Flight;

import java.util.List;
import java.util.Map;

public interface FlightService {

    List<Flight> getFlights();

    List<Flight> getFlightByOrigin(String origin);

    List<Flight> getFlightByDestination(String destination);

    Flight addFlight(Flight flight);

}
