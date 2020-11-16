package io.hackages.learning.domain.manager.flight.core;

import io.hackages.learning.domain.manager.flight.api.FlightService;
import io.hackages.learning.domain.manager.flight.spi.FlightServiceProvider;
import io.hackages.learning.domain.model.Flight;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class FlightServiceImpl implements FlightService {

    private final FlightServiceProvider provider;

    public FlightServiceImpl(FlightServiceProvider provider) {
        this.provider = provider;
    }

    @Override
    public List<Flight> getFlights() {
        return provider.getFlights();
    }

    public List<Flight> getFilteredFlights(Map<String, String> parameters) {
        List<Flight> flights = provider.getFlights();
        if (parameters != null && !parameters.isEmpty()) {
            String  param = parameters.get("origin");
            flights = flights.stream().filter(flight -> flight.getOrigin().equals(param)).collect(Collectors.toList());
        }
        return flights;
    }

    @Override
    public List<Flight> getFlightByOrigin(String origin) {
        return provider.getFlightByOrigin(origin);
    }

    @Override
    public List<Flight> getFlightByDestination(String destination) {
        return provider.getFlightByDestination(destination);
    }

    @Override
    public Flight addFlight(Flight flight) {
        return provider.saveFlight(flight);
    }
}
