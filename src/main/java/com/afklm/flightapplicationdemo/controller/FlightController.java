package com.afklm.flightapplicationdemo.controller;

import com.afklm.flightapplicationdemo.exception.ValidationException;
import com.afklm.flightapplicationdemo.model.Flight;
import com.afklm.flightapplicationdemo.service.FlightService;
import com.afklm.flightapplicationdemo.validation.FlightValidation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

/**
 * controller class of flight
 *
 * @author t765566
 */
@RequestMapping("/afklm")
@RestController
public class FlightController extends AbstractController{

    @Autowired
    private FlightService flightService;

    @Autowired
    private FlightValidation flightValidation;

    public FlightController(FlightService flightService, FlightValidation flightValidation) {
        this.flightValidation = flightValidation;
        this.flightService = flightService;
    }

    /**
     * Method to get flights by flight number
     *
     * @param requestData the flight request data
     * @return the list of flights
     */
    @GetMapping(value = "/flight", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public List<Flight> getAllFlights(@RequestBody Flight requestData) throws ValidationException {
        return flightService.getAllFlightsByFlightNumber(requestData.getFlightNumber());
    }

    /**
     * Method to get flight by flight id
     *
     * @param flightId the flight id
     * @return the domain flight
     */
    @GetMapping(value = "/flight/{flightId}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public Flight getFlightsByFlightId(@PathVariable Integer flightId) throws ValidationException {
        return flightService.getFlightsByFlightId(flightId);
    }

    /**
     * Method to get flights by origin and destination
     *
     * @param requestData the flight request data
     * @return the list of flights
     */
    @GetMapping(value = "/flights", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public List<Flight> getFlightsByOriginAndDestination(@RequestBody Flight requestData) throws ValidationException {
        return flightService.getFlightByOriginAndDestination(requestData.getOrigin().getCode(), requestData.getDestination().getCode());
    }

    /**
     * Method to get flight by flight id
     *
     * @param flightId the flight id
     */
    @DeleteMapping(value = "/flight/{flightId}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public void deleteFlightByFlightId(@PathVariable Integer flightId) throws ValidationException {
        flightService.deleteByFlightId(flightId);
    }

    /**
     * Method to create new flight
     *
     * @param requestData the request data
     * @return the created flight domain
     */
    @PostMapping(value = "/flight", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public Flight createFlight(@RequestBody Flight requestData) throws ValidationException {
        final Flight validatedFlight = flightValidation.validateFlightRequestData(requestData);
        return flightService.createFlight(validatedFlight);
    }

    /**
     * Method to update flight by flight id
     *
     * @param flightId the flight id
     * @param flight   the flight domain
     * @return the update flight
     */
    @PutMapping(value = "/flight/{flightId}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public Flight updateFlight(@PathVariable Integer flightId, @RequestBody Flight flight) throws ValidationException {
        final Flight validatedFlight = flightValidation.validateFlightRequestData(flight);
        return flightService.updateFlight(flightId, validatedFlight);
    }
}
