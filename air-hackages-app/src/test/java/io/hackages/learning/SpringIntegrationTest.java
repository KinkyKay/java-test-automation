package io.hackages.learning;

import io.cucumber.spring.CucumberContextConfiguration;
import io.hackages.learning.domain.model.Aircraft;
import io.hackages.learning.repository.dao.AircraftDao;
import io.hackages.learning.repository.dao.FlightDao;
import io.hackages.learning.repository.model.AircraftEntity;
import io.hackages.learning.repository.model.FlightEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpMethod;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.web.client.ResponseErrorHandler;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CucumberContextConfiguration
@SpringBootTest(classes = Application.class, webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class SpringIntegrationTest {
    public static ResponseResults latestResponse = null;

    public static Object resultObject = null;

    private RestTemplate restTemplate;

    @Autowired
    AircraftDao aircraftDao;

    @Autowired
    FlightDao flightDao;

    public SpringIntegrationTest(RestTemplateBuilder builder) {
        this.restTemplate = builder.build();
    }

    void executeGet(String url) throws IOException {
        final Map<String, String> headers = new HashMap<>();
        headers.put("Accept", "application/json");
        final HeaderSettingRequestCallback requestCallback = new HeaderSettingRequestCallback(headers);
        final ResponseResultErrorHandler errorHandler = new ResponseResultErrorHandler();

        restTemplate.setErrorHandler(errorHandler);
        latestResponse = restTemplate.execute(url, HttpMethod.GET, requestCallback, response -> {
            if (errorHandler.hadError) {
                return (errorHandler.getResults());
            } else {
                return (new ResponseResults(response));
            }
        });
    }

    void executePost(Object data) throws IOException {
        final Map<String, String> headers = new HashMap<>();
        headers.put("Accept", "application/json");
        final HeaderSettingRequestCallback requestCallback = new HeaderSettingRequestCallback(headers);
        final ResponseResultErrorHandler errorHandler = new ResponseResultErrorHandler();

        if (restTemplate == null) {
            restTemplate = new RestTemplate();
        }

        restTemplate.setErrorHandler(errorHandler);

        resultObject = restTemplate.postForObject("http://localhost:5000/aircrafts", data, Object.class);
    }

    void cleanDatabase() {
        flightDao.deleteAll();
        aircraftDao.deleteAll();
    }

    void setupAircraftDatabase(List<AircraftEntity> aircrafts) {
        aircraftDao.saveAll(aircrafts);
    }

    void setupFlightDatabase(List<FlightEntity> flightEntities) {
        flightDao.saveAll(flightEntities);
    }

    AircraftEntity getAircraftById(Long id) {
        return aircraftDao.findById(id).get();
    }

    AircraftEntity getAircraftBycode (String code) {
        return aircraftDao.findByCode(code);
    }

    private class ResponseResultErrorHandler implements ResponseErrorHandler {
        private ResponseResults results = null;
        private Boolean hadError = false;

        private ResponseResults getResults() {
            return results;
        }

        @Override
        public boolean hasError(ClientHttpResponse response) throws IOException {
            hadError = response.getRawStatusCode() >= 400;
            return hadError;
        }

        @Override
        public void handleError(ClientHttpResponse response) throws IOException {
            results = new ResponseResults(response);
        }
    }

}
