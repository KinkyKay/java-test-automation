package io.hackages.learning.domain.manager.airplane.core;

import io.hackages.learning.domain.exception.FunctionalException;
import io.hackages.learning.domain.exception.TechnicalException;
import io.hackages.learning.domain.manager.airplane.spi.AirplaneServiceProvider;
import io.hackages.learning.domain.model.Airplane;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

public class AirplaneServiceImplTest {

    @Mock
    AirplaneServiceProvider provider;

    @InjectMocks
    AirplaneServiceImpl aircraftService;

    @Before
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void givenNothing_whenGetAirplanes_thenSucceed() {
        //Given
        Airplane airplane = mock(Airplane.class);
        when(provider.getAirplanes()).thenReturn(Arrays.asList(airplane, airplane, airplane));
        //When
        List<Airplane> airplanes = aircraftService.getAirplanes();
        //Then
        assertThat(airplanes.size()).isEqualTo(3);
    }

    @Test(expected = FunctionalException.class)
    public void givenNullCode_whenAddAircraft_thenThrowFunctionException() {
        //When
        aircraftService.addAirplane(new Airplane(null,"A343", "Airbus A340-300"));
    }

    @Test
    public void giveCode_whenDeleteAircraft_thenSucceed() throws Exception {
        //Give
        aircraftService.removeAirplane("AH111");
        //Then
        verify(provider, times(1)).deleteAirplane("AH111");
    }

    @Test(expected = FunctionalException.class)
    public void giveCode_whenDeleteAircraft_thenThrowFunctionalError() throws Exception {
        //When
        Mockito.doThrow(FunctionalException.class).when(provider).deleteAirplane("007");
        //Give
        aircraftService.removeAirplane("007");
    }

    @Test
    public void giveCode_whenDeleteAircraft_thenThrowTechnicalException() throws Exception {
        //When
        Mockito.doThrow(TechnicalException.class).when(provider).deleteAirplane("0011");
        //Give
        try {
            aircraftService.removeAirplane("0011");
        } catch (TechnicalException ex) {
            assertThat(ex.getMessage()).isEqualTo("Connection error with the database");
        }
    }

    @Test
    public void giveCode_whenGetAircraftByCode_thenWeSucceedToGetOneAircraft() {
        //When
        Airplane airplane = new Airplane("AH007", "A342", "Airbus A340-200");
        Mockito.when(provider.getAirplaneByCode("AH007")).thenReturn(airplane);

        //Give
        Airplane result = aircraftService.getAirplaneByCode("AH007");

        // Then
        assertThat(result).isEqualTo(airplane);
    }

    @Test
    public void giveNull_whenAircraftByCode_then_fail() {
        //When
        // This call will return a functional exception
        //Give
        try {
            Airplane result = aircraftService.getAirplaneByCode(null);
            // Then
        } catch (FunctionalException ex) {
            assertThat(ex.getMessage()).isEqualTo("Missing required data for this action");
        }
    }

}