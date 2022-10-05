package com.afklm.flightapplicationdemo.mapper;


import com.afklm.flightapplicationdemo.model.Airport;
import com.afklm.flightapplicationdemo.model.Flight;
import com.afklm.flightapplicationdemo.persistance.FlightDao;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;

/**
 * Test class for FlightDomainToDaoMapper
 *
 * @author t765566
 */
class FlightDomainToDaoMapperTest {

    @Test
    void testGetMapToFlightAsList() {
        List<FlightDao> flightListDao = FlightDomainToDaoMapper.mapToFlightDaoAsList(Collections.singletonList(createFlight()));
        assertNotNull(flightListDao);
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