package io.hackages.learning;

import io.cucumber.spring.CucumberContextConfiguration;
import io.hackages.learning.repository.dao.AirplaneDao;
import io.hackages.learning.repository.dao.FlightDao;
import io.hackages.learning.repository.model.AirplaneEntity;
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
    AirplaneDao airplaneDao;

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

    void executePost(String endpoint, Object data) throws IOException {
        final Map<String, String> headers = new HashMap<>();
        headers.put("Accept", "application/json");
        final HeaderSettingRequestCallback requestCallback = new HeaderSettingRequestCallback(headers);
        final ResponseResultErrorHandler errorHandler = new ResponseResultErrorHandler();

        if (restTemplate == null) {
            restTemplate = new RestTemplate();
        }

        restTemplate.setErrorHandler(errorHandler);

        resultObject = restTemplate.postForObject("http://localhost:5000/".concat(endpoint), data, Object.class);
    }

    void cleanDatabase() {
        flightDao.deleteAll();
        airplaneDao.deleteAll();
    }

    void setupAirplaneDatabase(List<AirplaneEntity> airplanes) {
        airplaneDao.saveAll(airplanes);
    }

    void setupFlightDatabase(List<FlightEntity> flightEntities) {
        flightDao.saveAll(flightEntities);
    }

    AirplaneEntity getAirplaneById(Long id) {
        return airplaneDao.findById(id).get();
    }

    AirplaneEntity getAirplaneBycode (String code) {
        return airplaneDao.findByCode(code);
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
