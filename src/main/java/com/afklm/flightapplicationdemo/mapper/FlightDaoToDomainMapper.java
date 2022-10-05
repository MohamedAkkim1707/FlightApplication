
package com.afklm.flightapplicationdemo.mapper;

import com.afklm.flightapplicationdemo.model.Flight;
import com.afklm.flightapplicationdemo.model.Airport;
import com.afklm.flightapplicationdemo.persistance.FlightDao;
import org.springframework.util.CollectionUtils;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Mapper class to convert flight dao to domain
 *
 * @author t765566
 */
public final class FlightDaoToDomainMapper {
    private FlightDaoToDomainMapper() {
    }

    /**
     * Method which takes list of dao  flight and transforms to list of domain  flight
     *
     * @param flightDaoList the list of  flightDaos
     * @return list of  flights
     */
    public static List<Flight> mapToFlightAsList(final List<FlightDao> flightDaoList) {
        if (CollectionUtils.isEmpty(flightDaoList)) {
            return Collections.emptyList();
        }
        return flightDaoList.stream()
                .map(FlightDaoToDomainMapper::mapToFlight)
                .collect(Collectors.toList());
    }

    /**
     * Method which takes dao flight and transforms to domain flight
     *
     * @param flightDao the dao of flightDao
     * @return the domain flight
     */
    public static Flight mapToFlight(final FlightDao flightDao) {
        Flight flight = new Flight();
        if (flightDao == null) {
            return flight;
        }
        Airport airportOrigin = new Airport();
        Airport airportDestination = new Airport();
        airportDestination.setCode(flightDao.getDestinationCode());
        airportOrigin.setCode(flightDao.getOriginCode());
        flight.setFlightId(flightDao.getFlightId());
        flight.setOrigin(airportOrigin);
        flight.setDestination(airportDestination);
        flight.setDuration(flightDao.getDuration());
        flight.setFlightNumber(flightDao.getFlightNumber());
        return flight;
    }

}
