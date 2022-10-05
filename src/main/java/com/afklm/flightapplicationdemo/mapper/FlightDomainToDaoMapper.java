package com.afklm.flightapplicationdemo.mapper;

import com.afklm.flightapplicationdemo.model.Flight;
import com.afklm.flightapplicationdemo.persistance.FlightDao;
import org.springframework.util.CollectionUtils;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Mapper class to convert flight domain to dao
 *
 * @author t765566
 */
public class FlightDomainToDaoMapper {

    public FlightDomainToDaoMapper() {
    }

    /**
     * Method which takes list of  flights and transforms to list of dao flights
     *
     * @param flightList the list of  flights
     * @return list of  flightDaos
     */
    public static List<FlightDao> mapToFlightDaoAsList(final List<Flight> flightList) {
        if (CollectionUtils.isEmpty(flightList)) {
            return Collections.emptyList();
        }
        return flightList.stream()
                .map(FlightDomainToDaoMapper::mapToFlightDao)
                .collect(Collectors.toList());
    }

    /**
     * Method which takes domain flight and transforms to dao flight
     *
     * @param flight the domain of flight
     * @return the flightDao
     */
    public static FlightDao mapToFlightDao(final Flight flight) {
        FlightDao flightDao = new FlightDao();
        if (flight == null) {
            return flightDao;
        }
        flightDao.setFlightId(flight.getFlightId());
        flightDao.setDuration(flight.getDuration());
        flightDao.setFlightNumber(flight.getFlightNumber());
        flightDao.setOriginCode(flight.getOrigin().getCode());
        flightDao.setDestinationCode(flight.getDestination().getCode());
        return flightDao;
    }
}
