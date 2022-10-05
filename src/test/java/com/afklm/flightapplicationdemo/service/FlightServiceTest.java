package com.afklm.flightapplicationdemo.service;

import com.afklm.flightapplicationdemo.exception.ValidationException;
import com.afklm.flightapplicationdemo.model.Airport;
import com.afklm.flightapplicationdemo.model.Flight;
import com.afklm.flightapplicationdemo.persistance.FlightDao;
import com.afklm.flightapplicationdemo.repository.FlightRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

/**
 * Test class for the flight service
 *
 * @author t765566
 */
@ExtendWith(MockitoExtension.class)
class FlightServiceTest {

    @InjectMocks
    private FlightService flightService;

    @Mock
    private FlightRepository flightRepository;

    @Test
    void testGetAllFlightsByFlightNumber() throws ValidationException {
        when(flightRepository.getFlightsByFlightNumber(any(String.class))).thenReturn(Collections.singletonList(this.createFlightDao()));
        List<Flight> flightList = flightService.getAllFlightsByFlightNumber("KL1001");
        assertNotNull(flightList);
    }

    @Test
    void testGetAllFlightsByFlightNumberWithNullFlightNumber() {
        ValidationException exception = Assertions.assertThrows(ValidationException.class, () -> flightService.getAllFlightsByFlightNumber(null));
        assertNotNull(exception);
    }

    @Test
    void testGetFlightsByFlightId() throws ValidationException {
        when(flightRepository.getFlightByFlightId(any(Integer.class))).thenReturn(this.createFlightDao());
        Flight flight = flightService.getFlightsByFlightId(1);
        assertNotNull(flight);
    }

    @Test
    void testGetFlightsByFlightIdWithNullFlightId() {
        ValidationException exception = Assertions.assertThrows(ValidationException.class, () -> flightService.getFlightsByFlightId(null));
        assertNotNull(exception);
    }

    @Test
    void testGetFlightByOriginAndDestination() throws ValidationException {
        when(flightRepository.getFlightsByFlightOriginAndDestination(any(String.class), any(String.class))).thenReturn(Collections.singletonList(this.createFlightDao()));
        List<Flight> flightList = flightService.getFlightByOriginAndDestination("ABS", "CHN");
        assertNotNull(flightList);
    }

    @Test
    void testGetFlightByOriginAndDestinationWithNullValue() {
        ValidationException exception = Assertions.assertThrows(ValidationException.class, () -> flightService.getFlightByOriginAndDestination(null, null));
        assertNotNull(exception);
    }

    @Test
    void testDeleteByFlightId() throws ValidationException {
        flightService.deleteByFlightId(1);
    }

    @Test
    void testDeleteByFlightIdWithNullValue() {
        ValidationException exception = Assertions.assertThrows(ValidationException.class, () -> flightService.deleteByFlightId(null));
        assertNotNull(exception);
    }

    @Test
    void testCreateFlight() {
        Flight flight = flightService.createFlight(this.createFlight());
        assertNotNull(flight);
    }

    @Test
    void testUpdateFlight() {
        Flight flight = flightService.updateFlight(1, createFlight());
        assertNotNull(flight);
    }

    public Flight createFlight() {
        Flight flight = new Flight();
        Airport airportOrigin = new Airport();
        Airport airportDestination = new Airport();
        airportOrigin.setCode("airport1001");
        airportDestination.setCode("airport1009");
        flight.setFlightId(1);
        flight.setFlightNumber("TEST1001");
        flight.setDestination(airportOrigin);
        flight.setOrigin(airportDestination);
        flight.setDuration(LocalDateTime.now());
        return flight;
    }

    public FlightDao createFlightDao() {
        FlightDao flightDao = new FlightDao();
        Airport airportOrigin = new Airport();
        Airport airportDestination = new Airport();
        airportOrigin.setCode("airport1001");
        airportDestination.setCode("airport1009");
        flightDao.setFlightId(1);
        flightDao.setFlightNumber("TEST1001");
        flightDao.setDestinationCode(airportOrigin.getCode());
        flightDao.setDestinationCode(airportDestination.getCode());
        flightDao.setDuration(LocalDateTime.now());
        return flightDao;
    }

}


