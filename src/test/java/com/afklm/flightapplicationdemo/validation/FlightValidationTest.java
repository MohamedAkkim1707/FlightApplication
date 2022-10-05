package com.afklm.flightapplicationdemo.validation;

import com.afklm.flightapplicationdemo.exception.ValidationException;
import com.afklm.flightapplicationdemo.model.Airport;
import com.afklm.flightapplicationdemo.model.Flight;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertNotNull;

/**
 * Test class for the FlightValidation
 *
 * @author t765566
 */
@ExtendWith(MockitoExtension.class)
class FlightValidationTest {

    @InjectMocks
    private FlightValidation flightValidation;

    @Test
    void validateFlightRequestData() throws ValidationException {
        Flight flight = flightValidation.validateFlightRequestData(createFlight());
        assertNotNull(flight);
    }

    @Test
    void validateFlightRequestDataWithNullFlightNumber() {
        Flight flight = new Flight();
        Airport airportOrigin = new Airport();
        Airport airportDestination = new Airport();
        airportOrigin.setCode("airport1001");
        airportDestination.setCode("airport1009");
        flight.setFlightId(1);
        flight.setDestination(airportOrigin);
        flight.setOrigin(airportDestination);
        flight.setDuration(LocalDateTime.now());
        ValidationException exception = Assertions.assertThrows(ValidationException.class, () -> flightValidation.validateFlightRequestData(flight));
        assertNotNull(exception);
    }

    @Test
    void validateFlightRequestDataWithNullOrigin() {
        Flight flight = new Flight();
        Airport airportOrigin = new Airport();
        Airport airportDestination = new Airport();
        airportOrigin.setCode(null);
        airportDestination.setCode("airport1009");
        flight.setFlightId(1);
        flight.setFlightNumber("TEST1001");
        flight.setDestination(airportOrigin);
        flight.setOrigin(airportDestination);
        flight.setDuration(LocalDateTime.now());
        ValidationException exception = Assertions.assertThrows(ValidationException.class, () -> flightValidation.validateFlightRequestData(flight));
        assertNotNull(exception);
    }

    @Test
    void validateFlightRequestDataWithNullDestination() {
        Flight flight = new Flight();
        Airport airportOrigin = new Airport();
        Airport airportDestination = new Airport();
        airportOrigin.setCode("ABS");
        airportDestination.setCode(null);
        flight.setFlightId(1);
        flight.setFlightNumber("TEST1001");
        flight.setDestination(airportOrigin);
        flight.setOrigin(airportDestination);
        flight.setDuration(LocalDateTime.now());
        ValidationException exception = Assertions.assertThrows(ValidationException.class, () -> flightValidation.validateFlightRequestData(flight));
        assertNotNull(exception);
    }

    @Test
    void validateFlightRequestDataWithNullDuration() {
        Flight flight = new Flight();
        Airport airportOrigin = new Airport();
        Airport airportDestination = new Airport();
        airportOrigin.setCode("airport1001");
        airportDestination.setCode("airport1009");
        flight.setFlightId(1);
        flight.setFlightNumber("TEST1001");
        flight.setDestination(airportOrigin);
        flight.setOrigin(airportDestination);
        flight.setDuration(null);
        ValidationException exception = Assertions.assertThrows(ValidationException.class, () -> flightValidation.validateFlightRequestData(flight));
        assertNotNull(exception);
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
}