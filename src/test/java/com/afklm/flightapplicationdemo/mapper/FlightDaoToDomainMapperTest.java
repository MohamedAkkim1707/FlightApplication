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
 * Test class for FlightDaoToDomainMapper
 *
 * @author t765566
 */
class FlightDaoToDomainMapperTest {

    @Test
    void testGetMapToFlightAsList() {
        List<Flight> flightList = FlightDaoToDomainMapper.mapToFlightAsList(Collections.singletonList(createFlightDao()));
        assertNotNull(flightList);
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