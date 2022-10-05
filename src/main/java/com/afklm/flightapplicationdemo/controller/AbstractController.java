package com.afklm.flightapplicationdemo.controller;

import com.afklm.flightapplicationdemo.Util.FlightError;
import com.afklm.flightapplicationdemo.model.ErrorSeverityLevelCodeType;
import com.afklm.flightapplicationdemo.model.ErrorResponse;
import com.afklm.flightapplicationdemo.model.Error;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.servlet.http.HttpServletRequest;
import java.util.Collections;

public abstract class AbstractController {
    /**
     * Exception handler for update failed exception.
     *
     * @param request   the {@link HttpServletRequest}
     * @param exception the exception
     * @return the error response which contains error code and message
     */
    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ErrorResponse handleException(HttpServletRequest request, Exception exception) {
        exception.printStackTrace();
        final Error error = new Error(FlightError.INTERNAL_ERROR, FlightError.INTERNAL_ERROR_CODE, ErrorSeverityLevelCodeType.ERROR);
        return new ErrorResponse(Collections.singletonList(error));
    }
}
