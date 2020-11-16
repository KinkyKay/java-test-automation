package io.hackages.learning.api.controller;

import io.hackages.learning.domain.manager.airplane.core.AirplaneServiceImpl;
import io.hackages.learning.domain.model.Airplane;
import io.hackages.learning.repository.AirplaneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.List;

@RestController
@RequestMapping("airplanes")
@Validated
public class AirplaneController {

    private AirplaneRepository airplaneRepository;

    @Bean
    private AirplaneServiceImpl getAirplaneService() {
        return new AirplaneServiceImpl(airplaneRepository);
    }

    @Autowired
    public AirplaneController(AirplaneRepository airplaneRepository){
        this.airplaneRepository = airplaneRepository;
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    List<Airplane> getAirplanes() {
        return getAirplaneService().getAirplanes();
    }

    @GetMapping(value = "/{code}", produces = MediaType.APPLICATION_JSON_VALUE)
    Airplane getAirplaneByCode(@PathVariable @Size(min = 5, max = 5) String code) {
        return getAirplaneService().getAirplaneByCode(code);
    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    Airplane addAirplane(@RequestBody final Airplane airplane) {
        return getAirplaneService().addAirplane(airplane);
    }

}
