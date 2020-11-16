package io.hackages.learning.api.controller;

import io.hackages.learning.repository.FlightRepository;
import io.hackages.learning.domain.manager.flight.core.FlightServiceImpl;
import io.hackages.learning.domain.model.Flight;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("flights")
public class FlightController {

    private FlightRepository flightRepository;

    @Bean
    private FlightServiceImpl getFlightService() {
        return new FlightServiceImpl(flightRepository);
    }

    @Autowired
    public FlightController(FlightRepository flightRepository){
        this.flightRepository = flightRepository;
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    List<Flight> getFlights(@RequestParam Map<String, String> parameters) {
        return getFlightService().getFlights();
    }

    @GetMapping(value = "/origin/{origin}", produces = MediaType.APPLICATION_JSON_VALUE)
    List<Flight> getFlightsByOrigin(@PathVariable String origin) {
        return getFlightService().getFlightByOrigin(origin);
    }

    @GetMapping(value = "/destination/{destination}", produces = MediaType.APPLICATION_JSON_VALUE)
    List<Flight> getFlightsByDestination(@PathVariable String destination) {
        return getFlightService().getFlightByDestination(destination);
    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    Flight addFlight(@RequestBody Flight flight) {
        return getFlightService().addFlight(flight);
    }
}
