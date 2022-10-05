package com.afklm.flightapplicationdemo.service;

import com.afklm.flightapplicationdemo.Util.ErrorUtil;
import com.afklm.flightapplicationdemo.exception.ValidationException;
import com.afklm.flightapplicationdemo.mapper.FlightDaoToDomainMapper;
import com.afklm.flightapplicationdemo.mapper.FlightDomainToDaoMapper;
import com.afklm.flightapplicationdemo.model.Flight;
import com.afklm.flightapplicationdemo.repository.FlightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Service class to handle flight
 *
 * @author t765566
 */
@Service
public class FlightService {

    @Autowired
    private FlightRepository flightRepository;

    /**
     * Method to get flights by flightNumber
     *
     * @param flightNumber the flight Number
     * @return the List flight domain
     * @throws ValidationException in case of any validation exception
     */
    public List<Flight> getAllFlightsByFlightNumber(final String flightNumber) throws ValidationException {
        if (flightNumber == null) {
            throw new ValidationException(ErrorUtil.createMissingMandatoryInputError("flightNumber"));
        }
        return FlightDaoToDomainMapper.mapToFlightAsList(flightRepository.getFlightsByFlightNumber(flightNumber));
    }

    /**
     * Method to get flight by flight id
     *
     * @param flightId the flight id
     * @return the flight domain
     * @throws ValidationException in case of any validation exception
     */
    public Flight getFlightsByFlightId(final Integer flightId) throws ValidationException {
        if (flightId == null) {
            throw new ValidationException(ErrorUtil.createMissingMandatoryInputError("flightId"));
        }
        return FlightDaoToDomainMapper.mapToFlight(flightRepository.getFlightByFlightId(flightId));
    }

    /**
     * Method to get flight by origin and destination
     *
     * @param originCode  the origin code
     * @param destination the destination code
     * @return the list of flights
     * @throws ValidationException in case of any validation exception
     */
    public List<Flight> getFlightByOriginAndDestination(final String originCode, final String destination) throws ValidationException {
        if (originCode == null || destination == null) {
            throw new ValidationException(ErrorUtil.createMissingMandatoryInputError("origin and  destination"));
        }
        return FlightDaoToDomainMapper.mapToFlightAsList(flightRepository.getFlightsByFlightOriginAndDestination(originCode, destination));
    }

    /**
     * Method to delete by flight id
     *
     * @param flightId the flight id
     * @throws ValidationException in case of any validation exception
     */
    public void deleteByFlightId(final Integer flightId) throws ValidationException {
        if (flightId == null) {
            throw new ValidationException(ErrorUtil.createMissingMandatoryInputError("flightId"));
        }
        flightRepository.deleteById(flightId);
    }

    /**
     * Method to create the new flight
     *
     * @param requestData the request data
     * @return the created flight
     */
    public Flight createFlight(final Flight requestData) {
        return FlightDaoToDomainMapper.mapToFlight(flightRepository.saveAndFlush(FlightDomainToDaoMapper.mapToFlightDao(requestData)));
    }

    /**
     * Method to update the flight by flight id
     *
     * @param flightId       the flight id
     * @param flightToUpdate the flight to update
     * @return the updated flight domain
     */
    public Flight updateFlight(final Integer flightId, final Flight flightToUpdate) {
        final Flight validateFlight = FlightDaoToDomainMapper.mapToFlight(flightRepository.getFlightByFlightId(flightId));
        validateFlight.setDuration(flightToUpdate.getDuration());
        validateFlight.setDestination(flightToUpdate.getDestination());
        validateFlight.setOrigin(flightToUpdate.getOrigin());
        return FlightDaoToDomainMapper.mapToFlight(flightRepository.saveAndFlush(FlightDomainToDaoMapper.mapToFlightDao(validateFlight)));
    }
}
