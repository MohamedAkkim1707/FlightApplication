
package com.afklm.flightapplicationdemo.exception;

import java.util.ArrayList;
import java.util.List;

import com.afklm.flightapplicationdemo.model.Error;

/**
 * Custom exception class to handle functional errors
 *
 * @author t765566
 */
public class FunctionalException extends Exception {

    private final List<Error> errors = new ArrayList<>();

    /**
     * Constructor to initialize functional exception with list of errors
     *
     * @param errors the errors
     */
    public FunctionalException(List<Error> errors) {
        this.errors.addAll(errors);
    }

    /**
     * Constructor to initialize functional exception with list of error
     *
     * @param error the error
     */
    public FunctionalException(Error error) {
        this.errors.add(error);
    }
}