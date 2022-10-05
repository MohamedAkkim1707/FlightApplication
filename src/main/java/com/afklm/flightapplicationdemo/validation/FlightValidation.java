package com.afklm.flightapplicationdemo.validation;

import com.afklm.flightapplicationdemo.Util.ErrorUtil;
import com.afklm.flightapplicationdemo.exception.ValidationException;
import com.afklm.flightapplicationdemo.model.Flight;
import lombok.AllArgsConstructor;

/**
 * Class contains validation for creating flight
 *
 * @author t765566
 */
@org.springframework.stereotype.Component
@AllArgsConstructor
public class FlightValidation {

    /**
     * Method to validate the create flight request data
     *
     * @param requestData the flight request data
     * @return the validated flight
     * @throws ValidationException in case of any exception
     */
    public Flight validateFlightRequestData(Flight requestData) throws ValidationException {

        Flight validatedFlight = new Flight();
        if (requestData.getFlightNumber() == null) {
            throw new ValidationException(ErrorUtil.createMissingMandatoryInputError("flightNumber"));
        } else if (requestData.getOrigin().getCode() == null) {
            throw new ValidationException(ErrorUtil.createMissingMandatoryInputError("origin"));
        } else if (requestData.getDestination().getCode() == null) {
            throw new ValidationException(ErrorUtil.createMissingMandatoryInputError("destination"));
        } else if (requestData.getDuration() == null) {
            throw new ValidationException(ErrorUtil.createMissingMandatoryInputError("duration"));
        } else {
            validatedFlight.setOrigin(requestData.getOrigin());
            validatedFlight.setDestination(requestData.getDestination());
            validatedFlight.setFlightNumber(requestData.getFlightNumber());
            validatedFlight.setDuration(requestData.getDuration());
        }
        return validatedFlight;
    }

}
